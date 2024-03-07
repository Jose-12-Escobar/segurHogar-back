package com.daw.segurhogar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.segurhogar.entities.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
	
	Optional<Policy> findByNuPoliza(String nuPoliza);
}
