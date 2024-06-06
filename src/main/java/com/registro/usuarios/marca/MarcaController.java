package com.registro.usuarios.marca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;

	@GetMapping("/marcas")
	public String listarMarcas(Model modelo) {
		List<Marca> listaMarcas = marcaRepository.findAll();
		modelo.addAttribute("listaMarcas", listaMarcas);
		return "marcas";
	}

	@GetMapping("/marcas/nuevo")
	public String mostrarFormularioDeNuevaMarca(Model modelo) {
		modelo.addAttribute("marca", new Marca());
		return "marca_formulario";
	}

	@PostMapping("/marcas/guardar")
	public String guardarMarca(Marca marca) {
		marcaRepository.save(marca);
		return "redirect:/marcas";
	}

	@GetMapping("/marcas/editar/{id}")
	public String mostrarFormularioDeModificarMarca(@PathVariable("id") Integer id, Model modelo) {
		Marca marca = marcaRepository.findById(id).get();
		modelo.addAttribute("marca", marca);
		return "marca_formulario";
	}

	@GetMapping("/marcas/eliminar/{id}")
	public String eliminarMarca(@PathVariable("id") Integer id, Model modelo) {
		marcaRepository.deleteById(id);
		return "redirect:/marcas";
	}
}
