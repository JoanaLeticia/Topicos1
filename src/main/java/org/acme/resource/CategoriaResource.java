package org.acme.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.model.Categoria;
import org.acme.repository.CategoriaRepository;

@Path("/categorias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    private CategoriaRepository repository;

    @GET
    public List<Categoria> getAll() {
        return repository.findAll().list();
    }

    @POST
    @Transactional
    public Categoria insert(Categoria categoria) {
        repository.persist(categoria);

        return categoria;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Categoria update(@PathParam("id") Long id, Categoria categoria) {

        Categoria entity = repository.findById(id);

        entity.setNome(categoria.getNome());

        return entity;
    }

    @GET
    @Path("/count")
    public long count() {
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Categoria> search(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }
}
