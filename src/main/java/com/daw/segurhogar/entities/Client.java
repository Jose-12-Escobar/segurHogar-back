package com.daw.segurhogar.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Client implements Serializable {

	private static final long serialVersionUID = 5668458783522483417L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@NotEmpty
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO1")
	private String primerApellido;
	
	@Column(name = "APELLIDO2")
	private String segundoApellido;
	
	@NotEmpty
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "FE_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	@Past
	private Date fechaNacimiento;
	
	@Email
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "TIPO_CALLE")
	private String tipoCalle;
	
	@Column(name = "CALLE")
	private String calle;

	@Column(name = "NUMERO")
	private Integer numero;
	
	@Column(name = "PISO")
	private String piso;

	@Column(name = "PUERTA")
	private String puerta;
	
	@Column(name = "COD_POSTAL")
	private  String codPostal;
	
	@Column(name = "LOCALIDAD")
	private String localidad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Policy> polizas;

}
