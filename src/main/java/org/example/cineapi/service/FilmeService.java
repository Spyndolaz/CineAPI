package org.example.cineapi.service;

import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
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

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme buscarId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public List<Filme> listar(){
        return repository.findAll();
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