package models;

import java.util.ArrayList;

public class Relatorio {
    Utilitarios utilitarios = new Utilitarios();

    public void gerarRelatorioEmprestimosBiblioteca(Biblioteca biblioteca) {

        if (biblioteca.getEmprestimos().isEmpty()) {
            System.out.println("\nNenhum empréstimo foi realizado na biblioteca.");
            return;
        }
        System.out.println("\nTodos os empréstimos da biblioteca:");

        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            System.out.println("\nEmprestimo " + emprestimo.getId() + ":");
            System.out.println(
                    "Id - Exemplar: \n" + emprestimo.getExemplar().getId() + " - "
                            + emprestimo.getExemplar().getTitulo());
            System.out.println("Emprestado à: " + emprestimo.getUsuario().getNome() + " - "
                    + emprestimo.getUsuario().getMatricula());
            System.out.println(
                    "Data de Início: " + utilitarios.maskaraDate(emprestimo.getDataRetirada()));
            System.out.println(
                    "Data de Devolução Prevista: " + utilitarios.maskaraDate(emprestimo.getDataDevolucaoPrevista()));
            if (emprestimo.getDataDevolucao() != null) {
                System.out.println("Data de Devolução: " + utilitarios.maskaraDate(emprestimo.getDataDevolucao()));
            }
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("-----------------------------\n");
        }
    }

    public void gerarRelatorioEmprestimosUsuario(Usuario usuario) {
        System.out.println("\nTodos os empréstimos do" + usuario.getNome() + ":");

        for (Emprestimo emprestimo : usuario.getHistoricoDeEmprestimo()) {
            System.out.println("Emprestimo " + emprestimo.getId() + ":");
            System.out.println(
                    "Id - Exemplar: \n" + emprestimo.getExemplar().getId() + " - "
                            + emprestimo.getExemplar().getTitulo());
            System.out.println(
                    "Data de Início: " + utilitarios.maskaraDate(emprestimo.getDataRetirada()));
            System.out.println(
                    "Data de Devolução Prevista: " + utilitarios.maskaraDate(emprestimo.getDataDevolucaoPrevista()));
            if (emprestimo.getDataDevolucao() != null) {
                System.out.println("Data de Devolução: " + utilitarios.maskaraDate(emprestimo.getDataDevolucao()));
            }
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("-----------------------------");
        }
    }

    public void gerarRelatorioTodosOsLivros(ArrayList<Exemplar> exemplares) {
        System.out.println("\nTodos os exemplares:");
        for (Exemplar exemplar : exemplares) {
            System.out.println("Exemplar - ID: \n" + exemplar.getId() + " - " + exemplar.getTitulo());
            System.out.println("Autor: " + exemplar.getAutor());
            System.out.println("Editora: " + exemplar.getEditora());
            System.out.println("Lançado: " + utilitarios.maskaraDate(exemplar.getAnoPublicacao()));
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
                System.out.println("Exemplar - ID: \n" + exemplar.getId() + " - " + exemplar.getTitulo());
                System.out.println("Autor: \n" + exemplar.getAutor());
                System.out.println("Editora: \n" + exemplar.getEditora());
                System.out.println("Lançado: " + utilitarios.maskaraDate(exemplar.getAnoPublicacao()));
                System.out.println("-----------------------------");
            }
        }
    }

    public void listarFuncionarios(Biblioteca biblioteca) {
        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getSalario());
            System.out.println(utilitarios.maskaraDate(funcionario.getDataDeAdmissao()));
            System.out.println("-----------------------------");
        }
    }

    public void listarUsuarios(Biblioteca biblioteca) {
        System.out.println("\nUsuários:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            System.out.println(usuario.getMatricula() + " - " + usuario.getNome());
            System.out.println("---------Histórico de Empréstimos-----------");
            for (Emprestimo emprestimo : usuario.getHistoricoDeEmprestimo()) {
                System.out.println(emprestimo.getId() + " - " + emprestimo.getExemplar().getTitulo());
                System.out.println(utilitarios.maskaraDate(emprestimo.getDataRetirada()) + " - "
                        + utilitarios.maskaraDate(emprestimo.getDataDevolucaoPrevista()) + " -> "
                        + emprestimo.getStatus());
                if (emprestimo.getDataDevolucao() != null) {
                    System.out.println(
                            emprestimo.getStatus() + " - " + utilitarios.maskaraDate(emprestimo.getDataDevolucao()));

                }
                System.out.println("-----------------------------");
            }
        }
    }
}