package com.robson_gds.appContato.repositories;

import com.robson_gds.appContato.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
