package com.registro.usuarios.logistica;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logistica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@Column(length = 45, nullable = false, unique = false)
	private String pueblo;

	@Column(length = 100, nullable = false, unique = false)
	private String direccion;

	@Column(length = 20, nullable = false, unique = false)
	private String codigo_postal;

	@Column(length = 100, nullable = false, unique = false)
	private String tlf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}


	public Logistica(Integer id, String nombre, String pueblo, String direccion, String codigo_postal, String tlf) {
		this.id = id;
		this.nombre = nombre;
		this.pueblo = pueblo;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.tlf = tlf;
	}


	public Logistica(Integer id) {
		super();
		this.id = id;
	}

	public Logistica(String nombre, String pueblo, String direccion, String codigo_postal, String tlf) {
		super();
		this.nombre = nombre;
		this.pueblo = pueblo;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.tlf = tlf;
	}

	public Logistica() {
		super();
	}

	
	
}
