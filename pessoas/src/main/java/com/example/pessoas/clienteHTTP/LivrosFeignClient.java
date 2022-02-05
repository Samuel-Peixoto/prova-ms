package com.example.pessoas.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import com.example.pessoas.shared.Livro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "livros-ms", fallback = LivrosFeignClientFallback.class)
public interface LivrosFeignClient {
    @GetMapping(path = "/api/livros/{comprador}/listagem")
    List<Livro> obterLivros(@PathVariable String comprador);   
}

@Component
class LivrosFeignClientFallback implements LivrosFeignClient {

    @Override
    public List<Livro> obterLivros(String comprador) {
        return new ArrayList<>();
    }
}
