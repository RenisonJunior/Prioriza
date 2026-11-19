package br.com.prioriza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.prioriza.model.Usuario;
import br.com.prioriza.service.CadastroService;

@Controller
public class AcessoController {

    private final CadastroService cadastroService;

    public AcessoController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario, Model model) {
        if (!cadastroService.cadastrar(usuario)) {
            model.addAttribute("erro", "Este e-mail já está cadastrado.");
            return "cadastro";
        }

        return "redirect:/login?cadastro";
    }
}