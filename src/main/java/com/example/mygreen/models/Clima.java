package com.example.mygreen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clima {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clima;

    @NotBlank
    private String clima;
    
    @NotBlank
    private String descricao;
    
    @NotBlank
    private int temperatura;
    
}
