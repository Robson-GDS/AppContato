package com.robson_gds.appContato.controllers;

import com.robson_gds.appContato.dto.ContatoMinDTO;
import com.robson_gds.appContato.entities.Contato;
import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.services.ContatoService;
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

    @GetMapping
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> contatos = service.findAll();
        return ResponseEntity.ok().body(contatos);
    }

    @GetMapping("pessoa/{idPessoa}")
    public ResponseEntity<List<ContatoMinDTO>> findAllContatosByPessoa(@PathVariable Long idPessoa) {
        List<ContatoMinDTO> dtos = service.findAllContatosByPessoa(idPessoa);
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<Contato> save(@Valid @RequestBody Contato contato) {
        contato = service.save(contato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @Valid @RequestBody Contato contato) {
        contato = service.update(id, contato);
        return ResponseEntity.ok().body(contato);
    }

}
