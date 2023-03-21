package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iff.ccc.bsi.webdev.repository.EntregadorRepository;

@Controller
public class EntregadorViewController {

	@Autowired
	private EntregadorRepository repo;

	@GetMapping("/entregadores")
	public String getAll(Model model) {
		model.addAttribute("entregadores", repo.findAll());
		return "entregadores";
	}

}
