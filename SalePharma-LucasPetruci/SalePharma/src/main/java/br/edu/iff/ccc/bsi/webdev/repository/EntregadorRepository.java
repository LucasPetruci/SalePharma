package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador,Integer> {
	
	@Query(value = "SELECT p FROM Entregador p WHERE p.nome =: nome")
	Entregador findById(int id);
}
