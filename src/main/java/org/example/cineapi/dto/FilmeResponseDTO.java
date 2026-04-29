package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long id,
        String titulo,
        Long idDiretor,
        String genero,
        String nomeDiretor,
        Integer nota
) {}
