package org.acme.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pessoa extends PanacheEntity {

    private String nome;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return idade;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
