package br.com.rodrigo.pizzaria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rodrigo.pizzaria.excecoes.IngredienteInvalidoException;
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
			Model model) {
		
		if(result.hasErrors()) {
			//FieldError error = result.getFieldErrors().get(0);
			//attr.addFlashAttribute("mensagemErro", "Erro para salvar: " + error.getDefaultMessage());
			throw new IngredienteInvalidoException();
		} else {
			ingredienteRepositorio.save(ingrediente);
			//attr.addFlashAttribute("mensagemSucesso", "Ingrediente salvo com sucesso.");
			model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
			model.addAttribute("categorias", CategoriaDeIngrediente.values());
		}
		return "ingrediente/tabela-ingredientes";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{id}") 
	public ResponseEntity<String> deletarIngrediente(@PathVariable Long id) {
		try {
			ingredienteRepositorio.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
