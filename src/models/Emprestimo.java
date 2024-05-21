package models;

import java.time.LocalDate;

public class Emprestimo {
    private final int id;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private String status;
    private Exemplar exemplar;
    private Usuario usuario;

    // Construtor
    public Emprestimo(int id, LocalDate dataRetirada, String status, Exemplar exemplar, Usuario usuario) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataRetirada.plusDays(30);
        this.status = status;
        this.exemplar = exemplar;
        this.usuario = usuario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
