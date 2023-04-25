package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/teste")
public class layoutBaseViewController {


	@GetMapping()
	public String home() {
		return "layoutBase";
	}

}
