package com.daw.segurhogar.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SINIESTRO")
public class Sinister implements Serializable {
	
	private static final long serialVersionUID = -4709671975880595627L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_SINIESTRO")	
	private Long idSiniestro;
	
	@Column(name = "ID_RIESGO")
	private Long idRiesgo;
	
	@Column(name = "FE_SINIESTRO")
	@Temporal(TemporalType.DATE)
	@Past
	private Date feSiniestro;
	
	@Column(name = "IMPORTE_SIN", precision = 2)
	private Float importeSiniestro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FE_INICIO_REPAR")
	private Date feInicioReparacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FE_FIN_REPAR")
	private Date feFinReparacion;
	
	@Column(name = "PERITADO")
	private Boolean peritado = false;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "ID_ESTADO", nullable = false)
	private SinisterState idEstado;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "REF_SINIESTRO", unique = true, nullable = false)
	private String refSiniestro;
	
}
