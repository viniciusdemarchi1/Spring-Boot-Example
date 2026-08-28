package com.fatec.exemplo.apiusuarios.controller;


import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.service.ClienteService;
import com.fatec.exemplo.apiusuarios.service.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.ListarClientes();

    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }


    @GetMapping("/cliente/buscar")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
      return service.buscarPorNome(nome);
    }

    @GetMapping("/cliente/contendo")
    public List<Cliente> buscarPorNomeClienteContendo(@RequestParam String nome) {
        return service.contendoPorNomeCliente(nome);
    }


    @GetMapping("/cliente/greater")
    public List<Cliente> clienteGreater(@RequestParam Long codCliente) {
        return service.greater(codCliente);
    }

    @GetMapping("/cliente/less")
        public List<Cliente> clienteLess(@RequestParam Long codCliente) {
        return service.buscarPorLess(codCliente);
        }
    }

