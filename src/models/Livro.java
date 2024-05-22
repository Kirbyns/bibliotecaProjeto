package models;

import java.time.LocalDate;

public class Livro {
    private String autor;
    private String titulo;
    private String editora;
    private LocalDate anoPublicacao;

    // Construtor da classe
    public Livro(String autor, String titulo, String editora, LocalDate anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    // Getters
    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    // Setters
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
