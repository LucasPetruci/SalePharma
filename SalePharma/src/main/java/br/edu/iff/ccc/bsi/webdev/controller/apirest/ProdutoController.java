package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Produto;

@RestController
@RequestMapping(path = "apirest/produto")
public class ProdutoController {
	
	//private int id, quantidade;
	//private String descricao, foto, nomeFabricante, principioAtivo, observacao;
	//private BigDecimal preco;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criarProduto(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "quantidade") int quantidade,
			@RequestParam(name = "descricao") String descricao,
			@RequestParam(name = "foto") String foto,
			@RequestParam(name = "nomeFabricante") String nomeFabricante,
			@RequestParam(name = "principioAtivo") String principoAtivo,
			@RequestParam(name = "observacao") String observacao,
			@RequestParam(value = "preco") BigDecimal preco
			
			) {
		Produto produto = new Produto(id, quantidade, descricao, foto, nomeFabricante, principoAtivo, observacao, preco);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public String page (@PathVariable("id")int id){
		return "O id do Produto é: " +id;
		
	}
}
