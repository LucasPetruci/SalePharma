package br.edu.iff.ccc.bsi.webdev.modelo;

import java.io.Serializable;

import br.edu.iff.ccc.bsi.webdev.controller.apirest.StatusPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private StatusPedido status;

    @Column(name = "TOTAL_PRODUTOS", nullable = false)
    private Integer totalProdutos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    public Pedido() {}

    public Pedido(StatusPedido status, Integer totalProdutos, Cliente cliente, Entregador entregador, Pagamento pagamento) {
        this.status = status;
        this.totalProdutos = totalProdutos;
        this.cliente = cliente;
        this.entregador = entregador;
        this.pagamento = pagamento;
    }

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Integer getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(Integer totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
