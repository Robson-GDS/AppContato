package com.robson_gds.appContato.services;

import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.dto.PessoaMinDTO;
import com.robson_gds.appContato.projections.PessoaMinProjection;
import com.robson_gds.appContato.repositories.PessoaRepository;
import com.robson_gds.appContato.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = repository.findAll();
        return pessoas;
    }

    public Pessoa findPessoaById(Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado para o id: " + id));
        return pessoa;
    }

    public PessoaMinDTO findPessoaAndMaladiretaById(Long id) {
        PessoaMinProjection pessoaMinProjection = repository.findPessoaAndMaladiretaById(id);
        PessoaMinDTO dto = new PessoaMinDTO(pessoaMinProjection);
        return dto;
    }

    public Pessoa update(Long id, Pessoa obj) {
        try {
            Pessoa entity = repository.getReferenceById(id);
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

    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setEndereco(obj.getEndereco());
        entity.setCep(obj.getCep());
        entity.setCidade(obj.getCidade());
        entity.setUf(obj.getUf());
    }
}
