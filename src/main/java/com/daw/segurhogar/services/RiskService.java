package com.daw.segurhogar.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.segurhogar.entities.Risk;
import com.daw.segurhogar.repositories.RiskRepository;


@Service
public class RiskService implements IRiskBO{
	
	@Autowired
	RiskRepository riskRepo;

	@GetMapping
	public List<Risk> listaRisks() {
		return riskRepo.findAll();
	}

	@Override
	public Risk getRisk(Long id) {
		Optional<Risk> risk = riskRepo.findById(id);
		return risk.orElse(null);
	}

	@Override
	public Risk getRiskByNoCalle(String calle) {
		Optional<Risk> risk = riskRepo.getRiskByNoCalle(calle);
		return risk.orElse(null);
	}

	@Override
	public Risk delRisk(Long id) {
		Optional<Risk> risk = riskRepo.findById(id);
		if (risk.isPresent()) riskRepo.deleteById(id);
		return risk.orElse(null);
	}

	@Override
	public Risk updRisk(Risk risk) {
		if (riskRepo.existsById(risk.getIdRiesgo())) {
			riskRepo.save(risk);	
		}
		
		return getRisk(risk.getIdRiesgo());
	}

	@Override
	public Risk insRisk(Risk risk) {
		riskRepo.save(risk);
		return risk;
	}

	
}
