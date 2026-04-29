package org.example.cineapi.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Diretor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idDiretor;

        private String nome;
        private String nacionalidade;
        private Integer idade;
        private String biografia;

        @OneToMany(mappedBy = "Diretor")
        private List<Filme> filmes = new ArrayList<>();

        public Diretor() {}
}
