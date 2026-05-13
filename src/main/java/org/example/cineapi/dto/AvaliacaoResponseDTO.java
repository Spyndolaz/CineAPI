package org.example.cineapi.dto;

public record AvaliacaoResponseDTO(
        Long idAvaliacao,
        Integer nota,
        String comentario,
        Long id,
        String titulo
) {}
