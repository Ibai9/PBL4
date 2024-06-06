/*package com.registro.usuarios.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.marca.Marca;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria() {
		super();
	}

	public Categoria(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Categoria(Integer id) {
		super();
		this.id = id;
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Categoria(Integer id, String nombre, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
	}

	public Categoria(String nombre, Marca marca) {
		super();
		this.nombre = nombre;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
}*/

package com.registro.usuarios.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categoria {

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

	public Categoria(Integer id, String nombre/*, List<Producto> productos*/) {
		super();
		this.id = id;
		this.nombre = nombre;
		//this.productos = productos;
	}

	public Categoria(Integer id) {
		super();
		this.id = id;
	}

	public Categoria(String nombre/*, List<Producto> productos*/) {
		super();
		this.nombre = nombre;
		//this.productos = productos;
	}

	public Categoria() {
		super();
	}

	
	
}

