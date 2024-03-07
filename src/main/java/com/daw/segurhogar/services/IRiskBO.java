package com.daw.segurhogar.services;

import java.util.List;

import com.daw.segurhogar.entities.Risk;

public interface IRiskBO {

	List<Risk> listaRisks();
	Risk getRisk(Long id);
	Risk getRiskByNoCalle(String calle);
	Risk delRisk(Long id);
	Risk updRisk(Risk Risk);
	Risk insRisk(Risk Risk);

}
