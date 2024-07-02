package com.robson_gds.appContato.controllers;

import com.robson_gds.appContato.dto.ContatoMinDTO;
import com.robson_gds.appContato.entities.Contato;
import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.services.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    private ContatoService service;

    @Operation(summary = "Busca todos os contatos cadastrados")
    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> contatos = service.findAll();
        return ResponseEntity.ok().body(contatos);
    }

    @Operation(summary = "lista todos os Contatos de uma Pessoa")
    @GetMapping("pessoa/{idPessoa}")
    public ResponseEntity<List<ContatoMinDTO>> findAllContatosByPessoa(@PathVariable Long idPessoa) {
        List<ContatoMinDTO> dtos = service.findAllContatosByPessoa(idPessoa);
        return ResponseEntity.ok().body(dtos);
    }

    @Operation(summary = "retorna os dados de um Contato por ID")
    @GetMapping("{id}")
    public ResponseEntity<Contato> findContatoById(@PathVariable Long id) {
        Contato contato = service.findById(id);
        return ResponseEntity.ok().body(contato);
    }

    @Operation(summary = "adiciona um novo Contato a uma Pessoa")
    @PostMapping
    public ResponseEntity<Contato> save(@Valid @RequestBody Contato contato) {
        contato = service.save(contato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "atualiza um Contato existente")
    @PutMapping("{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @Valid @RequestBody Contato contato) {
        contato = service.update(id, contato);
        return ResponseEntity.ok().body(contato);
    }

    @Operation(summary = "remove um Contato por ID")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
