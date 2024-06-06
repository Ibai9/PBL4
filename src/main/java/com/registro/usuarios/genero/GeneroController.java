package com.registro.usuarios.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneroController {

	@Autowired
	private GeneroRepository generoRepository;

	@GetMapping("/generos")
	public String listarGeneros(Model modelo) {
		List<Genero> listaGeneros = generoRepository.findAll();
		modelo.addAttribute("listaGeneros", listaGeneros);
		return "generos";
	}

	@GetMapping("/generos/nuevo")
	public String mostrarFormularioDeNuevaGenero(Model modelo) {
		modelo.addAttribute("genero", new Genero());
		return "genero_formulario";
	}

	@PostMapping("/generos/guardar")
	public String guardarGenero(Genero genero) {
		generoRepository.save(genero);
		return "redirect:/generos";
	}

	@GetMapping("/generos/editar/{id}")
	public String mostrarFormularioDeModificarGenero(@PathVariable("id") Integer id, Model modelo) {
		Genero genero = generoRepository.findById(id).get();
		modelo.addAttribute("genero", genero);
		return "genero_formulario";
	}

	@GetMapping("/generos/eliminar/{id}")
	public String eliminarGenero(@PathVariable("id") Integer id, Model modelo) {
		generoRepository.deleteById(id);
		return "redirect:/generos";
	}
}
