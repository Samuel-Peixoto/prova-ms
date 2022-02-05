package com.example.livros.shared;


public class LivroDto {
    private String id;
    private String nome;
    private Integer codigo;
    private String autor;
    private Integer numPag;
    private Double valor;
    private String comprador;
    private Boolean vendido;

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
    public Boolean getVendido() {
        return vendido;
    }
    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }
    public String getComprador() {
        return comprador;
    }
    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    
}
