package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;
import br.edu.iff.ccc.bsi.webdev.service.EntregadorService;

@RestController
@RequestMapping("/apirest/entregador")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping("/entregadores")
    public List<Entregador> listarEntregadores() {
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> getById(@PathVariable Long id) {
        Entregador entregador = entregadorService.buscarPorId(id);
        return ResponseEntity.ok(entregador);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Entregador criar(@RequestParam("nome") String nome) {
        Entregador entregador = new Entregador(nome);
        return entregadorService.salvar(entregador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> atualizar(@PathVariable Long id, @RequestBody Entregador novoEntregador) {
        Entregador entregadorAtualizado = entregadorService.atualizar(id, novoEntregador);
        return ResponseEntity.ok(entregadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        entregadorService.remover(id);
        return ResponseEntity.noContent().build();
    }
}

