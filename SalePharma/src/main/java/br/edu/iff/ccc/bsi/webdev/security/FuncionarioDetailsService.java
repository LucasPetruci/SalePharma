package br.edu.iff.ccc.bsi.webdev.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;
import br.edu.iff.ccc.bsi.webdev.repository.FuncionarioRepository;

@Service
public class FuncionarioDetailsService  implements UserDetailsService  {

	
	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Funcionario funcionario = repo.findByNome(nome);
		if(funcionario == null) {
			throw new UsernameNotFoundException("Funcionário não encontrado: "+nome);
		}
		List<String> roles = new ArrayList<String>();
		roles.add("ADMIN");
		UserDetails user = User.withUsername(funcionario.getNome())
				.password(funcionario.getSenha())
				.roles(roles.toArray(new String[0]))
				.build();
		return user;
	}

	
   
}

