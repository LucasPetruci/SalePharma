package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Pedido;

@RestController
@RequestMapping(path = "apirest/pedido")
public class PedidoController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//int id, int quantidade, String data, String hora, BigDecimal valor
	public void criarPedido(
			@RequestParam(value = "id")int id,
			@RequestParam(value = "quantidade") int quantidade,
			@RequestParam(name = "data") String data,
			@RequestParam(name = "hora") String hora,
			@RequestParam(value = "valor") BigDecimal valor
			) {
		
		Pedido pedido = new Pedido(id, quantidade, data, hora, valor);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String page(@PathVariable("id")int id) {
		return "O id do produto é: "+id;
	}
}
