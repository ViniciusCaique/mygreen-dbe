package com.example.mygreen.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.mygreen.controllers.ClimaAdequadoController;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ClimaAdequado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_clima_adequado;

    @NotBlank
    private String turno;
    
    @NotNull
    private LocalDate duracao;

    @ManyToOne
    @JoinColumn(name = "id_clima")
    private Clima clima;    

    @ManyToOne
    @JoinColumn(name = "id_planta")
    private Planta planta;

    public EntityModel<ClimaAdequado> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(ClimaAdequadoController.class).show(id_clima_adequado)).withSelfRel(),
            linkTo(methodOn(ClimaAdequadoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ClimaAdequadoController.class).show(id_clima_adequado)).withRel("destroy")
        );
    }
    
}
