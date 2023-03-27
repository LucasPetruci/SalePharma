package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.ccc.bsi.webdev.modelo.Entregador;
import br.edu.iff.ccc.bsi.webdev.service.EntregadorService;

@Controller
@RequestMapping(path = "/entregadores")
public class EntregadorViewController {

    @Autowired
    private EntregadorService service;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("entregadores", service.listarTodos());
        return "entregadores";
    }

    @GetMapping(path = "/entregador")
    public String cadastro(Model model) {
        model.addAttribute("entregador", new Entregador());
        return "cadastro-entregador";
    }

    @PostMapping(path = "/entregador")
    public String salvar(@RequestParam("nome") String nome, Model model) {
        Entregador entregador = new Entregador(nome);
        service.salvar(entregador);
        model.addAttribute("entregadores", service.listarTodos());
        return "entregadores";
    }

    @GetMapping(path = "/entregador/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        Entregador entregador = service.buscarPorId(id);
        model.addAttribute("entregador", entregador);
        return "editar-entregador";
    }

    @PostMapping(path = "/entregador/editar")
    public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, Model model) {
        Entregador entregador = service.buscarPorId(id);
        entregador.setNome(nome);
        service.salvar(entregador);
        model.addAttribute("entregadores", service.listarTodos());
        return "entregadores";
    }

    @GetMapping(path = "/entregador/excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        service.remover(id);
        model.addAttribute("entregadores", service.listarTodos());
        return "entregadores";
    }
}
