package br.edu.iff.ccc.bsi.webdev.modelo;

import java.sql.Time;
import java.util.Date;

public class Entregador {
	private int id;
	private String dataCadastro;
	private String nome;
	private String horaTrabalho;
	
	
	public Entregador(int id, String dataCadastro, String nome, String horaTrabalho) {
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
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getHoraTrabalho() {
		return horaTrabalho;
	}
	
	public void setHoraTrabalho(String horaTrabalho) {
		this.horaTrabalho = horaTrabalho;
	}
	
	public void recebeEntrega() {
		
	}
}
