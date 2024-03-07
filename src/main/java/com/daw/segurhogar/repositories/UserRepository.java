package com.daw.segurhogar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daw.segurhogar.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);
	Optional<User> findByEmail(String email);
	Optional<User> findByUserNameOrEmail(String username, String email);
	Boolean existsByUserName(String username);
	Boolean existsByEmail(String email);
	Boolean existsByRoles(String rol);
	Boolean existsByUserNameOrEmail(String username, String email);
}
