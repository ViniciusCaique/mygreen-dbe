package com.example.mygreen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mygreen.models.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long>{
    
}
