package org.acme.dto;

import java.util.HashMap;
import java.util.Map;

import org.acme.model.Livro;

public class LivroResponseDTO {

    private Integer id;
    private String nome;
    private int isbn;
    private String autor;
    private String editora;
    private String idioma;
    private Map<String, Object> categoria;

    public LivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor();
        this.editora = livro.getEditora();
        this.idioma = livro.getIdioma();
        this.categoria = new HashMap<String, Object>();
        this.categoria.put("nome", livro.getCategoria().getNome());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Map<String, Object> getCategoria() {
        return categoria;
    }

    public void setCategoria(Map<String, Object> categoria) {
        this.categoria = categoria;
    }

}
