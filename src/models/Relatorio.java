package models;

import java.util.ArrayList;

public class Relatorio {
    Utilitarios utilitarios = new Utilitarios();

    public void gerarRelatorioEmprestimosBiblioteca(Biblioteca biblioteca) {

        if (biblioteca.getEmprestimos().isEmpty()) {
            System.out.println("\nNenhum empréstimo vigente na biblioteca.");
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

        if (usuario.getHistoricoDeEmprestimo().isEmpty()) {
            System.out.println("\nNenhum empréstimo foi realizado pelo " + usuario.getNome() + ".");
            return;
        }

        System.out.println("---------Histórico de Empréstimos-----------");

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

        if (exemplares.isEmpty()) {
            System.out.println("Nenhum Livro Cadastrado");
            return;
        }

        System.out.println("\nTodos os exemplares:");
        for (Exemplar exemplar : exemplares) {
            System.out.println("ID - Exemplar: \n" + exemplar.getId() + " - " + exemplar.getTitulo());
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

        if (livrosEmprestadosIds.isEmpty()) {
            gerarRelatorioTodosOsLivros(exemplares);
            return;
        }

        System.out.println("\nTodos os livros disponíveis:");
        for (Exemplar exemplar : exemplares) {
            if (!livrosEmprestadosIds.contains(exemplar.getId())) {
                System.out.println("\nID - Exemplar: \n" + exemplar.getId() + " - " + exemplar.getTitulo());
                System.out.println("Autor: \n" + exemplar.getAutor());
                System.out.println("Editora: \n" + exemplar.getEditora());
                System.out.println("Lançado: " + utilitarios.maskaraDate(exemplar.getAnoPublicacao()));
                System.out.println("-----------------------------");
            }
        }
    }

    public void listarFuncionarios(Biblioteca biblioteca) {
        if (biblioteca.getFuncionarios().isEmpty()) {
            System.out.println("Nenhum Funcionário Cadastrado");
            return;
        }

        System.out.println("\nFuncionários:");
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            System.out.println("\n" + funcionario.getIdFuncionario() + " - " + funcionario.getNome());
            System.out.println(utilitarios.showCPFString(funcionario.getCpf()));
            System.out.println(funcionario.getCargo());
            System.out.println(funcionario.getSalario());
            System.out.println(utilitarios.maskaraDate(funcionario.getDataDeAdmissao()));
            System.out.println("-----------------------------");
        }
    }

    public void listarUsuarios(Biblioteca biblioteca) {
        if (biblioteca.getUsuarios().isEmpty()) {
            System.out.println("Nenhum Usuário Cadastrado");
            return;
        }

        System.out.println("\nUsuários:");
        for (Usuario usuario : biblioteca.getUsuarios()) {
            System.out.println("\n" + usuario.getMatricula() + " - " + usuario.getNome());

            this.gerarRelatorioEmprestimosUsuario(usuario);
        }
    }
}