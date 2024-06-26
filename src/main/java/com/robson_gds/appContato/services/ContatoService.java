package com.robson_gds.appContato.services;

import com.robson_gds.appContato.entities.Contato;
import com.robson_gds.appContato.repositories.ContatoRepository;
import com.robson_gds.appContato.services.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository repository;

    public Contato save(Contato contato) {
        try {
            return repository.save(contato);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Verifique se o id: " + contato.getPessoa().getId() + " existe");
        }
    }

    public List<Contato> findAll() {
        List<Contato> contatos = repository.findAll();
        return contatos;
    }
}
