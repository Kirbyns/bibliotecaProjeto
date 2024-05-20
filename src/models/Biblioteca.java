package models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.exemplares = new ArrayList<Exemplar>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void emprestarExemplar(Usuario usuario, Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);

        usuario.adicionarEmprestimo(emprestimo);
    }

    public void devolverExemplar(Emprestimo emprestimo) {
        emprestimo.setStatus("Devolvido");
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}