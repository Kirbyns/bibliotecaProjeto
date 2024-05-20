package biblioteca;

import java.util.List;

public class Relatorio {
    public void gerarRelatorioEmprestimos(List<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Exemplar ID: " + emprestimo.getExemplar().getId());
            System.out.println
            "Data de Início: " + emprestimo.getDataInicio());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
            System.out.println("Status: " + emprestimo.getStatus());
            System.out.println("-----------------------------");
        }
    }

    public void gerarRelatorioLivrosDisponiveis(List<Exemplar> exemplares) {
        for (Exemplar exemplar : exemplares) {
            System.out.println("Exemplar ID: " + exemplar.getId());
            System.out.println("Título: " + exemplar.getLivro().getTitulo());
            System.out.println("Autor: " + exemplar.getLivro().getAutor());
            System.out.println("-----------------------------");
        }
    }
}