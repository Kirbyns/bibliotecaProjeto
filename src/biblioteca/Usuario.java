/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

import java.util.ArrayList;

/**
 *
 * @author moasa
 */
public class Usuario extends Pessoa {
    
    private int matricula;
    private ArrayList<Emprestimo> historicoDeEmprestimo;
    
    public Usuario(String nome, int idade, int cpf, int matricula) {
        super(nome, idade, cpf);
         this.matricula = matricula;
         this.historicoDeEmprestimo = new ArrayList<>(); 
    }
    //metodo de adicionar emprestimo ao historico do usuario
    public void adicionarEmprestimo(Emprestimo emprestimo){ //criei a class Emprestimo apenas para parar de dar erro no codigo.  mas o primeiro "Emprestimo" faz menção a Class para puxar ela.
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
