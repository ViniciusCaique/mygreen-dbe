package com.example.mygreen.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import com.example.mygreen.controllers.PlantacaoController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
public class Plantacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plantacao;

    @NotNull
    private LocalDate dataPlantacao;
    
    @NotNull
    private int quantidadeAgua;
    
    @NotNull
    private Boolean fertilizante;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_planta")
    private Planta planta;


    public EntityModel<Plantacao> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(PlantacaoController.class).show(id_plantacao)).withSelfRel(),
            linkTo(methodOn(PlantacaoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PlantacaoController.class).show(id_plantacao)).withRel("destroy")
        );
    }

}
