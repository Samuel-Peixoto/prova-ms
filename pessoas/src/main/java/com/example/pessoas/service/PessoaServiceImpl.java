package com.example.pessoas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.pessoas.clienteHTTP.LivrosFeignClient;
import com.example.pessoas.model.Pessoa;
import com.example.pessoas.repository.PessoaRepository;
import com.example.pessoas.shared.PessoaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository repo;

    @Autowired
    private LivrosFeignClient livrosMsClient;

    @Override
    public PessoaDto criarPessoa(PessoaDto pessoa) {
        return salvarPessoa(pessoa);
    }

    @Override
    public List<PessoaDto> obterTodos() {
        List<Pessoa> pessoas = repo.findAll();

        return pessoas.stream()
            .map(pessoa -> new ModelMapper().map(pessoa, PessoaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<PessoaDto> obterPorId(String id) {
       Optional<Pessoa> pessoa = repo.findById(id);

        
       if(pessoa.isPresent()) {
           PessoaDto dto = new ModelMapper().map(pessoa.get(), PessoaDto.class);
           dto.setLivros(livrosMsClient.obterLivros(id));
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerPessoa(String id) {
        repo.deleteById(id);
    }

    @Override
    public PessoaDto atualizarPessoa(String id, PessoaDto pessoa) {
        pessoa.setId(id);
        return salvarPessoa(pessoa);
    }

    private PessoaDto salvarPessoa(PessoaDto pessoa) {
        ModelMapper mapper = new ModelMapper();
        Pessoa pessoaEntidade = mapper.map(pessoa, Pessoa.class);
        pessoaEntidade = repo.save(pessoaEntidade);

        return mapper.map(pessoaEntidade, PessoaDto.class);
    }
}