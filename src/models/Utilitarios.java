package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Utilitarios {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Long> idUsuario;

    List<Long> idEmprestimo;

    List<Long> idExemplar;


    public Long maskaraCPF(String cpf) {
        return Long.valueOf(cpf.replaceAll("[^0-9]", ""));
    }

    public String maskaraDate(LocalDate lt) {
        return lt.format(formatter);
    }

    public LocalDate addDataDevolucao(LocalDate lt) {
        return lt.plusDays(30);
    }

    public Long generateIdUsuario(){
        Random random = new Random();
        long newNumber;

        // Generate numbers until a unique one is found
        do {
            newNumber = random.nextLong();
        } while (idUsuario.contains(newNumber));

        return newNumber;
    }

    public Long generateIdEmprestimo(){
        Random random = new Random();
        long newNumber;

        // Generate numbers until a unique one is found
        do {
            newNumber = random.nextLong();
        } while (idEmprestimo.contains(newNumber));

        return newNumber;
    }

    public Long generateIdExemplar(){
        Random random = new Random();
        long newNumber;

        // Generate numbers until a unique one is found
        do {
            newNumber = random.nextLong();
        } while (idExemplar.contains(newNumber));

        return newNumber;
    }
}
