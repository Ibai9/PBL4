package com.registro.usuarios.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String nombre;

	@Column(length = 45, nullable = false)
	private String valor;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductoDetalles(Integer id, String nombre, String valor, Producto producto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalles(String nombre, String valor, Producto producto) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalles() {
		super();
	}

	@Override
	public String toString() {
		return nombre + " - " + valor;
	}
}
/* 
package com.registro.usuarios.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String color;

	@Column(length = 45, nullable = false)
	private String talla;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductoDetalles(Integer id, String color, String talla, Producto producto) {
		super();
		this.id = id;
		this.color = color;
		this.talla = talla;
		this.producto = producto;
	}

	public ProductoDetalles(String color, String talla, Producto producto) {
		super();
		this.color = color;
		this.talla = talla;
		this.producto = producto;
	}

	public ProductoDetalles() {
		super();
	}

	@Override
	public String toString() {
		return color + " - " + talla;
	}
}
*/
