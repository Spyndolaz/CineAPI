package org.example.cineapi.dto;

import jakarta.validation.constraints.*;

public record FilmeRequestDTO(
        @NotBlank(message = "Preencha o título")
        String titulo,
        @NotBlank(message = "Preencha o gênero")
        String genero,
        @NotBlank(message = "Preencha o diretor")
        String diretor,
        @NotNull(message = "Preencha o ano de lançamento")
        @Min(value = 1895)
        @Max(value = 2026)
        Integer ano,
        @NotNull(message = "Preencha a duração")
        @Positive
        Integer duracao,
        @Min(value = 0)
        @Max(value = 5)
        Integer nota
) {}

