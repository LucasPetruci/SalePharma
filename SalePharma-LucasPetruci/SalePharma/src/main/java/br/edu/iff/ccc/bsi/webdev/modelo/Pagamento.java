package br.edu.iff.ccc.bsi.webdev.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;

@Embeddable
public class Pagamento {
	
	@OneToOne(mappedBy = "pagamento")
	@Column(name = "VALOR", precision = 2)
	private float valor;

	public Pagamento(float valor) {
		this.valor = valor;
	}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
