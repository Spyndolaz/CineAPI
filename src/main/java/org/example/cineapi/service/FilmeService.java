package org.example.cineapi.service;

import org.example.cineapi.dto.*;
import org.example.cineapi.model.Filme;
import org.example.cineapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public FilmeResponseDTO salvar(FilmeRequestDTO dto) {
        Filme filme = toEntity(dto);
        Filme salvo = repository.save(filme);
        return toResponseDTO(salvo);
    }

    public FilmeResponseDTO buscarId(Long id){
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
            return toResponseDTO(filme);
    }

    public List<FilmeResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public void deletar(Long id){
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        repository.delete(filme);
    }

    public FilmeResponseDTO atualizar (Long id, FilmeRequestDTO dto){
        Filme existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme já existente"));

        existente.setTitulo(dto.titulo());
        existente.setTitulo(dto.titulo());
        existente.setGenero(dto.genero());
        existente.setDiretor(dto.diretor());
        existente.setDuracao(dto.duracao());
        existente.setNota(dto.nota());
        existente.setAnoLancamento(dto.ano());

        Filme atualizado = repository.save(existente);
        return toResponseDTO(atualizado);
    }

    //leva as informações ao banco de dados
    private Filme toEntity(FilmeRequestDTO dto){
        Filme filme = new Filme();
        filme.setTitulo(dto.titulo());
        filme.setGenero(dto.genero());
        filme.setDiretor(dto.diretor());
        filme.setDuracao(dto.duracao());
        filme.setNota(dto.nota());
        filme.setAnoLancamento(dto.ano());
        return filme;
    }

    private FilmeResponseDTO toResponseDTO (Filme filme) {
        return new FilmeResponseDTO(
                filme.getId(),
                filme.getTitulo(),
                filme.getGenero(),
                filme.getDiretor(),
                filme.getNota()
        );

    }
}