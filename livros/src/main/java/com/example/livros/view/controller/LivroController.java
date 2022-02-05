package com.example.livros.view.controller;


import com.example.livros.service.LivroService;
import com.example.livros.shared.LivroDto;
import com.example.livros.view.model.LivroModeloAlteracao;
import com.example.livros.view.model.LivroModeloInclusao;
import com.example.livros.view.model.LivroModeloResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<LivroModeloResponse> criarAnimal(@RequestBody @Valid LivroModeloInclusao Livro) {
        ModelMapper mapper = new ModelMapper();
        LivroDto dto = mapper.map(Livro, LivroDto.class);
        dto = service.criarLivro(dto);
        return new ResponseEntity<>(mapper.map(dto, LivroModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<LivroModeloResponse>> obterLivros() {
        List<LivroDto> dtos = service.obterLivros();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LivroModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LivroModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{comprador}/listagem")
    public ResponseEntity<List<LivroModeloResponse>> obterPorComprador(@PathVariable String comprador) {
        List<LivroDto> dtos = service.obterPorComprador(comprador);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<LivroModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, LivroModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<LivroModeloResponse> obterLivroId(@PathVariable String id) {
        Optional<LivroDto> Livro = service.obterLivroId(id);

        if(Livro.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Livro.get(), LivroModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<LivroModeloResponse> atualizarLivro(@PathVariable String id,
        @Valid @RequestBody LivroModeloAlteracao Livro) {
        ModelMapper mapper = new ModelMapper();
        LivroDto dto = mapper.map(Livro, LivroDto.class);
        dto = service.atualizarLivro(id, dto);

        return new ResponseEntity<>(mapper.map(dto, LivroModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerLivro(@PathVariable String id) {
        service.removerLivro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Void> definirNaoVendido(@PathVariable String id) {
        if(service.definirNaoVendido(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
