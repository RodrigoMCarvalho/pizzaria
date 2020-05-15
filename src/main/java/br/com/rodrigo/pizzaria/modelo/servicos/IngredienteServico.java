package br.com.rodrigo.pizzaria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.pizzaria.modelo.entidades.Ingrediente;
import br.com.rodrigo.pizzaria.modelo.entidades.Pizzaria;
import br.com.rodrigo.pizzaria.modelo.repositorios.IngredienteRepositorio;

@Service
public class IngredienteServico {
	
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;
	
	@Autowired
	private PizzariaServico pizzariaServico;

	public void salvar(Ingrediente ingrediente) {
		ingrediente.setDono(pizzariaServico.getPizzariaLogada());
		ingredienteRepositorio.save(ingrediente);
	}
	
	/**
	 * @return retorna os ingredientes conforme usuário logado
	 */
	public Iterable<Ingrediente> listar() {
		Pizzaria dono = pizzariaServico.getPizzariaLogada();
		return ingredienteRepositorio.findAllByDono(dono);
	}
	
	public Ingrediente buscar(Long id) {
		Pizzaria dono = pizzariaServico.getPizzariaLogada();
		return ingredienteRepositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(Long id) {
		Ingrediente ingrediente = buscar(id);
		if(ingrediente != null) {
			ingredienteRepositorio.delete(id);
		}
		
	}

}
