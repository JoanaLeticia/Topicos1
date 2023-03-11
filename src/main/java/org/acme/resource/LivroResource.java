package org.acme.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
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

import org.acme.dto.LivroDTO;
import org.acme.dto.LivroResponseDTO;
import org.acme.model.Livro;
import org.acme.repository.CategoriaRepository;
import org.acme.repository.LivroRepository;

@Path("/livro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroResource {

    @Inject
    private LivroRepository repository;
    
    @Inject
    private CategoriaRepository categoriaRepository;

    @GET
    public List<LivroResponseDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(livro -> new LivroResponseDTO(livro))
            .collect(Collectors.toList());
    }

    @POST
    @Transactional
    public LivroResponseDTO insert(LivroDTO dto){
        Livro entity = new Livro();
        entity.setNome(dto.getNome());
        entity.setIsbn(dto.getIsbn());
        entity.setAutor(dto.getAutor());
        entity.setEditora(dto.getEditora());
        entity.setIdioma(dto.getIdioma());
        entity.setCategoria(categoriaRepository.findById(dto.getIdCategoria()));

        repository.persist(entity);

        return new LivroResponseDTO(entity);
    }

    @PUT
    @Path("{/id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Livro update(@PathParam("id") Long id, Livro livro){
        Livro entity = repository.findById(id);

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
    @Path("/count")
    public long count() {
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Livro> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}
