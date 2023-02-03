package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "apirest/pedido")
public class PedidoController {

	@GetMapping("/{id}")
	public String page(@PathVariable("id")int id) {
		return "O id do produto é: "+id;
	}
}
