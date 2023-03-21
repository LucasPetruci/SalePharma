package br.edu.iff.ccc.bsi.webdev.controller.apirest;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
import br.edu.iff.ccc.bsi.webdev.repository.EntregadorRepository;

@RestController
@RequestMapping("/apirest/entregador")
public class EntregadorController {
    
    @Autowired
    private EntregadorRepository entregadorRepository;
    
    @GetMapping("/entregadores")
    public String listarEntregadores(Model model) {
        List<Entregador> entregadores = entregadorRepository.findAll();
        model.addAttribute("entregadores", entregadores);
        return "entregadores";
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Entregador> getById(@PathVariable Long id) {
        Optional<Entregador> entregador = entregadorRepository.findById(id);
        if (entregador.isPresent()) {
            return ResponseEntity.ok(entregador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Entregador criar(@RequestParam("nome") String nome) {
        Entregador entregador = new Entregador(nome);
        return entregadorRepository.save(entregador);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Entregador> atualizar(@PathVariable Long id, @RequestBody Entregador novoEntregador) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            Entregador entregador = optionalEntregador.get();
            entregador.setNome(novoEntregador.getNome());
            entregadorRepository.save(entregador);
            return ResponseEntity.ok(entregador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            entregadorRepository.delete(optionalEntregador.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


