package com.devsuperior.desafioorm.etities;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Autowired
    private ParticipanteRepository participanteRepo;

    @Autowired
    private AtividadeRepository atividadeRepo;

    @Autowired
    private BlocoRepository blocoRepo;

    @Override
    public void run(String... args) throws Exception {
        Categoria c1 = new Categoria(null, "Curso");
        Categoria c2 = new Categoria(null, "Oficina");

        Bloco b1 = new Bloco(Instant.parse("2017-09-25T08:00:00Z"), Instant.parse("2017-09-25T11:00:00Z"));
        Bloco b2 = new Bloco(Instant.parse("2017-09-25T14:00:00Z"), Instant.parse("2017-09-25T18:00:00Z"));

        Atividade a1 = new Atividade(null, "Curso de HTML", "Aprenda HTML de forma prática", 80.0);
        a1.setCategoria(c1);
        a1.getBlocos().add(b1);

        Participante p1 = new Participante(null, "José Silva", "jose@gmail.com");
        p1.getAtividades().add(a1);



}
