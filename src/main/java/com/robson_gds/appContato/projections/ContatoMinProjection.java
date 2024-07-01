package com.robson_gds.appContato.projections;

import com.robson_gds.appContato.entities.enums.TipoContato;

public interface ContatoMinProjection {
    Long getContatoId();
    String getNumeroContato();
    TipoContato getTipoContato();
    Long getPessoaId();
}
