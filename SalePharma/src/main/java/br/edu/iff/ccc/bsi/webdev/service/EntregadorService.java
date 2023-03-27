package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;
import br.edu.iff.ccc.bsi.webdev.repository.EntregadorRepository;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public List<Entregador> listarTodos() {
        return entregadorRepository.findAll();
    }

    public Entregador buscarPorId(Long id) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            return optionalEntregador.get();
        } else {
            throw new RuntimeException("Entregador não encontrado com o id: " + id);
        }
    }

    public Entregador salvar(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public void remover(Long id) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            entregadorRepository.delete(optionalEntregador.get());
        } else {
            throw new RuntimeException("Entregador não encontrado com o id: " + id);
        }
    }

    public Entregador atualizar(Long id, Entregador novoEntregador) {
        Optional<Entregador> optionalEntregador = entregadorRepository.findById(id);
        if (optionalEntregador.isPresent()) {
            Entregador entregador = optionalEntregador.get();
            entregador.setNome(novoEntregador.getNome());
            return entregadorRepository.save(entregador);
        } else {
            throw new RuntimeException("Entregador não encontrado com o id: " + id);
        }
    }
}
