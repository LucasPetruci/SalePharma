package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "Pagamento")
	public class Pagamento implements Serializable {

	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(name = "VALOR", nullable = false)
	    private double valor;

	    @OneToOne(mappedBy = "pagamento")
	    private Pedido pedido;

	    public Pagamento() {}

	    public Pagamento(double valor) {
	        this.valor = valor;
	    }

	    public Long getId() {
	        return id;
	    }

	    public double getValor() {
	        return valor;
	    }

	    public void setValor(double valor) {
	        this.valor = valor;
	    }

	    public Pedido getPedido() {
	        return pedido;
	    }

	    public void setPedido(Pedido pedido) {
	        this.pedido = pedido;
	    }
	}

