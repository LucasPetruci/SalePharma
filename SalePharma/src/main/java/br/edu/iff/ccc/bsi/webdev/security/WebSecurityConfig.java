package br.edu.iff.ccc.bsi.webdev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.edu.iff.ccc.bsi.webdev.service.FuncionarioService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
   @Bean
   public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests( (authorize) -> authorize
	           .requestMatchers("/", "/entregadores").permitAll()
	           .requestMatchers("/").hasAuthority("ROLE_ADMIN")
	           .anyRequest().authenticated()
	     ).formLogin( (form) -> form
	           .loginPage("/login")
	           .defaultSuccessUrl("/produtos", true)
	           .failureUrl("/error")
	           .permitAll()
	      ).logout( (logout) -> logout
	           .logoutSuccessUrl("/")
	           .deleteCookies("JSESSIONID")
	      ).exceptionHandling( (ex) -> ex
	           .accessDeniedPage("/negado")
	      );
	      return http.build();
	}
   
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
   
//   @Bean
//   public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder, FuncionarioService service) throws Exception{
//	   
//	   return http.getSharedObject(AuthenticationManagerBuilder.class)
//			   .userDetailsService(service)
//			   .passwordEncoder(passwordEncoder)
//			   .and()
//			   .build();
//   }
}