package com.daw.segurhogar.services;

import java.util.List;

import com.daw.segurhogar.entities.Policy;

public interface IPolicyBO {

	List<Policy> listaPolizas();
	Policy getPoliza(Long id);
	Policy delPoliza(Long id);
	Policy updPoliza(Policy client);
	Policy insPoliza(Policy client);
	Policy getPolizaByNuPoliza(String numPoliza);
}
