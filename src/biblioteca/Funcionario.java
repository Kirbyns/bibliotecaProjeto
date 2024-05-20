/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

import java.util.Date;

/**
 *
 * @author moasa
 */
public class Funcionario extends Pessoa {
    
    private String cargo;
    private Double salario;
    private Date data; //criei a date para puxar a data atual, caso o usuario seja criado na "data de admissão" basta jogar a date nele. 
    private Double dataDeAdmissao;
    
    
    public Funcionario(String cargo, Double salario, Date data, Double dataDeAdmissao, String nome, int idade, int cpf) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.data = data;
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Double dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    } 
    
}
