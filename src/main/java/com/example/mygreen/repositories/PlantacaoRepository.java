package com.example.mygreen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mygreen.models.Plantacao;

public interface PlantacaoRepository extends JpaRepository<Plantacao, Long>{
    
}
