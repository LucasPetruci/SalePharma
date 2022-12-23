package br.edu.iff.ccc.bsi.webdev;

import java.sql.Time;
import java.util.Date;

public class Entregador {
	private int id;
	private Date dataCadastro;
	private String nome;
	private Time horaTrabalho;
	
	
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
	
	public Time getHoraTrabalho() {
		return horaTrabalho;
	}
	
	public void setHoraTrabalho(Time horaTrabalho) {
		this.horaTrabalho = horaTrabalho;
	}
	
	public void recebeEntrega() {
		
	}
}
