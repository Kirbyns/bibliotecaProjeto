/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author thfrod
 */
public class Livro {
    private String autor;
    private String titulo;
    private String editora;
    private String anoPublicacao;
    
     // Construtor
    public Livro(String autor, String titulo, String editora, String anoPublicacao) {
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
    
    public String getAnoPublicacao() {
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
    
    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
