package br.edu.iff.ccc.bsi.webdev.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityWeb extends WebSecurityConfigurerAdapter {

 @Autowired
 private FuncionarioDetailsService service;
   
   
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
           .withUser("user")
           .password("{noop}password")
           .roles("USER");
   }
   

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	       http.authorizeRequests()
	               .antMatchers("/login", "/css/**", "/js/**").permitAll() // Permite acesso à página de login e aos arquivos CSS e JS
	               .anyRequest().authenticated() // Exige autenticação para todas as outras páginas
	               .and()
	           .formLogin()
	               .loginPage("/login") // Define a página de login
	               .defaultSuccessUrl("/funcionarios") // Define a página para redirecionar após o login bem-sucedido
	               .and()
	           .logout()
	               .logoutUrl("/logout") // Define a URL para fazer logout
	               .logoutSuccessUrl("/login"); // Define a página para redirecionar após o logout bem-sucedido

   }
}
