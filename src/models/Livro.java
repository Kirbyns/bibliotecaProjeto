package models;

import java.util.Date;

public class Livro {
    private String autor;
    private String titulo;
    private String editora;
    private Date anoPublicacao;
    
     // Construtor
    public Livro(String autor, String titulo, String editora, Date anoPublicacao) {
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
    
    public Date getAnoPublicacao() {
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
    
    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
