package com.example.pessoas.repository;

import com.example.pessoas.model.Pessoa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String> {
    
}
