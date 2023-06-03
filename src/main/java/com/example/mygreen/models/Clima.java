package com.example.mygreen.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.mygreen.controllers.ClimaController;

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

    public EntityModel<Clima> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(ClimaController.class).show(id_clima)).withSelfRel(),
            linkTo(methodOn(ClimaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ClimaController.class).show(id_clima)).withRel("destroy")
        );
    }

}
