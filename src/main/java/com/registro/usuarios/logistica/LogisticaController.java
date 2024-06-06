package com.registro.usuarios.logistica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogisticaController {

	@Autowired
	private LogisticaRepository logisticaRepository;

	@GetMapping("/logisticas")
	public String listarLogisticas(Model modelo) {
		List<Logistica> listaLogisticas = logisticaRepository.findAll();
		modelo.addAttribute("listaLogisticas", listaLogisticas);
		return "logisticas";
	}

	@GetMapping("/logisticas/nuevo")
	public String mostrarFormularioDeNuevaLogistica(Model modelo) {
		modelo.addAttribute("logistica", new Logistica());
		return "logistica_formulario";
	}

	@PostMapping("/logisticas/guardar")
	public String guardarLogistica(Logistica logistica) {
		logisticaRepository.save(logistica);
		return "redirect:/logisticas";
	}

	@GetMapping("/logisticas/editar/{id}")
	public String mostrarFormularioDeModificarLogistica(@PathVariable("id") Integer id, Model modelo) {
		Logistica logistica = logisticaRepository.findById(id).get();
		modelo.addAttribute("logistica", logistica);
		return "logistica_formulario";
	}

	@GetMapping("/logisticas/eliminar/{id}")
	public String eliminarLogistica(@PathVariable("id") Integer id, Model modelo) {
		logisticaRepository.deleteById(id);
		return "redirect:/logisticas";
	}
}
