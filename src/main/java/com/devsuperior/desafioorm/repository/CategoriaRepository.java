package com.devsuperior.desafioorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.desafioorm.etities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
