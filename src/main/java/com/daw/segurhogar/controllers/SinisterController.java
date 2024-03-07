package com.daw.segurhogar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.segurhogar.entities.Sinister;
import com.daw.segurhogar.services.SinisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sinisters")
public class SinisterController {

	@Autowired
	SinisterService service;
	
	@GetMapping()
	public ResponseEntity<List<Sinister>> listaSiniestros(){
		return ResponseEntity.ok(service.listaSiniestros());
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<Sinister> getSiniestro(@PathVariable Long id){
		
		Sinister siniestro = null;
		
		if (id != null) {
			siniestro = service.getSiniestro(id);
			log.info("Se recupera la información del siniestro con Id: "+id);
		}else {
			log.debug("No se ha informado el ID del siniestro");
		}
		
		return siniestro != null ? ResponseEntity.ok(siniestro) : ResponseEntity.notFound().build();		
	}
	
	@GetMapping("/refSiniestro/{refSiniestro}")
	public ResponseEntity<Sinister> getSinisterByRefSinister(@PathVariable String refSiniestro){
		
		Sinister sinister = null;
		
		if (refSiniestro != null) {
			sinister = service.getSiniestroByRefSiniestro(refSiniestro);
		}
		
		return sinister != null ? ResponseEntity.ok(sinister) : ResponseEntity.notFound().build();
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Sinister> deleteSinister(@PathVariable Long id) {
    	
		Sinister siniestro = null;
		
		if (id != null) {
			siniestro = service.delSiniestro(id);
		}    	

    	return siniestro != null ? ResponseEntity.ok(siniestro) : ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Sinister> updateSinister(@RequestBody Sinister input) {
    	
    	Sinister siniestro = service.updSiniestro(input);

		return siniestro != null ? ResponseEntity.ok(siniestro) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Sinister> insertSinister(@RequestBody Sinister input) {
    	
    	Sinister siniestro = service.insSiniestro(input);

		return siniestro != null ? ResponseEntity.ok(siniestro) : ResponseEntity.notFound().build();
    }	
	
	
}
