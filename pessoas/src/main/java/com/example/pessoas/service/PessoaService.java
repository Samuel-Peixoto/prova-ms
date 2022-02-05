package com.example.pessoas.service;

import java.util.List;
import java.util.Optional;

import com.example.pessoas.shared.PessoaDto;

public interface PessoaService {
    PessoaDto criarPessoa(PessoaDto pessoa);
    List<PessoaDto> obterTodos();
    Optional<PessoaDto> obterPorId(String id);
    void removerPessoa(String id);
    PessoaDto atualizarPessoa(String id, PessoaDto pessoa);
}
