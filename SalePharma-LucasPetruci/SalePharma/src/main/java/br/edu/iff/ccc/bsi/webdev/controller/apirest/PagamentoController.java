package br.edu.iff.ccc.bsi.webdev.controller.apirest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Pagamento;

@RestController
@RequestMapping(path = "apirest/pagamento")
public class PagamentoController {
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void novoPagamento(
			@RequestParam(value = "valorPago") float valorPago
			) {
		
		Pagamento pagamento = new Pagamento(valorPago);	
	}
	

	@GetMapping("/{valor}")
	@ResponseStatus(HttpStatus.OK)
	public String page(@PathVariable("valor")float valor) {
		return "Valor de: " +valor;
	}
	
	@PutMapping("/{valor}")
	@ResponseStatus(HttpStatus.OK)
	public String atualizar(@PathVariable("valor")float valor) {
		return "OK";
	}
	
	@DeleteMapping("/{valor}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("valor") float valor){
        return valor + " Deletado";
    }
}
