package models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Exemplar> exemplares;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.exemplares = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void emprestarExemplar(Usuario usuario, Exemplar exemplar) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setExemplar(exemplar);
        emprestimo.setDataInicio(new Date());
        emprestimo.setStatus("Emprestado");
        emprestimos.add(emprestimo);

        usuario.getHistoricoEmprestimos().add(emprestimo);
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}