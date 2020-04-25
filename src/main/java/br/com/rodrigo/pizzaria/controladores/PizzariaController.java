package br.com.rodrigo.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.rodrigo.pizzaria.excecoes.PizzaInvalidoException;
import br.com.rodrigo.pizzaria.modelo.entidades.Ingrediente;
import br.com.rodrigo.pizzaria.modelo.entidades.Pizza;
import br.com.rodrigo.pizzaria.modelo.enumeracoes.CategoriaDePizza;
import br.com.rodrigo.pizzaria.modelo.repositorios.IngredienteRepositorio;
import br.com.rodrigo.pizzaria.modelo.repositorios.PizzaRepositorio;
import br.com.rodrigo.pizzaria.propertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/pizzas")
public class PizzariaController {
	
	@Autowired
	private PizzaRepositorio pizzaRepositorio;
	
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;
	
	@Autowired
	private IngredientePropertyEditor ingredientePropertyEditor;
	
	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome) {
		return "Olá " + nome;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPizzas(Model model) {
		model.addAttribute("titulo", "Listagem de pizzas");
		model.addAttribute("pizzas", pizzaRepositorio.findAll());
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
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
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}") 
	public ResponseEntity<String> deletarPizza(@PathVariable Long id) {
		try {
			pizzaRepositorio.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="{id}") 
	public @ResponseBody Pizza buscaPizza(@PathVariable Long id) {
		return pizzaRepositorio.findOne(id);
	}
	

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}
	
	
	
	
	
	
	
	
}
