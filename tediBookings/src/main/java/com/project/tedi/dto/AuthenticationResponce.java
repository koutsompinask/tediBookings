package com.project.tedi.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponce {
	private String authToken;
	private String refreshToken;
	private Instant expiresAt;
	private String username;
	private String role;
	private Long id;
}