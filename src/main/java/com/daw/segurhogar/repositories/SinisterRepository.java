package com.daw.segurhogar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.segurhogar.entities.Sinister;

public interface SinisterRepository extends JpaRepository<Sinister, Long> {

	Sinister findByRefSiniestro(String refSiniestro);
}
