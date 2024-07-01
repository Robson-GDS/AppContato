package com.robson_gds.appContato.dto;

import com.robson_gds.appContato.entities.Pessoa;
import com.robson_gds.appContato.entities.enums.TipoContato;
import com.robson_gds.appContato.projections.ContatoMinProjection;

import java.util.Objects;

public class ContatoMinDTO {
    private Long contatoId;
    private String numeroContato;
    private TipoContato tipoContato;
    private Long pessoaId;

    public ContatoMinDTO() {
    }

    public ContatoMinDTO(Long contatoId, String numeroContato, TipoContato tipoContato, Long pessoaId) {
        this.contatoId = contatoId;
        this.numeroContato = numeroContato;
        this.tipoContato = tipoContato;
        this.pessoaId = pessoaId;
    }

    public ContatoMinDTO(ContatoMinProjection projection) {
        contatoId = projection.getContatoId();
        numeroContato = projection.getNumeroContato();
        tipoContato = projection.getTipoContato();
        pessoaId = projection.getPessoaId();
    }

    public Long getContatoId() {
        return contatoId;
    }

    public void setContatoId(Long contatoId) {
        this.contatoId = contatoId;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoMinDTO that = (ContatoMinDTO) o;
        return Objects.equals(contatoId, that.contatoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contatoId);
    }

    @Override
    public String toString() {
        return "ContatoMinDTO{" +
                "contatoId=" + contatoId +
                ", numeroContato='" + numeroContato + '\'' +
                ", tipoContato=" + tipoContato +
                ", pessoaId=" + pessoaId +
                '}';
    }
}
