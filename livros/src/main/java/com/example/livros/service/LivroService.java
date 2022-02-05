package com.example.livros.service;

import java.util.List;
import java.util.Optional;

import com.example.livros.shared.LivroDto;

public interface LivroService {
    LivroDto criarLivro(LivroDto livro);
    List<LivroDto> obterLivros();
    Optional<LivroDto> obterLivroId(String id);
    List<LivroDto> obterPorComprador(String comprador);
    void removerLivro(String id);
    boolean definirNaoVendido(String id);
    LivroDto atualizarLivro(String id, LivroDto livro); 
}
