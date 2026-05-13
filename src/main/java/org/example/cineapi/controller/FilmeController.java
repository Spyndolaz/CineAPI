package org.example.cineapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.cineapi.dto.*;
import org.example.cineapi.model.Filme;
import org.example.cineapi.service.AvaliacaoService;
import org.example.cineapi.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@Tag(name= "Filmes", description = "Enspoints para gerenciamento de filmes")
public class FilmeController {

    private final FilmeService service;
    private final AvaliacaoService avaliacaoService;

    public FilmeController(FilmeService service, AvaliacaoService avaliacaoService) {
        this.service = service;
        this.avaliacaoService = avaliacaoService;
    }
    @Operation(summary = "Listar Filmes", description = "Retorna todos os filmes cadastrados")
    @GetMapping
    public List<FilmeResponseDTO> listar(){
        return service.listar();
    }
    @Operation(summary = "Salvar Filmes", description = "Salva o cadastro do filme")
    @PostMapping
    public FilmeResponseDTO salvar(@RequestBody @Valid FilmeRequestDTO dto){
        return service.salvar(dto);
    }
    @Operation(summary = "Buscar ID", description = "Buscar o id do filme e o mostra")
    @GetMapping("/{id}")
    public FilmeResponseDTO buscarId(@PathVariable Long id){
        return service.buscarId(id);
    }
    @Operation(summary = "Deletar Filmes", description = "Deleta o filme por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
    @Operation(summary = "Atualizar Filmes", description = "Atualiza o cadastro do filme")
    @PutMapping("/{id}")
    public FilmeResponseDTO atualizar(@PathVariable Long id, @RequestBody FilmeRequestDTO dto){
        return service.atualizar(id, dto);
    }
    @Operation(summary = "Listar Avaliação Filmes", description = "Lista as avaliações por filme")
    @GetMapping("/{id}/avaliacoes")
    public List<AvaliacaoResponseDTO> listarAvaliacaoPorFilmes(@PathVariable Long id){
        return avaliacaoService.listarPorFilme(id);

    }
    @Operation(summary = "Busca o filme por Titulo", description = "Busca o filme pelo título dele")
    @GetMapping("/buscar")
    public List<FilmeResponseDTO> buscarPorTitulo(@RequestParam String titulo){
        return service.buscarPorTitulo(titulo);
    }
    @Operation(summary = "Buscar por Genero", description = "Busca um filme com base no genero")
    @GetMapping("/genero")
    public List<FilmeResponseDTO> buscarPorGenero(@RequestParam String genero){
        return service.buscarPorGenero(genero);
    }


}