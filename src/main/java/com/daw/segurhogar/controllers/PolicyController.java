package com.daw.segurhogar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.daw.segurhogar.entities.Policy;
import com.daw.segurhogar.services.PolicyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/policies")
public class PolicyController {

	@Autowired
	PolicyService service;
	
	@GetMapping
	public ResponseEntity<List<Policy>> list() {
		
		
		List<Policy> polizas = service.listaPolizas();
		
		log.debug("Recuperamos la lista de polizas");

		return ResponseEntity.ok(polizas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Policy> getPoliza(@PathVariable Long id){
		
		Policy poliza = null;
		
		if (id != null) {
			poliza = service.getPoliza(id);
		}
		
		return poliza != null ? ResponseEntity.ok(poliza) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/num-poliza/{nuPoliza}")
	public ResponseEntity<Policy> getPoliza(@PathVariable String nuPoliza){
		
		Policy poliza = null;
		
		if (nuPoliza != null) {
			poliza = service.getPolizaByNuPoliza(nuPoliza);
		}
		
		return poliza != null ? ResponseEntity.ok(poliza) : ResponseEntity.notFound().build();
	}


    @DeleteMapping("/{id}")
    public ResponseEntity<Policy> deletePoliza(@PathVariable Long id) {
    	
		Policy poliza = null;
		
		if (id != null) {
			poliza = service.delPoliza(id);
		}    	

    	return poliza != null ? ResponseEntity.ok(poliza) : ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Policy> updatePoliza(@RequestBody Policy input) {
    	
    	Policy poliza = service.updPoliza(input);

		return poliza != null ? ResponseEntity.ok(poliza) : ResponseEntity.notFound().build();
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Policy> insertPoliza(@RequestBody Policy input) {
    	
    	Policy poliza = service.insPoliza(input);

		return poliza != null ? ResponseEntity.ok(poliza) : ResponseEntity.notFound().build();
    }
}
