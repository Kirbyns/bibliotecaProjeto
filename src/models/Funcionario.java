package models;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private final int idFuncionario;
    private String cargo;
    private double salario;
    private LocalDate dataDeAdmissao;
    private String email;
    private String senha;
    // 0 = Admin | 1 = Funcionário com acesso ao sistema | 2 = Funcionário sem
    // acesso ao sistema
    private int role;

    public Funcionario(String cargo, double salario, LocalDate dataDeAdmissao, String nome, int idade, Long cpf,
            String email, String senha, int idFuncionario, int role) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.dataDeAdmissao = dataDeAdmissao;
        this.email = email;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
        this.role = role;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
