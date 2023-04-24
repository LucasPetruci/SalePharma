package br.edu.iff.ccc.bsi.webdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;
import br.edu.iff.ccc.bsi.webdev.repository.FuncionarioRepository;

public class FuncionarioDetailsService implements UserDetailsService {

	@Autowired
	private FuncionarioRepository repository;
	
	

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Funcionario funcionario = repository.findByNome(nome);
        if(nome == null) {
            throw new UsernameNotFoundException("Funcionário não encontrado");

        }
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(funcionario.getNome())
//                .password(funcionario.getSenha())
//                .roles(funcionario.getRole().toString())
//                .build();
               
        return new User(funcionario.getNome(), funcionario.getSenha(), funcionario.getRole());
	}
}
