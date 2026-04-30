package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.DiretorRequestDTO;
import org.example.cineapi.dto.DiretorResponseDTO;
import org.example.cineapi.dto.FilmeRequestDTO;
import org.example.cineapi.dto.FilmeResponseDTO;
import org.example.cineapi.service.DiretorService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService service;
    private final FilmeService filmeService;

    public DiretorController (DiretorService service, FilmeService filmeService) {
        this.service = service;
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<DiretorResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public DiretorResponseDTO salvar(@RequestBody @Valid DiretorRequestDTO dto){
        return service.salvar(dto);
    }

    @GetMapping("/{idDiretor}")
    public DiretorResponseDTO buscarPorId (@PathVariable Long idDiretor){
        return service.buscarPorId(idDiretor);
    }

    @GetMapping("/{idDiretor}/filmes")
    public List<FilmeResponseDTO> listarFilmePorDiretor (@PathVariable Long idDiretor) {
        return filmeService.listarFilmePorDiretor(idDiretor);
    }


}
