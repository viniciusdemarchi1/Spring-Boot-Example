package com.fatec.exemplo.apiusuarios.controller;


import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.service.ClienteService;
import com.fatec.exemplo.apiusuarios.service.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/clientes")

public class WebClienteController {

    @Autowired
    private ClienteService clienteservice;


    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro_cliente";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteservice.salvar(cliente);
        return "cadastro_cliente";
    }


    @GetMapping("/lista")
    public String listar(@RequestParam(required = false) String nome, Model model) {
        List<Cliente> clientes = (nome == null || nome.isEmpty())
                ? clienteservice.ListarClientes()
                : clienteservice.contendoPorNomeCliente(nome);
        model.addAttribute("clientes", clientes);
        return "lista_cliente";
    }

}
