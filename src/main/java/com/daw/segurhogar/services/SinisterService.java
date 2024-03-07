package com.daw.segurhogar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.segurhogar.entities.Sinister;
import com.daw.segurhogar.repositories.SinisterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SinisterService implements ISinisterBO {

	@Autowired
	SinisterRepository sinisterRepo;
	
	@Override
	public List<Sinister> listaSiniestros() {
		return sinisterRepo.findAll();
	}

	@Override
	public Sinister getSiniestro(Long id) {
		return sinisterRepo.findById(id).orElse(null);
	}

	@Override
	public Sinister delSiniestro(Long id) {
		Optional<Sinister> sinister = sinisterRepo.findById(id);
		if (sinister.isPresent()) {
			sinisterRepo.deleteById(id);
		}else {
			log.info("No existe siniestro para el Id: "+id);
		}
		
		return sinister.orElse(null);
	}

	@Override
	public Sinister insSiniestro(Sinister siniestro) {
		sinisterRepo.save(siniestro);
		return siniestro;
	}

	@Override
	public Sinister updSiniestro(Sinister siniestro) {
		if (sinisterRepo.existsById(siniestro.getIdSiniestro())) {
			sinisterRepo.save(siniestro);	
		}else {
			log.info("No existe siniestro para el Id: "+siniestro.getIdSiniestro());
		}
		
		return getSiniestro(siniestro.getIdSiniestro());
	}
	
	/**
	 * Recupera un siniestro por la referencia 
	 * 
	 * @param referencia al siniestro
	 * @return Devuelve una instancia de siniestro si se ha encontrado, en caso contrario retorna null
	 */
	@Override
	public Sinister getSiniestroByRefSiniestro(String refSiniestro) {
		
		return sinisterRepo.findByRefSiniestro(refSiniestro);
	}

}
