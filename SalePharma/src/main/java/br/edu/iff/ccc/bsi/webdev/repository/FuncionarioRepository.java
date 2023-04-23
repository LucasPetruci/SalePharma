package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{

	Funcionario findByNome(String nome);
}
