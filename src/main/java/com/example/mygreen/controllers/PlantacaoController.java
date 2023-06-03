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
import com.example.mygreen.models.Plantacao;
import com.example.mygreen.repositories.PlantacaoRepository;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;



@SecurityRequirement(name = "bearer-key")
@Tag(name = "Plantacao")
@RestController
@RequestMapping("/api/plantacao")
public class PlantacaoController {

    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PlantacaoRepository plantacaoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    @Operation(
        summary = "Detalhar Plantação.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){

        Page<Plantacao> plantacoes = plantacaoRepository.findAll(pageable);
            
        return assembler.toModel(plantacoes.map(Plantacao::toEntityModel));
    }


    @PostMapping
    @Operation(
        summary = "Cadastrar Plantação.",
        description = "Endpoint que recebe os parametros de registro de plantação e cadastra uma." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Plantação cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Plantacao> create(@RequestBody @Valid Plantacao plantacao){
        plantacaoRepository.save(plantacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(plantacao);
    }

    
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Plantação.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<Plantacao> show(@PathVariable Long id){
        var plantacao = plantacaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantação não encontrada"));
        return plantacao.toEntityModel();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Plantação.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<Plantacao> update(@PathVariable Long id, @RequestBody @Valid Plantacao plantacao){
        plantacaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantação não encontrada"));

        plantacao.setId_plantacao(id);
        plantacaoRepository.save(plantacao);

        return plantacao.toEntityModel();
    }   


    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar Plantação.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = ""),
        @ApiResponse(responseCode = "401", description = "")
    })
    public ResponseEntity<Plantacao> destroy(@PathVariable Long id){
        var plantacao = plantacaoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantação não encontrada"));
        plantacaoRepository.delete(plantacao);
        return ResponseEntity.noContent().build();
    }


}
