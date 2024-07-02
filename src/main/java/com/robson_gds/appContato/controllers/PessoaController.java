package com.robson_gds.appContato.controllers;

import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.dto.PessoaMinDTO;
import com.robson_gds.appContato.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @Operation(summary = "Busca todas as Pessoas cadastradas")
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = service.findAll();
        return ResponseEntity.ok().body(pessoas);
    }

    @Operation(summary = "retorna os dados de uma Pessoa por ID")
    @GetMapping("{id}")
    public ResponseEntity<Pessoa> findPessoaById(@PathVariable Long id) {
        Pessoa pessoa = service.findPessoaById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @Operation(summary = "retorna os dados de uma Pessoa por ID para mala direta")
    @GetMapping("maladireta/{id}")
    public ResponseEntity<PessoaMinDTO> findPessoaAndMaladiretaById(@PathVariable Long id) {
       PessoaMinDTO dto = service.findPessoaAndMaladiretaById(id);
       return ResponseEntity.ok().body(dto);
    }

    @Operation(summary = "cria uma nova Pessoa")
    @PostMapping
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {
        pessoa = service.save(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @Operation(summary = "atualiza uma Pessoa existente")
    @PutMapping("{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id,@Valid @RequestBody Pessoa pessoa) {
        pessoa = service.update(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @Operation(summary = "remove uma Pessoa por ID")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
