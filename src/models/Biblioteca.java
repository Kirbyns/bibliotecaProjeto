package models;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;

    public Biblioteca() {
        this.exemplares = new ArrayList<Exemplar>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.usuarios = new ArrayList<Usuario>();
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
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

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}