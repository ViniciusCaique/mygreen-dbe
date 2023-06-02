package com.example.mygreen.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plantacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plantacao;

    private LocalDate dataPlantacao;
    private int quantidadeAgua;
    private Boolean fertilizante;

}
