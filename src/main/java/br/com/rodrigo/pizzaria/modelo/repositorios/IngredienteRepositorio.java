package br.com.rodrigo.pizzaria.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.pizzaria.modelo.entidades.Ingrediente;

@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingrediente, Long>{

}
