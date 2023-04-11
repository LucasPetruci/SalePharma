package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "produtos")
public class Produto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 

	private int quantidade;
	private String foto, nomeFabricante, principioAtivo, observacao, nome;
	
	@Column(length = 200)
	private String descricao;
	
	private float preco;
	
//	@ManyToOne
//	private Pedido pedido;
	
	public Produto(int id, int quantidade, String descricao, String foto, String nomeFabricate, String principioAtivo, String observacao, float preco) {
		this.id = id;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.foto = foto;
		this.nomeFabricante = nomeFabricate;
		this.principioAtivo = principioAtivo;
		this.observacao = observacao;
		this.preco = preco;
	}
	
	public Produto(String nome2, Double preco2) {
		// TODO Auto-generated constructor stub
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
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	
	public String getPrincipioAtivo() {
		return principioAtivo;
	}
	
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	
	public void especificacao() {
		System.out.println("");
	}
	
	public void reservarItem() {
		
	}
	
	public void baixaEstoque() {
		this.quantidade--;
	}

	
	
}
