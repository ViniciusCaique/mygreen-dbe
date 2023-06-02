package com.example.mygreen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mygreen.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}