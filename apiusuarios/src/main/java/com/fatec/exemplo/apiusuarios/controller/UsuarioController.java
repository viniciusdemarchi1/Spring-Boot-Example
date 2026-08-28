package com.fatec.exemplo.apiusuarios.controller;

import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.service.Usuarioservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private Usuarioservice service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();

    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarPorNome(@RequestParam String nome) {
        return service.buscarPorNomeUsuario(nome);
    }

    @GetMapping("/usuario/contendo")
    public List<Usuario> buscarPorNomeUsuarioContendo(@RequestParam String nome) {
        return service.contendoPorNomeUsuario(nome);
    }
    }
