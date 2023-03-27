package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.ccc.bsi.webdev.modelo.Cliente;
import br.edu.iff.ccc.bsi.webdev.service.ClienteService;

@Controller
@RequestMapping(path = "/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("clientes", service.listarTodos());
        return "clientes";
    }

    @GetMapping(path = "/cliente")
    public String cadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro-cliente";
    }

    @PostMapping(path = "/cliente")
    public String salvar(@RequestParam("nome") String nome, @RequestParam("cpf") String cpf, Model model) {
        Cliente cliente = new Cliente(nome, cpf);
        service.salvar(cliente);
        model.addAttribute("clientes", service.listarTodos());
        return "clientes";
    }

    @GetMapping(path = "/cliente/editar")
    public String editar(@RequestParam("id") Long id, Model model) {
        Cliente cliente = service.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "editar-cliente";
    }

    @PostMapping(path = "/cliente/editar")
    public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("cpf") String cpf, Model model) {
        Cliente cliente = service.buscarPorId(id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        service.salvar(cliente);
        model.addAttribute("clientes", service.listarTodos());
        return "clientes";
    }

    @GetMapping(path = "/cliente/excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        service.remover(id);
        model.addAttribute("clientes", service.listarTodos());
        return "clientes";
    }
}
