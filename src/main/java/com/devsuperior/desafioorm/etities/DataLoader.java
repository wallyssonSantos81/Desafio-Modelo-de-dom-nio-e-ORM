package com.devsuperior.desafioorm.etities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devsuperior.desafioorm.etities.Atividade;
import com.devsuperior.desafioorm.etities.Bloco;
import com.devsuperior.desafioorm.etities.Categoria;
import com.devsuperior.desafioorm.etities.Participante;
import com.devsuperior.desafioorm.repository.AtividadeRepository;
import com.devsuperior.desafioorm.repository.BlocoRepository;
import com.devsuperior.desafioorm.repository.CategoriaRepository;
import com.devsuperior.desafioorm.repository.ParticipanteRepository;

import java.time.Instant;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private BlocoRepository blocoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    public void run(String... args) throws Exception {

        // Categorias
        Categoria c1 = new Categoria(null, "Curso");
        Categoria c2 = new Categoria(null, "Oficina");

        categoriaRepository.save(c1);
        categoriaRepository.save(c2);

        // Atividades
        Atividade a1 = new Atividade(null, "Curso de HTML", "Aprenda HTML de forma prática", 80.0, c1);
        Atividade a2 = new Atividade(null, "Oficina de Github", "Controle versões de seus projetos", 50.0, c2);

        atividadeRepository.save(a1);
        atividadeRepository.save(a2);

        // Blocos
        Bloco b1 = new Bloco(null, Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T11:00:00Z"));
        Bloco b2 = new Bloco(null, Instant.parse("2017-09-25T14:00:00Z"), Instant.parse("2017-09-25T18:00:00Z"));
        Bloco b3 = new Bloco(null, Instant.parse("2017-09-26T08:00:00Z"), Instant.parse("2017-09-26T11:00:00Z"));

        blocoRepository.save(b1);
        blocoRepository.save(b2);
        blocoRepository.save(b3);

        // Participantes
        Participante p1 = new Participante(null, "José Silva", "jose@gmail.com");
        Participante p2 = new Participante(null, "Tiago Faria", "tiago@gmail.com");
        Participante p3 = new Participante(null, "Maria do Rosário", "maria@gmail.com");
        Participante p4 = new Participante(null, "Teresa Silva", "teresa@gmail.com");

        participanteRepository.save(p1);
        participanteRepository.save(p2);
        participanteRepository.save(p3);
        participanteRepository.save(p4);
    }
}
