package com.fatec.exemplo.apiusuarios.controller;


import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.service.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/usuarios")

public class WebUsuarioController {

    @Autowired
    private Usuarioservice usuarioservice;


    @GetMapping("web/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        usuarioservice.salvar(usuario);
        return "redirect:/web/usuarios/lista";
    }
}
