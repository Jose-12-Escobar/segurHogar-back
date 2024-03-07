package com.daw.segurhogar.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "POLIZA")
public class Policy implements Serializable {
	
	private static final long serialVersionUID = 6513628969541470161L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_POLIZA")
	private Long idPoliza;
	
	@Column(name = "FE_INICIO")
	@Temporal(TemporalType.DATE)
	private Date feInicio;
	
	@Column(name = "FE_VENCIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date feVencimiento;
	
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "PRIMA")
	private Long prima;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ID_SITUACIONPOLIZA")
	private PolicyState idSituacionPoliza;
	
	@Column(name = "NU_CUENTA")
	private String nuCuenta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ID_MODALIDAD", nullable = false)
	private PolicyModality idModalidad;

	@Column(name = "NU_POLIZA")
	private String nuPoliza;

	@OneToMany(mappedBy = "poliza", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Risk> riesgos = List.of();
}
