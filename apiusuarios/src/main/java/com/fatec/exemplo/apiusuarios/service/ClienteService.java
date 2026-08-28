package com.fatec.exemplo.apiusuarios.service;


import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import com.fatec.exemplo.apiusuarios.repository.ClienteRepository;
import com.fatec.exemplo.apiusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;


    public List<Cliente> ListarClientes(){
        return repository.findAll();
    }

    public Cliente salvar (Cliente cliente){
        return repository.save(cliente);
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }


    public List<Cliente> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Cliente> contendoPorNomeCliente(String nome) {
        return repository.findByNomeContaining(nome);

    }

    public List<Cliente> greater(Long codCliente){
        return repository.findBycodClienteGreaterThan(codCliente);
    }

    public List<Cliente> buscarPorLess(Long codCliente){
        return repository.findBycodClienteLessThan(codCliente);
    }

    }

