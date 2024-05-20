package models;

import java.util.List;
import java.util.ArrayList;

public class Relatorio {
    Utilitarios utilitarios = new Utilitarios();

    public void gerarRelatorioEmprestimosBiblioteca(Biblioteca biblioteca) {
        System.out.println("\nTodos os empréstimos da biblioteca:");

        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            System.out.println("\nEmprestimo " + emprestimo.getId() + ":");
            System.out.println("Id - Exemplar: \n" + emprestimo.getExemplar().getId() + emprestimo.getExemplar().getTitulo());
            System.out.println("Emprestado à: \n" + emprestimo.getUsuario().getNome());
            System.out.println(
            "Data de Início: " + emprestimo.getDataRetirada());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucao());
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("-----------------------------\n");
        }
    }

    public void gerarRelatorioEmprestimosUsuario(Usuario usuario) {
        System.out.println("\nTodos os empréstimos do" + usuario.getNome() + ":");

        for (Emprestimo emprestimo : usuario.getHistoricoDeEmprestimo()) {
            System.out.println("Emprestimo " + emprestimo.getId() + ":");
            System.out.println("Id - Exemplar: \n" + emprestimo.getExemplar().getId() + emprestimo.getExemplar().getTitulo());
            System.out.println(
                    "Data de Início: " + emprestimo.getDataRetirada());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucao());
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("-----------------------------");
        }
    }

    public void gerarRelatorioTodosOsLivros(ArrayList<Exemplar> exemplares) {
        System.out.println("\nTodos os exemplares:");
        for (Exemplar exemplar : exemplares) {
            System.out.println("Exemplar - ID: " + exemplar.getId() + " - " + exemplar.getTitulo());
            System.out.println("Autor: " + exemplar.getAutor());
            System.out.println("Editora: " + exemplar.getEditora());
            System.out.println("Lançado: " + exemplar.getAnoPublicacao());
            System.out.println("-----------------------------");
        }
    }

    public void gerarRelatorioLivrosNaoEmprestados(ArrayList<Exemplar> exemplares, ArrayList<Emprestimo> emprestimos) {

        ArrayList<Integer> livrosEmprestadosIds = new ArrayList<Integer>();
        for (Emprestimo emprestimo : emprestimos) {
            livrosEmprestadosIds.add(emprestimo.getExemplar().getId());
        }

        System.out.println("\nTodos os livros disponíveis:");
        for (Exemplar exemplar : exemplares) {
            if (!livrosEmprestadosIds.contains(exemplar.getId())) {
                System.out.println("Exemplar - ID: " + exemplar.getId() + " - " + exemplar.getTitulo());
                System.out.println("Autor: " + exemplar.getAutor());
                System.out.println("Editora: " + exemplar.getEditora());
                System.out.println("Lançado: " + exemplar.getAnoPublicacao());
                System.out.println("-----------------------------");
            }
        }
    }

    public void listarFuncionarios(Biblioteca biblioteca){
        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getSalario());
            System.out.println(utilitarios.maskaraDate(funcionario.getDataDeAdmissao()));
            System.out.println("-----------------------------");
        }
    }

    public void listarUsuarios(Biblioteca biblioteca){
        System.out.println("\nUsuários:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            System.out.println(usuario.getNome());
            System.out.println(usuario.getMatricula());
            for(Emprestimo emprestimo : usuario.getHistoricoDeEmprestimo()) {
                System.out.println(emprestimo.getId() + " - " + emprestimo.getExemplar().getTitulo());
                System.out.println(emprestimo.getDataRetirada() + " - " + emprestimo.getDataDevolucao() + " -> " + emprestimo.getStatus());
            }
        }
    }
}