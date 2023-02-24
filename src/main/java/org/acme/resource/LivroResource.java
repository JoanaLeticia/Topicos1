package org.acme.resource;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.model.Livro;

@Path("/livro")
public class LivroResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Livro test() {
        Livro l = new Livro();
        l.setNome("Bíblia Sagrada");
        l.setCodigo(2304);

        return l;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> getAll() {
        return Livro.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro insert(Livro livro) {
        livro.persist();
        return livro;
    }
}