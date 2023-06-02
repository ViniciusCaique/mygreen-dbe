package com.example.mygreen.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.mygreen.controllers.PlantaController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Planta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_planta;

    @NotNull
    private String planta;

    @NotNull
    private String descricao;

    @NotNull
    private String tipo;


    public EntityModel<Planta> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(PlantaController.class).show(id_planta)).withSelfRel(),
            linkTo(methodOn(PlantaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PlantaController.class).show(id_planta)).withRel("destroy")
        );
    }

}
