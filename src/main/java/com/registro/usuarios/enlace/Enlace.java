package com.registro.usuarios.enlace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.registro.usuarios.producto.Producto;
import com.registro.usuarios.pedido.Pedido;

@Entity
public class Enlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float precio;

	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Enlace(Integer id, float precio,int cantidad ,Producto producto, Pedido pedido) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.pedido = pedido;

	}

	public Enlace() {
		super();
	}

	public Enlace(float precio,int cantidad ,Producto producto, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.pedido = pedido;
	}

	public Enlace(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Enlace id=" + id + "]";
	}

}
