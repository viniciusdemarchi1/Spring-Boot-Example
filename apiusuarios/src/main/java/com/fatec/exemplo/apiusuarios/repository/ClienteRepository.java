package com.fatec.exemplo.apiusuarios.repository;

import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
        List<Cliente> findByNome(String nome);

        List<Cliente> findByNomeContaining(String nome);

        List<Cliente>findBycodClienteGreaterThan(Long codCliente);

        List<Cliente>findBycodClienteLessThan(Long codCliente);
}

