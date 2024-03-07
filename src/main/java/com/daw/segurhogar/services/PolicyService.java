package com.daw.segurhogar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.segurhogar.entities.Policy;
import com.daw.segurhogar.repositories.PolicyRepository;

@Service
public class PolicyService implements IPolicyBO {
	
	@Autowired
	PolicyRepository policyRepo;

	@Override
	public List<Policy> listaPolizas() {
		return policyRepo.findAll();
	}

	@Override
	public Policy getPoliza(Long id) {
		Optional<Policy> poliza = policyRepo.findById(id);
		return poliza.orElse(null);
	}

	@Override
	public Policy delPoliza(Long id) {
		Optional<Policy> poliza = policyRepo.findById(id);
		if (poliza.isPresent()) policyRepo.deleteById(id);
		return poliza.orElse(null);
	}

	@Override
	public Policy updPoliza(Policy poliza) {
		if (policyRepo.existsById(poliza.getIdPoliza())) {
			policyRepo.save(poliza);	
		}
		
		return getPoliza(poliza.getIdPoliza());
	}

	@Override
	public Policy insPoliza(Policy poliza) {
		policyRepo.save(poliza);
		return poliza;
	}

	@Override
	public Policy getPolizaByNuPoliza(String nuPoliza) {
		Optional<Policy> poliza = policyRepo.findByNuPoliza(nuPoliza);
		return poliza.orElse(null);
	}

}
