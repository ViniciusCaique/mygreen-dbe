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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mygreen.config.RestExceptionHandler;
import com.example.mygreen.exceptions.RestNotFoundException;
import com.example.mygreen.models.ClimaAdequado;
import com.example.mygreen.repositories.ClimaAdequadoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearer-key")
@Tag(name = "Clima Adequado")
@RestController
@RequestMapping("/api/climaAdequado")
public class ClimaAdequadoController {


    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ClimaAdequadoRepository climaAdequadoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    @Operation(
        summary = "Detalhar Clima adequado.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){
        Page<ClimaAdequado> climaAdequado = climaAdequadoRepository.findAll(pageable);
        return assembler.toModel(climaAdequado.map(ClimaAdequado:: toEntityModel));
    }



    @PostMapping
    @Operation(
        summary = "Cadastrar Clima adequado.",
        description = "Endpoint que recebe os parametros de registro de clima adequado e cadastra um." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Clima adequado cadastrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid ClimaAdequado climaAdequado){
        climaAdequadoRepository.save(climaAdequado);
        return ResponseEntity.status(HttpStatus.CREATED).body(climaAdequado);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Clima adequado.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<ClimaAdequado> show (@PathVariable Long id){
        var climaAdequado = climaAdequadoRepository.findById(id).orElseThrow(()-> new RestNotFoundException("Clima adequado não encontrado"));
        return climaAdequado.toEntityModel();
    }


    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Clima adequado.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<ClimaAdequado> update(@PathVariable Long id, @RequestBody @Valid ClimaAdequado climaAdequado){
        climaAdequadoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Clima adequado não encontrado"));
        climaAdequado.setId_clima_adequado(id);
        climaAdequadoRepository.save(climaAdequado);
        return climaAdequado.toEntityModel();
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
    public ResponseEntity<ClimaAdequado> destroy(@PathVariable Long id){
        var climaAdequado = climaAdequadoRepository.findById(id).orElseThrow(()-> new RestNotFoundException("Clima adequado não encontrado"));
        climaAdequadoRepository.delete(climaAdequado);
        return ResponseEntity.noContent().build();
        
    }
}
