package models;

import java.util.ArrayList;

public class Usuario extends Pessoa {

    private final int matricula;
    private ArrayList<Emprestimo> historicoDeEmprestimo;

    // Construtor da classe
    public Usuario(String nome, int idade, Long cpf, int matricula) {
        super(nome, idade, cpf);
        this.matricula = matricula;
        this.historicoDeEmprestimo = new ArrayList<Emprestimo>();
    }

    // Método para adicionar empréstimo ao histórico do Usuário
    public void adicionarEmprestimo(Emprestimo emprestimo) {
        historicoDeEmprestimo.add(emprestimo);
    }

    // Getter para o historico de empréstimos
    public ArrayList<Emprestimo> getHistoricoDeEmprestimo() {
        return historicoDeEmprestimo;
    }

    // Getter para a matricula
    public int getMatricula() {
        return matricula;
    }
}
