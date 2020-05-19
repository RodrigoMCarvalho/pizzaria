package br.com.rodrigo.pizzaria.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.pizzaria.modelo.entidades.Pizzaria;

@Repository
public interface PizzariaRepositorio extends CrudRepository<Pizzaria, Long	>{

	public Pizzaria findOneByLogin(String username);
	
	@Query("SELECT p FROM Pizzaria p INNER JOIN p.pizzas pi WHERE pi.nome = ?")
	public List<Pizzaria> listarPizzariasPorNomePizza(String nomePizza);

}
