package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	//@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaTrabalho;
	
	public Funcionario(int id, Date dataCadastro, String nome, Date horaTrabalho){
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.horaTrabalho = horaTrabalho;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getHoraTrabalho() {
		return horaTrabalho;
	}
	
	public void setHoraTrabalho(Date horaTrabalho) {
		this.horaTrabalho = horaTrabalho;
	}
	
	public void adicionarProduto() {
		
	}
	
	public void recebeVenda() {
		
	}
	
	public void encerrarVenda() {
		
	}
}
