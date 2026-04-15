package org.example.cineapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Filme {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Preencha o título")
        private String titulo;
        @NotBlank(message = "Preencha o gênero")
        private String genero;

        @NotBlank(message = "Preencha o diretor")
        private String diretor;

        @NotNull(message = "Preencha o ano de lançamento")
        @Min(value = 1895)
        @Max(value = 2026)
        private Integer anoLancamento;

        @NotNull(message = "Preencha a duração")
        @Positive
        private Integer duracao;

        @Min(value = 0)
        @Max(value = 5)
        private Integer nota;

        public Filme() {}
}
