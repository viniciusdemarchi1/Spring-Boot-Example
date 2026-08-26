package com.fatec.exemplo.apiusuarios.service;

import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



    @Service
    public class Usuarioservice {
        @Autowired
        private UsuarioRepository repository;

        public List<Usuario> listarTodos(){
            return repository.findAll();

        }
        public Usuario salvar (Usuario usuario){
            return repository.save(usuario);
        }
        public void deletar(Long id){
            repository.deleteById(id);
        }



        @GetMapping("usuarios/buscar")
        public List<Usuario> buscarPorNomeUsuario(@RequestParam String nome) {
            return repository.findByNome(nome);
        }


        @GetMapping("usuarios/contendo")
        public List<Usuario> contendoPorNomeUsuario(@RequestParam String nome) {
            return repository.findByNomeContaining(nome);
        }
    }

