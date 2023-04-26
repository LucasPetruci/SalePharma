package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.modelo.Cliente;
import br.edu.iff.ccc.bsi.webdev.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            return optionalCliente.get();
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo.");
        }
        return clienteRepository.save(cliente);
    }

    public void remover(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            clienteRepository.delete(optionalCliente.get());
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }

    public Cliente atualizar(Long id, Cliente novoCliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNome(novoCliente.getNome());
            cliente.setCpf(novoCliente.getCpf());
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }
}
