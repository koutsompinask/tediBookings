package com.project.tedi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String message;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "sender_id")
	@JsonIncludeProperties({"firstName","lastName","username","id"})
	private User sender;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	@JsonIncludeProperties({"firstName","lastName","username","id"})
	private User receiver;
	
	@NonNull
	private Date timestamp;
}
