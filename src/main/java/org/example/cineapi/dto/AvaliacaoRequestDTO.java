package org.example.cineapi.dto;

import jakarta.validation.constraints.*;

public record AvaliacaoRequestDTO(
        @NotNull(message = "Preencha a nota")
        Integer nota,
        @NotBlank (message = "Preencha a nota")
        @Min(value=0, message = "Nota mínima é 0")
        @Max(value=5, message = "Nota máximo é 5")
        String comentario,

        Long id
) {
}
