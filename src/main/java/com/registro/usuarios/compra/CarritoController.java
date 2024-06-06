package com.registro.usuarios.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.registro.usuarios.enlace.Enlace;
import com.registro.usuarios.pedido.Pedido;
import com.registro.usuarios.pedido.PedidoService;
import com.registro.usuarios.producto.Producto;

import org.springframework.web.bind.annotation.PathVariable;

import com.registro.usuarios.producto.ProductoService;
import com.registro.usuarios.enlace.EnlaceService;

@Controller
public class CarritoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private EnlaceService enlaceService;

    @GetMapping("/carrito")
    public String verCarrito(HttpSession session, Model model) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        model.addAttribute("carrito", carrito);
        return "carrito";
    }

    @GetMapping("/añadirCarrito/{id}")
    public String añadirAlCarrito(@PathVariable("id") Integer id, HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        Producto producto = productoService.obtenerPorId(id);
        carrito.añadirProducto(producto);
        return "redirect:/carrito";
    }

    @PostMapping("/comprar")
    public String comprar(HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito != null && !carrito.getProductos().isEmpty()) {
            // Crear un nuevo pedido
            Pedido pedido = new Pedido();
            pedido.setPrecio_total(carrito.calcularTotal());
            //pedido.setFecha(LocalDateTime.now()); // Suponiendo que tengas un campo de fecha en tu entidad Pedido
            // Guardar el nuevo pedido en la base de datos
            pedidoService.guardar(pedido);

            // Obtener los productos del carrito
            List<Producto> productos = carrito.getProductos();

            // Crear enlaces para cada producto y guardarlos en la base de datos
            for (Producto producto : productos) {
                Enlace enlace = new Enlace();
                enlace.setProducto(producto);
                enlace.setPedido(pedido);
                // También puedes establecer el precio del enlace si es necesario
                // enlace.setPrecio(producto.getPrecio());
                enlaceService.guardar(enlace);
            }

            // Limpiar el carrito después de la compra
            carrito.vaciarCarrito();
        }
        return "redirect:/carrito";
    }

}
