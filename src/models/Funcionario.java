package models;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    
    private String cargo;
    private double salario;
    private LocalDate dataDeAdmissao;
    
    
    public Funcionario(String cargo, double salario, LocalDate dataDeAdmissao, String nome, int idade, Long cpf) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
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

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    } 
    
}
