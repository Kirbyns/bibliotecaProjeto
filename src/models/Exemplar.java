package models;

import java.time.LocalDate;

public class Exemplar extends Livro {
    private final int id;

    // Construtor
    public Exemplar(String autor, String titulo, String editora, LocalDate anoPublicacao, int id) {
        super(autor, titulo, editora, anoPublicacao);
        this.id = id;
    }

    // Getter para o id
    public int getId() {
        return id;
    }
}
