package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Entregador")
public class Entregador implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate dataCadastro;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "CARGA_HORARIA", nullable = false)
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date horaTrabalho;
		
	
	public Entregador(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public void recebeEntrega() {
		
	}
}
