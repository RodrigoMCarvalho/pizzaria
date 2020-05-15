package br.com.rodrigo.pizzaria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rodrigo.pizzaria.modelo.repositorios.PizzariaRepositorio;

@Service
public class AutenticacaoServico implements UserDetailsService{

	@Autowired
	private PizzariaRepositorio pizzariaRepositorio;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return null;
	}

}
