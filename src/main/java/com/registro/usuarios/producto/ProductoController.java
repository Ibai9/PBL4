/*package com.registro.usuarios.producto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.categoria.Categoria;
import com.registro.usuarios.categoria.CategoriaRepository;

import com.registro.usuarios.marca.Marca;
import com.registro.usuarios.marca.MarcaRepository;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private MarcaRepository marcaRepository;
	
	@GetMapping("productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "producto_formulario";
	}
	
	
	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto,HttpServletRequest request) {
		String[] detallesIDs = request.getParameterValues("detallesID");
		String[] detallesNombres = request.getParameterValues("detallesNombre");
		String[] detallesValores = request.getParameterValues("detallesValor");
		
		for(int i = 0;i < detallesNombres.length; i++) {
			if(detallesIDs != null && detallesIDs.length > 0) {
				producto.setDetalle(Integer.valueOf(detallesIDs[i]),detallesNombres[i],detallesValores[i]);
			}else {
				producto.añadirDetalles(detallesNombres[i],detallesValores[i]);
			}
		}
		
		productoRepository.save(producto);
		return "redirect:/";
	}
	
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);
		
		return "productos";
	}
	
	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer  id,Model modelo) {
		Producto producto = productoRepository.findById(id).get();
		modelo.addAttribute("producto", producto);
		
        List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "producto_formulario";
	}
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id,Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
	}
}*/

package com.registro.usuarios.producto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.categoria.Categoria;
import com.registro.usuarios.categoria.CategoriaRepository;

import com.registro.usuarios.marca.Marca;
import com.registro.usuarios.marca.MarcaRepository;

import com.registro.usuarios.genero.Genero;
import com.registro.usuarios.genero.GeneroRepository;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private MarcaRepository marcaRepository;

	@Autowired
	private GeneroRepository generoRepository;

	@GetMapping("productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		List<Marca> listaMarcas = marcaRepository.findAll();
		List<Genero> listaGeneros = generoRepository.findAll();


		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("listaMarcas", listaMarcas);
		modelo.addAttribute("listaGeneros", listaGeneros);



		return "producto_formulario";
	}

	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto, HttpServletRequest request) {
		String[] detallesIDs = request.getParameterValues("detallesID");
		String[] detallesNombres = request.getParameterValues("detallesNombre");
		String[] detallesValores = request.getParameterValues("detallesValor");

		for (int i = 0; i < detallesNombres.length; i++) {
			if (detallesIDs != null && detallesIDs.length > 0) {
				producto.setDetalle(Integer.valueOf(detallesIDs[i]), detallesNombres[i], detallesValores[i]);
			} else {
				producto.añadirDetalles(detallesNombres[i], detallesValores[i]);
			}
		}

		productoRepository.save(producto);
		return "redirect:/admin";
	}

	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);

		return "productos";
	}

	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id, Model modelo) {
		Producto producto = productoRepository.findById(id).get();
		modelo.addAttribute("producto", producto);

		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);

		List<Genero> listaGeneros = generoRepository.findAll();
		modelo.addAttribute("listaGeneros", listaGeneros);

		List<Marca> listaMarcas = marcaRepository.findAll();
		modelo.addAttribute("listaMarcas", listaMarcas);

		return "producto_formulario";
	}

	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
	}

	@GetMapping("/index")
	public String listarProductosIndex(Model modelo) {
    List<Producto> listaProductos = productoRepository.findAll();
    modelo.addAttribute("listaProductos", listaProductos);
    return "index";
	}
}


/*
package com.registro.usuarios.producto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.registro.usuarios.categoria.Categoria;
import com.registro.usuarios.categoria.CategoriaRepository;

import com.registro.usuarios.marca.Marca;
import com.registro.usuarios.marca.MarcaRepository;

import com.registro.usuarios.genero.Genero;
import com.registro.usuarios.genero.GeneroRepository;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private MarcaRepository marcaRepository;

	@Autowired
	private GeneroRepository generoRepository;

	@GetMapping("productos/nuevo")
	public String mostrarFormularioDeNuevoProducto(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		List<Marca> listaMarcas = marcaRepository.findAll();
		List<Genero> listaGeneros = generoRepository.findAll();

		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("listaCategorias", listaCategorias);
		modelo.addAttribute("listaMarcas", listaMarcas);
		modelo.addAttribute("listaGeneros", listaGeneros);

		return "producto_formulario";
	}

	/*
	 * @PostMapping("/productos/guardar")
	 * public String guardarProducto(Producto producto, HttpServletRequest request)
	 * {
	 * String[] detallesIDs = request.getParameterValues("detallesID");
	 * String[] detallesColores = request.getParameterValues("detallesColores");
	 * String[] detallesTallas = request.getParameterValues("detallesTallas");
	 * 
	 * 
	 * productoRepository.save(producto);
	 * return "redirect:/";
	 * }
	 */
/*
	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto, HttpServletRequest request) {
		//String[] detallesIDs = request.getParameterValues("detallesID");
		String[] detallesColores = request.getParameterValues("detallesColores");
		String[] detallesTallas = request.getParameterValues("detallesTallas");

		// Limpia la lista de detalles antes de añadir nuevos
		producto.getDetalles().clear();

		if (detallesColores != null && detallesTallas != null) {
			for (int i = 0; i < detallesColores.length; i++) {
				String color = detallesColores[i];
				String talla = detallesTallas[i];
				if (!color.isEmpty() && !talla.isEmpty()) {
					ProductoDetalles detalle = new ProductoDetalles(color, talla, producto);
					producto.getDetalles().add(detalle);
				}
			}
		}

		productoRepository.save(producto);
		return "redirect:/";
	}

	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto> listaProductos = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listaProductos);

		return "productos";
	}

	@GetMapping("/productos/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id, Model modelo) {
		Producto producto = productoRepository.findById(id).get();
		modelo.addAttribute("producto", producto);

		List<Categoria> listaCategorias = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);

		List<Genero> listaGeneros = generoRepository.findAll();
		modelo.addAttribute("listaGeneros", listaGeneros);

		List<Marca> listaMarcas = marcaRepository.findAll();
		modelo.addAttribute("listaMarcas", listaMarcas);

		return "producto_formulario";
	}

	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
	}
}*/