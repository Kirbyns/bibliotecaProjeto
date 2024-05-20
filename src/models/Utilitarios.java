package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilitarios {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Long maskaraCPF(String cpf) {
        return Long.valueOf(cpf.replaceAll("[^0-9]", ""));
    }

    public String maskaraDate(LocalDate lt) {
        return lt.format(formatter);
    }

    public LocalDate addDataDevolucao(LocalDate lt) {
        return lt.plusDays(30);
    }
}
