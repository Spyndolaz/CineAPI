package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long id,
        String titulo,
        Long idDiretor,
        String nomeDiretor,
        String genero,
        Double mediaAvaliacoes
) {}
