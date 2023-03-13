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

import br.edu.iff.ccc.bsi.webdev.modelo.Pedido;

@RestController
@RequestMapping(path = "apirest/pedido")
public class PedidoController {

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	//int id, int quantidade, String data, String hora, BigDecimal valor
//	public void criarPedido(
//			//@RequestParam(name = "hora") StatusPedido status,
//			@RequestParam(value = "valor") float valor
//			) {
//		Pedido pedido = new Pedido(valor);
//	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String page(@PathVariable("id")int id) {
		return "O id do produto é: "+id;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String atualizar(@PathVariable("id")int id) {
		return "OK";
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletar(@PathVariable("id") int id){
        return id + " Deletado";
    }
}
