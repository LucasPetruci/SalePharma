package br.edu.iff.ccc.bsi.webdev.modelo;

import java.math.BigDecimal;

public class Pagamento {
	private BigDecimal valor;

	public Pagamento(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
