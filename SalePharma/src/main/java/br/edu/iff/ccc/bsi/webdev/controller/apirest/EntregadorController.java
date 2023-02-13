package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;

@RestController
@RequestMapping(path="apirest/entregador")
public class EntregadorController {
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void novoEntregador(
			@RequestParam(value = "id") int id,
			@RequestParam(defaultValue = "dataCadastro") String dataCadastro,
			@RequestParam(name = "nome") String nome,
			@RequestParam(value =  "horaTrabalho") String horaTrabalho
			) {
		
		Entregador entregador = new Entregador(id, dataCadastro, nome, horaTrabalho);
	}
	

	@GetMapping("/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public String page(@PathVariable("nome")String nome) {
		return "OK";
	}
}
