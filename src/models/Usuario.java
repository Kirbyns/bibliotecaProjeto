package models;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    
    private int matricula;
    private ArrayList<Emprestimo> historicoDeEmprestimo;
    
    public Usuario(String nome, int idade, Long cpf, int matricula) {
         super(nome, idade, cpf);
         this.matricula = matricula;
         this.historicoDeEmprestimo = new ArrayList<Emprestimo>();
    }

    //metodo de adicionar emprestimo ao historico do usuario
    public void adicionarEmprestimo(Emprestimo emprestimo){
        historicoDeEmprestimo.add(emprestimo); 
    }
    
    //metodo para obter historio de emprestimos do usuario
    public ArrayList<Emprestimo> getHistoricoDeEmprestimo(){
        return historicoDeEmprestimo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
