package org.acme.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.dto.LivroDTO;
import org.acme.dto.LivroResponseDTO;
import org.acme.service.LivroService;

@Path("/livro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroResource {

    @Inject
    LivroService livroService;

    @GET
    public List<LivroResponseDTO> getAll() {
        return livroService.getAll();
    }

    @GET
    @Path("/{id}")
    public LivroResponseDTO findById(@PathParam("id") Long id) {
        return livroService.findById(id);
    }

    @POST
    public Response insert(LivroDTO dto){
        LivroResponseDTO livro = livroService.create(dto);
        return Response.status(Status.CREATED).entity(livro).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, LivroDTO dto) {
        LivroResponseDTO livro = livroService.update(id, dto);
        return Response.ok(livro).build();
    }

    @PUT
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        livroService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return livroService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<LivroResponseDTO> search(@PathParam("nome") String nome){
        return livroService.findByNome(nome);
    }
}
