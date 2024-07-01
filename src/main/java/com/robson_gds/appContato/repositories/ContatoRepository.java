package com.robson_gds.appContato.repositories;

import com.robson_gds.appContato.entities.Contato;
import com.robson_gds.appContato.projections.ContatoMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    @Query(nativeQuery = true, value = "SELECT " +
            "    c.id AS contatoId, " +
            "    c.numero_contato AS numeroContato, " +
            "    c.tipo_contato AS tipoContato, " +
            "    p.id AS pessoaId " +
            "FROM  " +
            "    tb_contato c " +
            "JOIN  " +
            "    tb_pessoa p ON c.pessoa_id = p.id " +
            "WHERE  " +
            "    p.id = :id")
    List<ContatoMinProjection> findAllContatosByPessoa(Long id);
}
