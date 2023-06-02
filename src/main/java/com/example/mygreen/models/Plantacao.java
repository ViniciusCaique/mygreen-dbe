package com.example.mygreen.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import com.example.mygreen.controllers.PlantacaoController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
public class Plantacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plantacao;

    @NotBlank
    private LocalDate dataPlantacao;
    
    @NotBlank
    private int quantidadeAgua;
    
    @NotBlank
    private Boolean fertilizante;


    public EntityModel<Plantacao> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(PlantacaoController.class).show(id_plantacao)).withSelfRel(),
            linkTo(methodOn(PlantacaoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PlantacaoController.class).show(id_plantacao)).withRel("destroy")
        );
    }

}