package com.registro.usuarios.pedido;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.registro.usuarios.logistica.Logistica;
import com.registro.usuarios.enlace.Enlace;


@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float precio_total;

	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "logistica_id")
	private Logistica logistica;


	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Enlace> enlaces;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public float getPrecio_total() {
		return this.precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Enlace> getEnlace() {
		return this.enlaces;
	}

	public void setEnlace(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}


	public Logistica getLogistica() {
		return logistica;
	}

	public void setLogistica(Logistica logistica) {
		this.logistica = logistica;
	}

	public Pedido(Integer id, float precio_total,Date fecha ,Logistica logistica) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.precio_total = precio_total;
		this.logistica = logistica;
	}

	public Pedido() {
		super();
	}

	public Pedido(float precio_total/*,Date fecha ,Logistica logistica, Usuario usuario*/) {
		super();
		//this.fecha = fecha;
		this.precio_total = precio_total;
		//this.logistica = logistica;
		//this.usuario = usuario;
	}

	public Pedido(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pedido id=" + id + "]";
	}


}
