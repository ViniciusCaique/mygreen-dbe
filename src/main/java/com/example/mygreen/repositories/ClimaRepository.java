package com.example.mygreen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mygreen.models.Clima;

public interface ClimaRepository extends JpaRepository<Clima, Long>{
    
}
