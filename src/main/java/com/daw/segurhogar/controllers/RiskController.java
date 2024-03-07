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

import com.daw.segurhogar.entities.Risk;
import com.daw.segurhogar.services.RiskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/risk")
public class RiskController {
	
		
	@Autowired
	RiskService service;
	
	@GetMapping
	public ResponseEntity<List<Risk>> list() {
		
		List<Risk> risks = service.listaRisks();

		return ResponseEntity.ok(risks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Risk> getRisk(@PathVariable Long id){
		
		Risk risk = null;
		
		if (id != null) {
			risk = service.getRisk(id);
		}
		
		return risk != null ? ResponseEntity.ok(risk) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/name/{noCalle}")
	public ResponseEntity<Risk> getRisk(@PathVariable String noCalle){
		
		Risk risk = null;
		
		if (noCalle != null) {
			risk = service.getRiskByNoCalle(noCalle);
		}
		
		return risk != null ? ResponseEntity.ok(risk) : ResponseEntity.notFound().build();
	}
	

    @DeleteMapping("/{id}")
    public ResponseEntity<Risk> deleteRisk(@PathVariable Long id) {
    	
    	Risk risk = null;
		
		if (id != null) {
			risk = service.delRisk(id);
		}    	

    	return risk != null ? ResponseEntity.ok(risk) : ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Risk> updateRisk(@RequestBody Risk input) {
    	
    	Risk risk = service.updRisk(input);

		return risk != null ? ResponseEntity.ok(risk) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Risk> insertRisk(@RequestBody Risk input) {
    	
    	Risk risk = service.insRisk(input);

		return risk != null ? ResponseEntity.ok(risk) : ResponseEntity.notFound().build();
    }

}
