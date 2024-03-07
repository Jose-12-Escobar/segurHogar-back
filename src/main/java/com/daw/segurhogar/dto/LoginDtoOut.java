package com.daw.segurhogar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDtoOut {

	private String username;
	private String email;
	private String roles;
	private String name;
	private String lastname;
	
}
