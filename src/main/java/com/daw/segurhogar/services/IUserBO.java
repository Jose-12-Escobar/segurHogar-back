package com.daw.segurhogar.services;

import com.daw.segurhogar.dto.SignUpDto;
import com.daw.segurhogar.entities.User;

public interface IUserBO {
	
	User getUserById(Long idUser);
	User getUser(String username);
	Boolean existUser(String userName);
	Boolean existEmail(String email);
	User getUserByUsernameOrEmail(String userName, String email);
	User createUser(SignUpDto signundto);
	
}
