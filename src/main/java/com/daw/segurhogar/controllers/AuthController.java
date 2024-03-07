package com.daw.segurhogar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.daw.segurhogar.dto.AuthResponse;
import com.daw.segurhogar.dto.LoginDto;
import com.daw.segurhogar.dto.SignUpDto;
import com.daw.segurhogar.repositories.UserRepository;
import com.daw.segurhogar.services.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    
	@Autowired
    private AuthService authService;
	
	@Autowired
	private UserRepository userRepository;
    
    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto request)
    {
    	log.info("Vamos a logar a: "+request.getUsernameOrEmail());
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody SignUpDto request)
    {
    	if (userRepository.existsByUserNameOrEmail(request.getUsername(), request.getEmail())) {
    		log.info("Ya existe un usuario con esas credenciales!");
    		AuthResponse auth = AuthResponse.builder()
    				.email(request.getEmail())
    				.name(request.getName())
    				.lastname(request.getLastname())
    				.token("Ya existe un usuario con esas credenciales!")
    				.build();
    		return new ResponseEntity<>(auth, HttpStatus.BAD_REQUEST);
    	}
    		
    	log.info("Creamos el usuario "+request.getName());
        return ResponseEntity.ok(authService.register(request));
    }
}
