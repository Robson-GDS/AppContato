package com.robson_gds.appContato.services;

import com.robson_gds.appContato.dto.ContatoMinDTO;
import com.robson_gds.appContato.entities.Contato;
import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.projections.ContatoMinProjection;
import com.robson_gds.appContato.repositories.ContatoRepository;
import com.robson_gds.appContato.services.exceptions.DatabaseException;
import com.robson_gds.appContato.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Contato findById(Long id) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado para o id: " + id));
        return contato;
    }

    public List<ContatoMinDTO> findAllContatosByPessoa(Long idPessoa) {
        List<ContatoMinProjection> contatoMinProjection = repository.findAllContatosByPessoa(idPessoa);
        List<ContatoMinDTO> dto = contatoMinProjection.stream()
                .map(ContatoMinDTO::new).collect(Collectors.toList());
        return dto;
    }

    public Contato update(Long id, Contato obj) {
        try {
            Contato entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado para o id: " + id);
        }
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado para o id: " + id);
        }
        repository.deleteById(id);
    }

    private void updateData(Contato entity, Contato obj) {
        entity.setNumeroContato(obj.getNumeroContato());
        entity.setTipoContato(obj.getTipoContato());
        entity.setPessoa(obj.getPessoa());
    }
}
