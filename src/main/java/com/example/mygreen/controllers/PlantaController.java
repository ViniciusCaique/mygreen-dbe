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
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){

        Page<Planta> plantas = plantaRepository.findAll(pageable);
            
        return assembler.toModel(plantas.map(Planta::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Planta planta){
        log.info("erro create: "+ planta);

        plantaRepository.save(planta);
        
        log.info("erro create: "+ planta);
        return ResponseEntity.status(HttpStatus.CREATED).body(planta);
    }

    @GetMapping("{id}")
    public EntityModel<Planta> show(@PathVariable Long id){
        var planta = plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
        return planta.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Planta> update(@PathVariable Long id, @RequestBody @Valid Planta planta){
        plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
        log.info("erro update: "+ planta);
        planta.setId_planta(id);
        plantaRepository.save(planta);
        log.info("erro update 2: "+ planta);

        return planta.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Planta> destroy(@PathVariable Long id){
        var planta = plantaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Planta não encontrada"));
        plantaRepository.delete(planta);
        return ResponseEntity.noContent().build();
    }

}
