package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "EMAIL", nullable = false, length = 100, unique = true, updatable = false)
	private String email;
	@Column(name = "TELEFONE", length = 11, nullable = false, unique = true, updatable = false)
	private String telefone;
	@Column(name = "CPF" ,length = 14, nullable = false, unique = true, updatable = false)
	private String cpf;
	@Embedded
	private Endereco endereco;
	@Column(name = "SENHA",nullable = false) // criptografar BCrypt
	private String senha;
	
	public Cliente(int id, String nome, String email, String telefone, String cpf, String senha, Endereco endereco){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
				
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void realizaPedido() {
		
	}

}
