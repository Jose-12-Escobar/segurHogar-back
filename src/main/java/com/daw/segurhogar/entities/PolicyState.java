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
@Table(name = "ESTADO_POLIZA")
public class PolicyState implements Serializable {
	
	private static final long serialVersionUID = -5566037558796745796L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ESTADO")
	private long idEstado;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
}
