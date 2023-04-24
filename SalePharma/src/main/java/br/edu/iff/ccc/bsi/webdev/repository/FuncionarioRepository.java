package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;

<<<<<<< Updated upstream
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
=======
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    Funcionario findByNome(String nome);
>>>>>>> Stashed changes

}
