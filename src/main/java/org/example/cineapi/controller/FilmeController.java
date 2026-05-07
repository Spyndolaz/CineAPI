package org.example.cineapi.controller;

import jakarta.validation.Valid;
import org.example.cineapi.dto.*;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.AvaliacaoService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController(FilmeService service, AvaliacaoService avaliacaoService) {
        this.service = service;
        this.avaliacaoService = avaliacaoService;
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

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    @PutMapping("/{id}")
    public FilmeResponseDTO atualizar(@PathVariable Long id, @RequestBody FilmeRequestDTO dto){
        return service.atualizar(id, dto);
    }

    @GetMapping("/{id}/avaliacoes")
    public List<AvaliacaoResponseDTO> listarAvaliacaoPorFilmes(@PathVariable Long id){
        return avaliacaoService.listarPorFilme(id);

    }

}