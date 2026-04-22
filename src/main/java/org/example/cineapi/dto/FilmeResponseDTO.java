package org.example.cineapi.dto;

public record FilmeResponseDTO(
        Long id,
        String titulo,
        String genero,
        String diretor,
        Integer nota
) {}
