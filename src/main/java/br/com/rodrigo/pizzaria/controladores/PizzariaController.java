package br.com.rodrigo.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rodrigo.pizzaria.modelo.servicos.PizzaServico;

@Controller
@RequestMapping("/pizzarias")
public class PizzariaController {
	
	@Autowired
	private PizzaServico pizzaServico;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("nomesPizzas", pizzaServico.listarNomesPizza());
		return "cliente/busca_pizzarias";
	}
}
