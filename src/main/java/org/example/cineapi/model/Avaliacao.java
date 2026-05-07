package org.example.cineapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvalia;

    @NotNull
    private Integer nota;

    @NotBlank
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id")
    private Filme filme;

    public Avaliacao() {}
}
