package com.registro.usuarios.producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarTodos();
    Producto obtenerPorId(Integer id);
    Producto guardar(Producto producto);
    void eliminar(Integer id);
}
