package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;
import br.edu.iff.ccc.bsi.webdev.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            return optionalFuncionario.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado com o id: " + id);
        }
    }

    public Funcionario salvar(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public void remover(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            funcionarioRepository.delete(optionalFuncionario.get());
        } else {
            throw new RuntimeException("Funcionário não encontrado com o id: " + id);
        }
    }

    public Funcionario atualizar(Long id, Funcionario novoFuncionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();
            funcionario.setNome(novoFuncionario.getNome());
            funcionario.setSenha(novoFuncionario.getSenha());
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário não encontrado com o id: " + id);
        }
    }
}
