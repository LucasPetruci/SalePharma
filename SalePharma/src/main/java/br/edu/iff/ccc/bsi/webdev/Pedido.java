package br.edu.iff.ccc.bsi.webdev;

import java.sql.Time;
import java.util.Date;

public class Pedido {
	
	private int id, quantidade;
	private Date data;
	private Time hora;
	private float valor;
	
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void buscaItem() {
		
	}
	public void facaPagamento() {
		
	}
	public void itemPedido() {
		
	}
	public void total() {
		System.out.println("Valor total do pedido");
	}
	public void encerrarPedido() {
		
	}
	
}
