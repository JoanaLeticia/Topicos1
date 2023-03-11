package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;

import org.acme.model.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    public List<Livro> findByNome(String nome){
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
}
