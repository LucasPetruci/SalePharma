package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entregador")
public class Entregador implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	public Entregador() {
		   // construtor padrão vazio
		}
	
	public Entregador(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
