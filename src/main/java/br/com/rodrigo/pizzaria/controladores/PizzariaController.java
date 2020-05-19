package br.com.rodrigo.pizzaria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rodrigo.pizzaria.modelo.servicos.PizzaServico;
import br.com.rodrigo.pizzaria.modelo.servicos.PizzariaServico;

@Controller
@RequestMapping("/pizzarias")
public class PizzariaController {
	
	@Autowired
	private PizzaServico pizzaServico;
	
	@Autowired
	private PizzariaServico pizzariaServico;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("nomesPizzas", pizzaServico.listarNomesPizza());
		return "cliente/busca_pizzarias";
	}
	
	@RequestMapping(value="/pizza/{nomePizza}",method=RequestMethod.GET)
	public String busca(Model model, @PathVariable String nomePizza) {
		model.addAttribute("pizzarias", pizzariaServico.listarPizzariasQueContemPizza(nomePizza));
		return "cliente/tabela_pizzarias";
	}
}
