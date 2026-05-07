package org.example.cineapi.dto;

import jakarta.validation.constraints.*;

public record AvaliacaoRequestDTO(
        @Min(value=0, message = "Nota mínima é 0")
        @Max(value=5, message = "Nota máximo é 5")
        @NotNull(message = "Preencha a nota")
        Integer nota,
        @NotBlank (message = "Preencha a nota")
        String comentario,

        Long id
) {
}
