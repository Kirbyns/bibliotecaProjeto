package biblioteca;

import java.util.Date;

public class Funcionario extends Pessoa {
    
    private String cargo;
    private double salario;
    private Date dataDeAdmissao;
    
    
    public Funcionario(String cargo, double salario, Date dataDeAdmissao, String nome, int idade, int cpf) {
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

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    } 
    
}
