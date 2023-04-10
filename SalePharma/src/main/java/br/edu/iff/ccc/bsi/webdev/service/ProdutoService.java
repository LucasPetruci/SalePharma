package br.edu.iff.ccc.bsi.webdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.modelo.Produto;
import br.edu.iff.ccc.bsi.webdev.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void remover(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            produtoRepository.delete(optionalProduto.get());
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

    public Produto atualizar(Long id, Produto novoProduto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(novoProduto.getNome());
            produto.setQuantidade(novoProduto.getQuantidade());
            produto.setFoto(novoProduto.getFoto());
            produto.setNomeFabricante(novoProduto.getNomeFabricante());
            produto.setPrincipioAtivo(novoProduto.getPrincipioAtivo());
            produto.setObservacao(novoProduto.getObservacao());
            produto.setDescricao(novoProduto.getDescricao());
            produto.setPreco(novoProduto.getPreco());
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }
}
