package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // o nome do arquivo html da página de login
    }
}
