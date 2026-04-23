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
        private String titulo;
        private String genero;
        private String diretor;
        private Integer anoLancamento;
        private Integer duracao;
        private Integer nota;

        public Filme() {}
}
