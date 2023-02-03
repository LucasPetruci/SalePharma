package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="apirest/entregador")
public class EntregadorController {

	@GetMapping("/{nome}")
	public String page(@PathVariable("nome")String nome) {
		return "O nome do entregador é: "+nome;
	}
}
