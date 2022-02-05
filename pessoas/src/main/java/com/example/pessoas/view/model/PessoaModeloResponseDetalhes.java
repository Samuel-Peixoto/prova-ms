package com.example.pessoas.view.model;

import java.util.List;

import com.example.pessoas.shared.Livro;

public class PessoaModeloResponseDetalhes {
    private String id;
    private String nome;
    private String sobrenome;
    private List<Livro> livros;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public List<Livro> getLivros() {
        return livros;
    }
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
}
