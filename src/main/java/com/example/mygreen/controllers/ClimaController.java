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
import com.example.mygreen.models.Clima;
import com.example.mygreen.repositories.ClimaRepository;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;



@SecurityRequirement(name = "bearer-key")
@Tag(name = "Clima")
@RestController
@RequestMapping("/api/climas")
public class ClimaController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ClimaRepository climaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    @Operation(
        summary = "Detalhar Clima.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){

        Page<Clima> climas = climaRepository.findAll(pageable);
            
        return assembler.toModel(climas.map(Clima::toEntityModel));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar Clima.",
        description = "Endpoint que recebe os parametros de registro de clima e cadastra um." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Clima cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Clima> create(@RequestBody @Valid Clima clima){
        climaRepository.save(clima);
        return ResponseEntity.status(HttpStatus.CREATED).body(clima);
    }

        
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Clima.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<Clima> show(@PathVariable Long id){
        var climas = climaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Clima não encontrado"));
        return climas.toEntityModel();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Clima.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<Clima> update(@PathVariable Long id, @RequestBody @Valid Clima clima){
        climaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Clima não encontrada"));

        clima.setId_clima(id);
        climaRepository.save(clima);

        return clima.toEntityModel();
    }   

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar Clima.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = ""),
        @ApiResponse(responseCode = "401", description = "")
    })
    public ResponseEntity<Clima> destroy(@PathVariable Long id){
        var clima = climaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Plantação não encontrada"));
        climaRepository.delete(clima);
        return ResponseEntity.noContent().build();
    }
}
