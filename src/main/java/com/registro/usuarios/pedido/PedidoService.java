package com.registro.usuarios.pedido;

import java.util.List;

import com.registro.usuarios.compra.Carrito;

public interface PedidoService {
    void guardarPedido(Carrito carrito);
    List<Pedido> listarTodos();
    Pedido obtenerPorId(Integer id);
    Pedido guardar(Pedido pedido);
    void eliminar(Integer id);
}