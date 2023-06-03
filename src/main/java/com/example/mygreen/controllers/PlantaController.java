package com.example.mygreen.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mygreen.exceptions.RestNotFoundException;
import com.example.mygreen.models.Planta;
import com.example.mygreen.repositories.PlantaRepository;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;



@SecurityRequirement(name = "bearer-key")
@Tag(name = "Planta")
@RestController
@RequestMapping("/api/plantas")
public class PlantaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PlantaRepository plantaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    @Operation(
        summary = "Detalhar Planta.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){

        Page<Planta> plantas = plantaRepository.findAll(pageable);
            
        return assembler.toModel(plantas.map(Planta::toEntityModel)); 
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar Planta.",
        description = "Endpoint que recebe os parametros de registro de planta e cadastra um." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Planta cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid Planta planta){
        plantaRepository.save(planta);
        return ResponseEntity.status(HttpStatus.CREATED).body(planta);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Planta.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<Planta> show(@PathVariable Long id){
        var planta = plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
        return planta.toEntityModel();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Agencia.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<Planta> update(@PathVariable Long id, @RequestBody @Valid Planta planta){
        plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
        planta.setId_planta(id);
        plantaRepository.save(planta);

        return planta.toEntityModel();
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar Agencia.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = ""),
        @ApiResponse(responseCode = "401", description = "")
    })
    public ResponseEntity<Planta> destroy(@PathVariable Long id){
        var planta = plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantação não encontrada"));
        plantaRepository.delete(planta);
        return ResponseEntity.noContent().build();
    }

}
