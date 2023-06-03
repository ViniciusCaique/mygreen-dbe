package com.example.mygreen.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.mygreen.models.Clima;
import com.example.mygreen.models.ClimaAdequado;
import com.example.mygreen.models.Planta;
import com.example.mygreen.models.Plantacao;
import com.example.mygreen.models.Usuario;
import com.example.mygreen.repositories.ClimaAdequadoRepository;
import com.example.mygreen.repositories.ClimaRepository;
import com.example.mygreen.repositories.PlantaRepository;
import com.example.mygreen.repositories.PlantacaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    ClimaRepository climaRepository;

    @Autowired
    ClimaAdequadoRepository climaAdequadoRepository;
    
    @Autowired
    PlantaRepository plantaRepository;

    @Autowired
    PlantacaoRepository plantacaoRepository;    

    @Override
    public void run(String... args) throws Exception {
        Clima c1 = new Clima(1L, "Muitas nuvens", "Nublado", 17);
        Clima c2 = new Clima(2L, "Ensolarado", "Calor", 10);
        Clima c3 = new Clima(3L, "Chuvoso", "Frio", 10);
        climaRepository.saveAll(List.of(c1, c2, c3));

        Planta planta1 = new Planta(1L, "Alface", "A alface é uma planta herbácea, com um caule diminuto ao qual se prendem as folhas", "comestível");
        Planta planta2 = new Planta(2L, "amoreira", "A amoreira é um árvore decídua, cujo fruto, a amora, é apreciado no mundo todo. Seu porte é médio, alcançando de 4 a 12 metros de altura.", "comestível");
        Planta planta3 = new Planta(1L, "Limoeira", "O limoeiro, Citrus limon, é uma planta relativamente pequena e de copa arredondada", "comestível");
        plantaRepository.saveAll(List.of(planta1, planta2, planta3));


        // Usuario u1 = new Usuario(1L, "Fernando", "Fernando@gmail.com", "rM74%7^Ocnv%");
        // Usuario u2 = new Usuario(2L, "Cesar", "Cesar@gmail.com", "w4B0!u4bA%&^");
        // Usuario u3 = new Usuario(3L, "Carlos", "Carlos@gmail.com", "dK13z%w6$zXY");
        // usuarioRepository.saveAll(List.of(u1, u2, u3));


        climaAdequadoRepository.saveAll(List.of(
            ClimaAdequado.builder().clima(c1).planta(planta2).turno("manhã").duracao(LocalDate.now()).build(),
            ClimaAdequado.builder().clima(c2).planta(planta1).turno("vespertino").duracao(LocalDate.now()).build(),
            ClimaAdequado.builder().clima(c3).planta(planta3).turno("noite").duracao(LocalDate.now()).build()
        ));

        // plantacaoRepository.saveAll(List.of(
        //     Plantacao.builder().dataPlantacao(LocalDate.now()).quantidadeAgua(15).fertilizante(true).usuario(u1).planta(planta1)
        //     Plantacao.builder().dataPlantacao(LocalDate.now()).quantidadeAgua(100).fertilizante(false).usuario(u2).planta(planta2)
        //     Plantacao.builder().dataPlantacao(LocalDate.now()).quantidadeAgua(50).fertilizante(true).usuario(u3).planta(planta3)
        // ));


    }


    

    
    
}
