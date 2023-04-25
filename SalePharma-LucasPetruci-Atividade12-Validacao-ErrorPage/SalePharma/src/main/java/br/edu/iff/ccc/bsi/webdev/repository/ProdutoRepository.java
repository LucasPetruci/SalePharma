package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.ccc.bsi.webdev.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
