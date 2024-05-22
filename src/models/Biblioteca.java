package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;

    // Construtor da classe
    public Biblioteca() {
        this.exemplares = new ArrayList<Exemplar>();
        this.emprestimos = new ArrayList<Emprestimo>();
        this.usuarios = new ArrayList<Usuario>();
        this.funcionarios = new ArrayList<Funcionario>();
    }

    // Método para adicionar um exemplar à biblioteca
    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    // Método para adicionar um emprestimo à biblioteca
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    // Método para adicionar um usuario à biblioteca
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para adicionar um funcionário à biblioteca
    public void adicionarFuncionarios(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para devolver um exemplar
    public void devolverExemplar(Emprestimo emprestimo) {
        this.emprestimos.remove(this.emprestimos.indexOf(emprestimo));

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus("Devolvido");
        System.out.println("\n" + emprestimo.getExemplar().getTitulo() + " foi devolvido com sucesso!\n");
    }

    // Getters
    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}