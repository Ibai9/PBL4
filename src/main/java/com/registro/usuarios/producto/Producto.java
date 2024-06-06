/*package com.registro.usuarios.producto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.registro.usuarios.categoria.Categoria;
import com.registro.usuarios.marca.Marca;
import com.registro.usuarios.genero.Genero;


@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;

	private float precio;

	private int stock;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ProductoDetalles> detalles = new ArrayList<>();

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

	public float getPrecio() {
		return precio;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public void añadirDetalles(String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(nombre, valor, this));
	}

	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}

	public void setDetalle(Integer id, String nombre, String valor) {
		this.detalles.add(new ProductoDetalles(id, nombre, valor, this));
	}

	public Producto(Integer id, String nombre, float precio,int stock ,Categoria categoria, Marca marca,Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.marca = marca;
		this.genero = genero;

	}

	public Producto() {
		super();
	}

	public Producto(String nombre, float precio, int stock,Categoria categoria, Marca marca, Genero genero) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.marca = marca;
		this.genero = genero;

	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Producto(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + "]";
	}

}*/

package com.registro.usuarios.producto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.registro.usuarios.categoria.Categoria;
import com.registro.usuarios.marca.Marca;
import com.registro.usuarios.genero.Genero;


@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;

	private float precio;

	private int stock;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<ProductoDetalles> detalles = new ArrayList<>();

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

	public float getPrecio() {
		return precio;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public void añadirDetalles(String color, String talla) {
		this.detalles.add(new ProductoDetalles(color, talla, this));
	}

	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}

	public void setDetalle(Integer id, String color, String talla) {
		this.detalles.add(new ProductoDetalles(id, color, talla, this));
	}

	public Producto(Integer id, String nombre, float precio,int stock ,Categoria categoria, Marca marca,Genero genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.marca = marca;
		this.genero = genero;

	}

	public Producto() {
		super();
	}

	public Producto(String nombre, float precio, int stock,Categoria categoria, Marca marca, Genero genero) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.marca = marca;
		this.genero = genero;

	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Producto(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + "]";
	}

}