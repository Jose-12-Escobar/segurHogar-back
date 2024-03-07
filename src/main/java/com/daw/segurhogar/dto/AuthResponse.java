package com.daw.segurhogar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	private String username;
	private String email;
	private String roles;
	private String name;
	private String lastname;
    private String token; 
}