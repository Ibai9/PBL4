package com.registro.usuarios.pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.registro.usuarios.compra.Carrito;
import com.registro.usuarios.enlace.Enlace;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void guardarPedido(Carrito carrito) {
        Pedido pedido = new Pedido();
        pedido.setFecha(new Date());
        pedido.setPrecio_total((float) carrito.calcularTotal());
        
        carrito.getProductos().forEach(producto -> {
            Enlace enlace = new Enlace();
            enlace.setProducto(producto);
            enlace.setPrecio(producto.getPrecio());
            enlace.setCantidad(1); // Aquí podrías añadir lógica para manejar cantidades
            enlace.setPedido(pedido);
            pedido.getEnlace().add(enlace);
        });

        pedidoRepository.save(pedido);
    }


    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + id));
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }
}

