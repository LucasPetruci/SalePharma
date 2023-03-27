package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.ccc.bsi.webdev.modelo.Produto;
import br.edu.iff.ccc.bsi.webdev.service.ProdutoService;

@Controller
@RequestMapping(path = "/produtos")
public class ProdutoViewController {

    @Autowired
    private ProdutoService service;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "produtos";
    }

    @GetMapping(path = "/produto")
    public String cadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro-produto";
    }

    @PostMapping(path = "/produto")
    public String salvar(@RequestParam("nome") String nome, @RequestParam("preco") Double preco, Model model) {
        Produto produto = new Produto(nome, preco);
        service.salvar(produto);
        model.addAttribute("produtos", service.listarTodos());
        return "produtos";
    }

    @GetMapping(path = "/produto/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        Produto produto = service.buscarPorId(id);
        model.addAttribute("produto", produto);
        return "editar-produto";
    }

    @PostMapping(path = "/produto/editar")
    public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("preco") float preco, Model model) {
        Produto produto = service.buscarPorId(id);
        produto.setNome(nome);
        produto.setPreco(preco);
        service.salvar(produto);
        model.addAttribute("produtos", service.listarTodos());
        return "produtos";
    }

    @GetMapping(path = "/produto/excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        service.remover(id);
        model.addAttribute("produtos", service.listarTodos());
        return "produtos";
    }
}
