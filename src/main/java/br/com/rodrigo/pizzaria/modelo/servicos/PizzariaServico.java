package br.com.rodrigo.pizzaria.modelo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.rodrigo.pizzaria.modelo.entidades.Pizzaria;
import br.com.rodrigo.pizzaria.modelo.repositorios.PizzariaRepositorio;

@Service
public class PizzariaServico {
	
	@Autowired
	private PizzariaRepositorio pizzariaRepositorio;

	public Pizzaria getPizzariaLogada() {
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if(autenticado == null) {
			throw new AuthenticationCredentialsNotFoundException("Usuário não logado");
		}
		UserDetails usuarioLogado = (UserDetails) autenticado.getPrincipal();
		
		return  pizzariaRepositorio.findOneByLogin(usuarioLogado.getUsername());
	}

	public List<Pizzaria> listarPizzariasQueContemPizza(String nomePizza) {
		return pizzariaRepositorio.listarPizzariasPorNomePizza(nomePizza);
	}
}
