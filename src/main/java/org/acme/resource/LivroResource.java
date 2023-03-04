package org.acme.resource;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.Livro;

@Path("/livro")
public class LivroResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro insert(Livro livro) {
        livro.persist();

        return livro;
    }

    @PUT
    @Path("{/id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro update(@PathParam("id") Long id, Livro livro){
        Livro entity = Livro.findById(id);

        entity.setAutor(livro.getAutor());
        entity.setEditora(livro.getEditora());
        entity.setIdioma(livro.getIdioma());
        entity.setNome(livro.getNome());
        entity.setIsbn(livro.getIsbn());

        return entity;
    }

    @DELETE
    @Path("{/id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteOrderById(@PathParam("id") int id){
        return Response.status(200).entity("Livro excluído").build();
    }

    @GET
    public List<Livro> getAll() {
        return Livro.findAll().list();
    }

    @GET
    public List<Livro> getById() {
        return Livro.findById(getById());
    }

    /*@GET
    public List findByNome(String nome) {
        return em.createQuery(
            "SELECT l FROM Livro l WHERE l.nome LIKE :teoria")
            .setParameter("teoria", nome)
            .setMaxResults(10)
            .getResultList();
    }*/
}
