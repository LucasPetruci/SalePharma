package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "apirest/pagamento")
public class PagamentoController {

	@GetMapping("/{valor}")
	public String page(@PathVariable("valor")BigDecimal valor) {
		return "Valor de: " +valor;
	}
}
