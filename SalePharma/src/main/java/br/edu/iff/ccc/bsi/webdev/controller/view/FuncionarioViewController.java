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

import br.edu.iff.ccc.bsi.webdev.modelo.Funcionario;
import br.edu.iff.ccc.bsi.webdev.service.FuncionarioService;

@Controller
@RequestMapping(path = "/funcionarios")
public class FuncionarioViewController {

    @Autowired
    private FuncionarioService service;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("funcionarios", service.listarTodos());
        return "funcionarios";
    }

    @GetMapping(path = "/funcionario")
    public String cadastro(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "formFuncionario";
    }

    @PostMapping("/funcionario")
    public String salvar(@ModelAttribute Funcionario funcionario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("msgErros", result.getAllErrors());
            return "formFuncionario";
        }

        try {
            service.salvar(funcionario);
            model.addAttribute("msgSucesso", "Funcionário cadastrado com sucesso.");
            model.addAttribute("funcionario", new Funcionario());
        } catch (IllegalArgumentException e) {
            model.addAttribute("msgErros", e.getMessage());
        }

        return "redirect:/funcionarios";
    }

    @GetMapping(path = "/funcionario/{id}")
    public String editar(@RequestParam("id") Long id, Model model) {
        Funcionario funcionario = service.buscarPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "formFuncionario";
    }

    @PostMapping("/funcionario/{id}")
    public String atualizar(@RequestParam("id") Long id, @RequestParam("nome") String nome, @RequestParam("senha") String senha, Model model) {
        Funcionario funcionario = service.buscarPorId(id);
        funcionario.setNome(nome);
        funcionario.setSenha(senha);
        service.salvar(funcionario);
        model.addAttribute("funcionarios", service.listarTodos());
        return "redirect:/funcionarios";
    }

    @GetMapping(path = "/funcionario/excluir")
    public String excluir(@RequestParam("id") Long id, Model model) {
        service.remover(id);
        model.addAttribute("funcionarios", service.listarTodos());
        return "redirect:/funcionarios";
    }
}
