package com.example.livros.repository;

import java.util.List;

import com.example.livros.model.Livro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
    
    List<Livro> findByComprador(String comprador);
}
