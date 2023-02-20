package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id; 
	private int quantidade;
	private String data;
	private String hora;
	private BigDecimal valor;
	
	public Pedido(int id, int quantidade, String data, String hora, BigDecimal valor) {
		this.id = id;
		this.quantidade = quantidade;
		this.data = data;
		this.hora = hora;
		this.valor = valor;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
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
