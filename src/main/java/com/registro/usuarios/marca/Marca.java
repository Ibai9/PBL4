/*package com.registro.usuarios.marca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.registro.usuarios.categoria.Categoria;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@OneToMany
	@JoinColumn(name = "marca_id")
	private List<Categoria> categorias = new ArrayList<>();

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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Marca(Integer id, String nombre, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca(Integer id) {
		super();
		this.id = id;
	}

	public Marca(String nombre, List<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca() {
		super();
	}

	
	
}*/

package com.registro.usuarios.marca;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	/*@OneToMany
	@JoinColumn(name = "producto_id")
	private List<Producto> productos = new ArrayList<>();*/

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
	/*public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}*/

	public Marca(Integer id, String nombre/*,List<Producto> productos*/) {
		super();
		this.id = id;
		this.nombre = nombre;
		//this.productos = productos;
	}

	public Marca(Integer id) {
		super();
		this.id = id;
	}

	public Marca(String nombre/*, List<Producto> productos*/) {
		super();
		this.nombre = nombre;
		//this.productos = productos;
	}

	public Marca() {
		super();
	}

	
	
}
