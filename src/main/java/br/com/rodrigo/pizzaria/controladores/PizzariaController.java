package br.com.rodrigo.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.rodrigo.pizzaria.excecoes.PizzaInvalidoException;
import br.com.rodrigo.pizzaria.modelo.entidades.Pizza;
import br.com.rodrigo.pizzaria.modelo.enumeracoes.CategoriaDePizza;
import br.com.rodrigo.pizzaria.modelo.repositorios.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzariaController {
	
	@Autowired
	private PizzaRepositorio pizzaRepositorio;
	
	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome) {
		return "Ol� " + nome;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("titulo", "Listagem de pizzas");
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("categorias", CategoriaDePizza.values());
		return "pizza/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPizza(@Valid @ModelAttribute Pizza pizza, BindingResult result, Model model){
		if(result.hasErrors()) {
			throw new PizzaInvalidoException();
		} else {
			pizzaRepositorio.save(pizza);
			model.addAttribute("pizzas", pizzaRepositorio.findAll());
			model.addAttribute("categorias", CategoriaDePizza.values());
		}
		return "pizza/tabela-pizzas";
	}
	
	
	
	
	
	
	
	
	
	
}
