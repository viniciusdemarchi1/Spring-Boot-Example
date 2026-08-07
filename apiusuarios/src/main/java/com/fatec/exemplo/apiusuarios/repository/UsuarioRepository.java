package com.fatec.exemplo.apiusuarios.repository;

import com.fatec.exemplo.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}
