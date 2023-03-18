package org.acme.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LivroDTO {

    @NotBlank(message = "Informe o nome do livro!")
    private String nome;
    @NotNull(message = "Informe o isbn!")
    private int isbn;
    @NotBlank(message = "Informe o nome do autor!")
    private String autor;
    @NotBlank(message = "Informe o nome da editora!")
    private String editora;
    @NotBlank(message = "Informe o idioma do livro!")
    private String idioma;
    @NotNull(message = "Informe o id da categoria!")
    private Long idCategoria;

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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

}
