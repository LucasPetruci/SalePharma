package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.edu.iff.ccc.bsi.webdev.controller.apirest.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	// private int quantidade; RETIRAR DO DIAGRAMA
	
	@Column(name = "DATA_PEDIDO")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "STATUS_PEDIDO")
	private StatusPedido status;
	
	@Column(name = "PEDIDO", nullable = false)
	private float valor;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)	//Um pedido pode ter um ou vários produtos(mudar no diagrama)
	private List<Produto> produtos;
	
	public Pedido(float valor) {
		
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
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
