package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long id,
        String titulo,
        String genero,
        Integer ano,
        Integer duracao,
        Long idDiretor,
        String nomeDiretor,
        Double mediaAvaliacoes,
        Integer quantidadeAvaliacoes

) {}
