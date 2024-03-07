package com.daw.segurhogar.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MODALIDAD")
public class PolicyModality implements Serializable{
	
	private static final long serialVersionUID = -7943780411694526462L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_MODALIDAD")
	private long idModalidad;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;	

}
