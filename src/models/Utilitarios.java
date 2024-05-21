package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilitarios {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Integer> idUsuario = new ArrayList<>();

    List<Integer> idEmprestimo = new ArrayList<>();

    List<Integer> idExemplar = new ArrayList<>();

    public Long maskaraCPF(String cpf) {
        return Long.valueOf(cpf.replaceAll("[^0-9]", ""));
    }

    public String maskaraDate(LocalDate lt) {
        return lt.format(formatter);
    }

    public LocalDate addDataDevolucao(LocalDate lt) {
        return lt.plusDays(30);
    }

    public int generateIdUsuario() {
        Random random = new Random();
        int newNumber;

        if (idUsuario.size() > 0) {
            // Generate numbers until a unique one is found
            do {
                newNumber = random.nextInt(999);
            } while (idUsuario.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idUsuario.add(newNumber);
        return newNumber;
    }

    public int generateIdEmprestimo() {
        Random random = new Random();
        int newNumber;

        if (idEmprestimo.size() > 0) {// Generate numbers until a unique one is found
            do {
                newNumber = random.nextInt(999);
            } while (idEmprestimo.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idEmprestimo.add(newNumber);

        return newNumber;
    }

    public int generateIdExemplar() {
        Random random = new Random();
        int newNumber;

        if (idExemplar.size() > 0) {// Generate numbers until a unique one is found
            do {
                newNumber = random.nextInt(999);
            } while (idExemplar.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idExemplar.add(newNumber);

        return newNumber;
    }
}
