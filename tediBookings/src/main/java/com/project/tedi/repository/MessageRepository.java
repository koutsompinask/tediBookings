package com.project.tedi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.tedi.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	@Query(value = "SELECT * FROM message WHERE receiver_id=:userId ORDER BY timestamp DESC",nativeQuery = true)
	public List<Message> getUserInbox(@Param("userId") Long id);
}
