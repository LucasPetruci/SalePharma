package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.Date;
import java.util.Optional;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;
import br.edu.iff.ccc.bsi.webdev.repository.EntregadorRepository;

@RestController
@RequestMapping(path="apirest/entregador")
public class EntregadorController {
	
	@Autowired
	private EntregadorRepository service;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Entregador save(@RequestParam(value = "nome")String nome) {
		Entregador entregador = new Entregador(nome);
		return service.save(entregador);	
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Entregador getOne(@PathVariable("id")int id) {
		return service.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Entregador update(@PathVariable("id")int id, Entregador entregador, String nome) {
	    Optional<Entregador> optionalEntregador = service.findById(id);
	    if(optionalEntregador.isPresent()) {
	    	entregador = optionalEntregador.get();
	    	entregador.setNome(nome);
	    	service.save(entregador);
	    }

		
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") int id){
		service.deleteById(id);
        return "OK";
    }
	
}
