package com.robson_gds.appContato.dto;

import com.robson_gds.appContato.projections.PessoaMinProjection;

public class PessoaMinDTO {
    private Long id;
    private String nome;
    private String malaDireta;

    public PessoaMinDTO() {
    }

    public PessoaMinDTO(Long id, String nome, String mala) {
        this.id = id;
        this.nome = nome;
        this.malaDireta = mala;
    }

    public PessoaMinDTO(PessoaMinProjection projection) {
        id = projection.getId();
        nome = projection.getNome();
        malaDireta = projection.getMalaDireta();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMalaDireta() {
        return malaDireta;
    }

    public void setMalaDireta(String malaDireta) {
        this.malaDireta = malaDireta;
    }

    @Override
    public String toString() {
        return "PessoaMinDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", malaDireta='" + malaDireta + '\'' +
                '}';
    }
}
