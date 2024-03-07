package com.daw.segurhogar.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RIESGO")
public class Risk implements Serializable {

	private static final long serialVersionUID = 7947812289093601134L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_RIESGO")
	private Long idRiesgo;
	

	@Column(name = "ID_POLIZA")
	private Long poliza;
	
	@Column(name = "TIPO_CALLE")
	private String tipoCalle;
	
	@Column(name = "NO_CALLE")
	private String noCalle;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "PISO")
	private String piso;
	
	@Column(name = "PUERTA")
	private String puerta;
	
	@Column(name = "CO_POSTAL")
	private String coPostal;
	
	@Column(name = "LOCALIDAD")
	private String localidad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@OneToMany(mappedBy = "idRiesgo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sinister> siniestros = List.of();

}
