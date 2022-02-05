package com.example.livros.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LivroModeloInclusao {
    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;
    private Integer codigo;
    private String autor;
    private Integer numPag;
    private Double valor;
    @NotBlank(message = "Comprador não pode estar em branco")
    @NotEmpty(message = "Comprador não pode estar vazio")
    private String comprador;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Integer getNumPag() {
        return numPag;
    }
    public void setNumPag(Integer numPag) {
        this.numPag = numPag;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getComprador() {
        return comprador;
    }
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    
    
}
