/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Date;

/**
 *
 * @author thfrod
 */
public class Exemplar extends Livro {
    private final int id;

    // Construtor
    public Exemplar(String autor, String titulo, String editora, Date anoPublicacao, int id) {
        super(autor, titulo, editora, anoPublicacao);
        this.id = id;
    }

    // Getter para o id
    public int getId() {
        return id;
    }
}
