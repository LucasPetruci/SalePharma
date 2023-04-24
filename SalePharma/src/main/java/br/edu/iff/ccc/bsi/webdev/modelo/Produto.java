package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Produto")
public class Produto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@NotBlank(message = "Não pode ser vazio")
	private String nome;

	@NotNull
	private int quantidade;
	
	
	@Column(length = 200)
	@Size(min = 10, max = 200, message = "A descrição deve estar em 10 e 200 caracter")
	private String descricao;
	
	
	@DecimalMin(value = "0.01")
	private float preco;
	
//	@ManyToOne
//	private Pedido pedido;
	
	public Produto(int quantidade, float preco, String descricao) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void baixaEstoque(int quantidade) {
	    this.quantidade -= quantidade;
	}

}
