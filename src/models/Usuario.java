package models;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    
    private Long matricula;
    private ArrayList<Emprestimo> historicoDeEmprestimo;
    
    public Usuario(String nome, int idade, Long cpf, Long matricula) {
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

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

}
