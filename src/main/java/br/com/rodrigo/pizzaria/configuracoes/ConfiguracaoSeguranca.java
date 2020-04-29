package br.com.rodrigo.pizzaria.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/pizzas/**", "/ingredientes/**").hasRole("PIZZARIA")
				.anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/login.jsp")
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/pizzas")
				.failureUrl("/login?semacesso=true")
				.usernameParameter("usuario")
				.passwordParameter("senha")
			.and()
				.logout()
					.logoutUrl("/sair")
					.logoutSuccessUrl("/login?saiu=true");
	}
	
}
