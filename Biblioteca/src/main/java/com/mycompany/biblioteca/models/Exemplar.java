/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author thfrod
 */
public class Exemplar extends Livro {
    private int id;

    // Construtor
    public Exemplar(String autor, String titulo, String editora, String anoPublicacao, int id) {
        super(autor, titulo, editora, anoPublicacao);
        this.id = id;
    }

    // Getter para o id
    public int getId() {
        return id;
    }

    // Setter para o id
    public void setId(int id) {
        this.id = id;
    }
}
