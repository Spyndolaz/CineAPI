package org.example.cineapi.dto;

import jakarta.validation.constraints.*;
public record DiretorRequestDTO(

        @NotBlank(message = "Preencha o nome")
        String nome,
        @NotBlank(message = "Preencha a nacionalidade")
        String nacionalidade,
        @Min(value = 18, message = "Idade menor que 18")
        @Max(value = 106, message = "Idade maior que 100")
        Integer idade,
        String biografia
)
{}
