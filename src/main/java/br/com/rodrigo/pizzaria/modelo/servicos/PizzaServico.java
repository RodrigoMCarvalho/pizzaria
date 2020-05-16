package br.com.rodrigo.pizzaria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.pizzaria.modelo.entidades.Pizza;
import br.com.rodrigo.pizzaria.modelo.entidades.Pizzaria;
import br.com.rodrigo.pizzaria.modelo.repositorios.PizzaRepositorio;

@Service
public class PizzaServico {

	@Autowired
	private PizzaRepositorio pizzaRepositorio;

	@Autowired
	private PizzariaServico pizzariaServico;

	public void salvar(Pizza pizza) {
		pizza.setDono(pizzariaServico.getPizzariaLogada());
		pizzaRepositorio.save(pizza);
	}

	/**
	 * @return retorna as pizzas conforme usuário logado
	 */
	public Iterable<Pizza> listar() {
		Pizzaria dono = pizzariaServico.getPizzariaLogada();
		return pizzaRepositorio.findAllByDono(dono);
	}

	public Pizza buscar(Long id) {
		Pizzaria dono = pizzariaServico.getPizzariaLogada();
		return pizzaRepositorio.findByIdAndDono(id, dono);
	}

	public void remover(Long id) {
		Pizza pizza = this.buscar(id);
		if (pizza != null) {
			pizzaRepositorio.delete(id);
		}

	}

}
