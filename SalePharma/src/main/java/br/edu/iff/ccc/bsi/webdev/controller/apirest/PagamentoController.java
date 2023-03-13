package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.modelo.Pagamento;
import br.edu.iff.ccc.bsi.webdev.repository.PagamentoRepository;

@RestController
@RequestMapping("/apirest/pagamento")
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;
    
    @GetMapping("/pagamentos")
    public List<Pagamento> listar() {
        return pagamentoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getById(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            return ResponseEntity.ok(pagamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable Long id, @RequestBody Pagamento novoPagamento) {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if (optionalPagamento.isPresent()) {
            Pagamento pagamento = optionalPagamento.get();
            pagamento.setValor(novoPagamento.getValor());
            pagamentoRepository.save(pagamento);
            return ResponseEntity.ok(pagamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<Pagamento> optionalPagamento = pagamentoRepository.findById(id);
        if (optionalPagamento.isPresent()) {
            pagamentoRepository.delete(optionalPagamento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
