package com.project.tedi.service;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.tedi.dto.RegisterRequest;
import com.project.tedi.exception.NotLoggedInException;
import com.project.tedi.model.User;
import com.project.tedi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final PhotoService photoServ;
	private final UserRepository userRepo;
	
	public User details(){
		User loggedIn=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedIn==null) {
			throw new NotLoggedInException("User not logged in");
		}
		else return loggedIn; 
	}
	
	public void updateDetails(RegisterRequest regReq,Optional<MultipartFile> photo) {
		User loggedIn=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedIn==null) {
			throw new NotLoggedInException("User not logged in");
		}
		if (regReq.getEmail()!=null) loggedIn.setEmail(regReq.getEmail());
		if (regReq.getFirstName()!=null) loggedIn.setFirstName(regReq.getFirstName());
		if (regReq.getLastName()!=null) loggedIn.setLastName(regReq.getLastName());
		if (regReq.getUsername()!=null) loggedIn.setUsername(regReq.getUsername());
		if (regReq.getPhone()!=null) loggedIn.setPhone(regReq.getPhone());
		if(photo.isPresent()) {
			String prev=loggedIn.getPhotoUrl(); 
			loggedIn.setPhotoUrl(photoServ.savePhoto(photo.get()));
			if (prev!=null) photoServ.deletePhoto(prev); 
		}
		userRepo.save(loggedIn);
	}
}
