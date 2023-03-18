package org.acme.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import org.acme.dto.LivroDTO;
import org.acme.dto.LivroResponseDTO;
import org.acme.model.Livro;
import org.acme.repository.CategoriaRepository;
import org.acme.repository.LivroRepository;

@ApplicationScoped
public class LivroServiceImpl implements LivroService {

    @Inject
    LivroRepository livroRepository;

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    Validator validator;

    @Override
    public LivroResponseDTO findById(Long id) {
        Livro livro = livroRepository.findById(id);
        if (livro == null)
            throw new NotFoundException("O livro não foi encontrado!");
        return new LivroResponseDTO(livro);
    }

    @Override
    @Transactional
    public LivroResponseDTO create(LivroDTO livroDTO){
        Set<ConstraintViolation<LivroDTO>> violations = validator.validate(livroDTO);
        if(!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Livro entity = new Livro();
        entity.setNome(livroDTO.getNome());
        entity.setIsbn(livroDTO.getIsbn());
        entity.setIdioma(livroDTO.getIdioma());
        entity.setEditora(livroDTO.getEditora());
        entity.setAutor(livroDTO.getAutor());
        entity.setCategoria(categoriaRepository.findById(livroDTO.getIdCategoria()));
        livroRepository.persist(entity);

        return new LivroResponseDTO(entity);
    }

    @Override
    @Transactional
    public LivroResponseDTO update(Long id, LivroDTO livroDTO) {
        Livro entity = livroRepository.findById(id);

        entity.setNome(livroDTO.getNome());
        entity.setIsbn(livroDTO.getIsbn());
        entity.setIdioma(livroDTO.getIdioma());
        entity.setEditora(livroDTO.getEditora());
        entity.setAutor(livroDTO.getAutor());
        entity.setCategoria(categoriaRepository.findById(livroDTO.getIdCategoria()));

        return new LivroResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id){
        livroRepository.deleteById(id);
    }

    @Override
    public List<LivroResponseDTO> findByNome(String nome){
        List<Livro> list = livroRepository.findByNome(nome);
        return list.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return livroRepository.count();
    }

    @Override
    public List<LivroResponseDTO> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}