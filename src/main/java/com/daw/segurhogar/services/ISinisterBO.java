package com.daw.segurhogar.services;

import java.util.List;

import com.daw.segurhogar.entities.Sinister;

public interface ISinisterBO {
	
	List<Sinister> listaSiniestros();
	Sinister getSiniestro(Long id);
	Sinister delSiniestro(Long id);
	Sinister insSiniestro(Sinister siniestro);
	Sinister updSiniestro(Sinister siniestro);
	Sinister getSiniestroByRefSiniestro(String refSiniestro);
	
}
