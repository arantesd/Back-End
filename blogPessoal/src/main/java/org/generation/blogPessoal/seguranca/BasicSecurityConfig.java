package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
	
@EnableWebSecurity //classe de configuração de segurança Spring
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired //injeção de dependencia- classe existente UserDetailsService - nomeada
	private UserDetailsService userDetailsService;
	
	@Override //sobrescrever método
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{ //tratativas de erros
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){ //tipo de criptografia  - nome do método
		return new BCryptPasswordEncoder(); //armazenar a senha no banco de dados criptografada
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll() //acesso sem passar o token
		.antMatchers("/usuarios/cadastrar").permitAll() //acesso sem passar o token
		.antMatchers(HttpMethod.GET ,"/postagens/**").permitAll()//** tudo que contem no GET 
		.anyRequest().authenticated() //demais requisições deverão ser autenticadas
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}

}
