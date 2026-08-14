package com.fatec.exemplo.apiusuarios.repository;

import com.fatec.exemplo.apiusuarios.model.Cliente;
import com.fatec.exemplo.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
