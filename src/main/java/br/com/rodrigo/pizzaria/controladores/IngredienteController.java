package br.com.rodrigo.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rodrigo.pizzaria.modelo.entidades.Ingrediente;
import br.com.rodrigo.pizzaria.modelo.enumeracoes.CategoriaDeIngrediente;
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
		model.addAttribute("categorias", CategoriaDeIngrediente.values());
		return "ingrediente/listagem";
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	private String salvarIngredientes(
			@Valid @ModelAttribute Ingrediente ingrediente, 
			BindingResult result,
			RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			FieldError error = result.getFieldErrors().get(0);
			attr.addFlashAttribute("mensagemErro", "Erro para salvar: " + error.getDefaultMessage());
		} else {
			ingredienteRepositorio.save(ingrediente);
			attr.addFlashAttribute("mensagemSucesso", "Ingrediente salvo com sucesso.");
		}
		return "redirect:/ingredientes";
	}
}
