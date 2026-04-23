package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.*;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service){
        this.service = service;
    }
    @GetMapping
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }
    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }
    @GetMapping("/{id}")
    public FilmeResponseDTO buscarId(@PathVariable Long id){
        return service.buscarId(id);
    }
}