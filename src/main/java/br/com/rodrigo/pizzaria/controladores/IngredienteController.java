package br.com.rodrigo.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rodrigo.pizzaria.modelo.repositorios.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {
	
	@Autowired
	IngredienteRepositorio ingredienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	private String listarIngredientes(Model model) {
		model.addAttribute("titulo", "Listagem de ingredientes");
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		return "ingrediente/listagem";
	}
}
