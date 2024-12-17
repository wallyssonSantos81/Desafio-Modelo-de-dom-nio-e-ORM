package com.devsuperior.desafioorm.etities;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devsuperior.desafioorm.repository.AtividadeRepository;
import com.devsuperior.desafioorm.repository.BlocoRepository;
import com.devsuperior.desafioorm.repository.CategoriaRepository;
import com.devsuperior.desafioorm.repository.ParticipanteRepository;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired private CategoriaRepository categoriaRepo;
    @Autowired private BlocoRepository blocoRepo;
    @Autowired private ParticipanteRepository participanteRepo;
    @Autowired private AtividadeRepository atividadeRepo;

    @Override
    public void run(String... args) {
        Categoria c1 = new Categoria(null, "Curso");
        Categoria c2 = new Categoria(null, "Oficina");

        Bloco b1 = new Bloco(Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T11:00:00Z"));
        Bloco b2 = new Bloco(Instant.parse("2017-09-25T14:00:00Z"), Instant.parse("2017-09-25T18:00:00Z"));
        Bloco b3 = new Bloco(Instant.parse("2017-09-26T08:00:00Z"), Instant.parse("2017-09-26T11:00:00Z"));

        Atividade a1 = new Atividade(null, "Curso de HTML", "Aprenda HTML de forma prática", 80.0);
        a1.setCategoria(c1);
        a1.getBlocos().addAll(Arrays.asList(b1, b2));

        Atividade a2 = new Atividade(null, "Oficina de GitHub", "Controle versões de seus projetos", 50.0);
        a2.setCategoria(c2);
        a2.getBlocos().add(b3);

        Participante p1 = new Participante(null, "José Silva", "jose@gmail.com");
        Participante p2 = new Participante(null, "Tiago Faria", "tiago@gmail.com");
        Participante p3 = new Participante(null, "Maria do Rosário", "maria@gmail.com");
        Participante p4 = new Participante(null, "Teresa Silva", "teresa@gmail.com");

        // Persistir dados
        categoriaRepo.saveAll(Arrays.asList(c1, c2));
        blocoRepo.saveAll(Arrays.asList(b1, b2, b3));
        atividadeRepo.saveAll(Arrays.asList(a1, a2));
        participanteRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
    }

}
