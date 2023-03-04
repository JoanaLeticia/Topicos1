package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.Categoria;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepository<Categoria> {
    public Categoria findbyNome(String nome) {
        return find("nome", nome).firstResult();
    }
}
