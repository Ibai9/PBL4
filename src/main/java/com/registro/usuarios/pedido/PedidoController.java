package com.registro.usuarios.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	//@Autowired
    //private PedidoService pedidoService;
	

	@GetMapping("/pedidos")
	public String listarPedidos(Model modelo) {
		List<Pedido> listaPedidos = pedidoRepository.findAll();
		modelo.addAttribute("listaPedidos", listaPedidos);
		return "pedidos";
	}

	/*@GetMapping("/lista_pedidos")
    public String verListaPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.listarTodos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }*/

	@GetMapping("/pedidos/eliminar/{id}")
	public String eliminarGenero(@PathVariable("id") Integer id, Model modelo) {
		pedidoRepository.deleteById(id);
		return "redirect:/pedidos";
	}
}
