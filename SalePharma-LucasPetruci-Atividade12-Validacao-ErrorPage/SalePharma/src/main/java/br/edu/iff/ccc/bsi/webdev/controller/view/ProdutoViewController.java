package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "formProduto";
    }

    @PostMapping("/produto")
    public String salvar(@ModelAttribute Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("msgErros", result.getAllErrors());
            return "formProduto";
        }

        try {
            service.salvar(produto);
            model.addAttribute("msgSucesso", "Produto cadastrado com sucesso.");
            model.addAttribute("produto", new Produto());
        } catch (IllegalArgumentException e) {
            model.addAttribute("msgErros", e.getMessage());
        }

        return "redirect:/produtos";
    }

    @GetMapping(path = "/produto/{id}")
    public String editar(@RequestParam("id") Long id, Model model) {
        Produto produto = service.buscarPorId(id);
        model.addAttribute("produto", produto);
        return "formProduto";
    }

    @PostMapping("/produto/{id}")
    public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("quantidade") Integer quantidade, @RequestParam("descricao") String descricao, @RequestParam("preco") Float preco, Model model) {
        Produto produto = service.buscarPorId(id);
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        service.salvar(produto);
        model.addAttribute("produtos", service.listarTodos());
        return "redirect:/produtos";
    }

    @GetMapping(path = "/produto/excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        service.remover(id);
        model.addAttribute("produtos", service.listarTodos());
        return "redirect:/produtos";
    }
}
