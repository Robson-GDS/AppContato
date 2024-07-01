package com.robson_gds.appContato.repositories;

import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.projections.PessoaMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query(nativeQuery = true, value = "SELECT id, nome, CONCAT(endereco, ' - ', ' CEP: ', cep, ' ', ' - ', cidade, '/', uf) AS malaDireta " +
            "FROM tb_pessoa " +
            "WHERE id = :id")
    Optional<PessoaMinProjection> findPessoaAndMaladiretaById(Long id);
}
