package org.example.cineapi.service;


import org.example.cineapi.dto.*;
import org.example.cineapi.model.*;
import org.example.cineapi.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;
    private final FilmeRepository filmeRepository;

    public AvaliacaoService(AvaliacaoRepository repository, FilmeRepository filmeRepository) {
        this.repository = repository;
        this.filmeRepository = filmeRepository;
    }

    private AvaliacaoResponseDTO toResponseDTO(Avaliacao avaliacao) {
        return new AvaliacaoResponseDTO(
                avaliacao.getIdAvalia(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getFilme().getId(),
                avaliacao.getFilme().getTitulo()
        );
    }

    public AvaliacaoResponseDTO salvar(AvaliacaoRequestDTO dto) {
        Filme filme = filmeRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Filme não encotrado"));
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.nota());
        avaliacao.setComentario(dto.comentario());
        avaliacao.setFilme(filme);

        Avaliacao salva = repository.save(avaliacao);
        return toResponseDTO(salva);
    }

    public List<AvaliacaoResponseDTO> listarPorFilme(Long id) {
        filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        return repository.findByFilmeId(id)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }
}