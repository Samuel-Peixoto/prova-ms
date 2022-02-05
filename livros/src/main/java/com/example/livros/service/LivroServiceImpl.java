package com.example.livros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.livros.model.Livro;
import com.example.livros.repository.LivroRepository;
import com.example.livros.shared.LivroDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    private LivroRepository repo;

    @Override
    public LivroDto criarLivro(LivroDto livro) {
        return salvarLivro(livro);
    }

    @Override
    public List<LivroDto> obterLivros() {
        List<Livro> livros = repo.findAll();

        return livros.stream()
                .map(livro -> new ModelMapper().map(livro, LivroDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LivroDto> obterLivroId(String id) {
        Optional<Livro> livro = repo.findById(id);

       if(livro.isPresent()) {
           return Optional.of(new ModelMapper().map(livro.get(), LivroDto.class));
       }

       return Optional.empty();
    }

    @Override
    public List<LivroDto> obterPorComprador(String comprador) {
        List<Livro> livros = repo.findByComprador(comprador);

        return livros.stream()
            .map(livro -> new ModelMapper().map(livro, LivroDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void removerLivro(String id) {
        repo.deleteById(id);

    }

    @Override
    public boolean definirNaoVendido(String id) {
        Optional<Livro> livro = repo.findById(id);
        if(livro.isPresent()) {
            livro.get().setVendido(false);
            repo.save(livro.get());

            return true;
        }

        return false;
    }

    @Override
    public LivroDto atualizarLivro(String id, LivroDto livro) {
        livro.setId(id);
        return salvarLivro(livro);
    }

    private LivroDto salvarLivro(LivroDto livro) {
        ModelMapper mapper = new ModelMapper();
        Livro livroObjeto = mapper.map(livro, Livro.class);
        livroObjeto = repo.save(livroObjeto);

        return mapper.map(livroObjeto, LivroDto.class);
    }

}
