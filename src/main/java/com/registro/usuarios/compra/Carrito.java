package com.registro.usuarios.compra;

import java.util.ArrayList;
import java.util.List;
import com.registro.usuarios.producto.Producto;


public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public List<Producto> getProductos() {
        return productos;
    }

    public void añadirProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public float calcularTotal() {
        float total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
