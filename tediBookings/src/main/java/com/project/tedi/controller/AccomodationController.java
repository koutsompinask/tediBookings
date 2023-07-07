package com.project.tedi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tedi.model.Accomodation;
import com.project.tedi.service.AccomodationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/accomodation")
@AllArgsConstructor
public class AccomodationController {
	
	private AccomodationService accomServe;

	@PostMapping("/enlist")
	public ResponseEntity<Accomodation> enlist(@RequestBody Accomodation acc){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(accomServe.addAcc(acc));
	}
}
