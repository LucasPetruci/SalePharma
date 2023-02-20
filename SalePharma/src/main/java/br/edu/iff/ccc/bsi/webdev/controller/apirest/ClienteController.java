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

import br.edu.iff.ccc.bsi.webdev.modelo.Cliente;


@RestController
@RequestMapping(path="/apirest/cliente")
public class ClienteController {
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void novoCliente(
			@RequestParam(name = "nome") String nome,
			@RequestParam(value = "id") int id,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "telefone") String telefone,
			@RequestParam(name = "cpf") String cpf,
			@RequestParam(name = "senha") String senha,
			@RequestParam(name = "endereco") String endereco
			) {
		
		Cliente cliente = new Cliente(id, nome, email, telefone, cpf, senha, endereco);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String page(@PathVariable("id")int id) {
		return "OK" ;
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
