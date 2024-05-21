package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilitarios {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    List<Integer> idUsuario = new ArrayList<>();

    List<Integer> idFuncionario = new ArrayList<>();

    List<Integer> idEmprestimo = new ArrayList<>();

    List<Integer> idExemplar = new ArrayList<>();

    public boolean verificarLogin(String email, String senha, Biblioteca biblioteca) {
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public int getCargoFuncionario(String email, String senha, Biblioteca biblioteca) {
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return funcionario.getRole();
            }
        }
        return 3;
    }

    public Funcionario findFuncionarioByLogin(String email, String senha, ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
    }

    public Long maskaraCPF(String cpf) {
        return Long.valueOf(cpf.replaceAll("[^0-9]", ""));
    }

    public String showCPFString(Long cpf) {

        String cpf_string = Long.toString(cpf);

        String show_cpf = null;

        for (int i = 0; i < cpf_string.length(); i++) {

            char cpf_char = cpf_string.charAt(i);

            if (i == 0) {
                show_cpf = "";
            }

            if (i == 3 || i == 6) {
                show_cpf = show_cpf + "." + cpf_char;

            } else if (i == 9) {
                show_cpf = show_cpf + "-" + cpf_char;
            } else {
                show_cpf = show_cpf + cpf_char;
            }
        }

        return show_cpf;
    }

    public String maskaraDate(LocalDate lt) {
        return lt.format(formatter);
    }

    public LocalDate addDataDevolucao(LocalDate lt) {
        return lt.plusDays(30);
    }

    public int generateIdFuncionario() {
        Random random = new Random();
        int newNumber;

        if (idFuncionario.size() > 0) {
            // Generate numbers until a unique one is found
            do {
                newNumber = random.nextInt(999);
            } while (idFuncionario.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idFuncionario.add(newNumber);
        return newNumber;
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

    public Emprestimo findEmprestimoById(int id, ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            if (id == emprestimo.getId()) {
                return emprestimo;
            }
        }
        return null;
    }

    public Exemplar findExemplarById(int id, ArrayList<Exemplar> exemplares) {
        for (Exemplar exemplar : exemplares) {
            if (id == exemplar.getId()) {
                return exemplar;
            }
        }
        return null;
    }

    public Funcionario findFuncionarioById(int id, ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (id == funcionario.getIdFuncionario()) {
                return funcionario;
            }
        }
        return null;
    }

    public Usuario findUsuarioById(int id, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (id == usuario.getMatricula()) {
                return usuario;
            }
        }
        return null;
    }

    public boolean verificarEmprestimo(int idExemplar, ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            if (idExemplar == emprestimo.getExemplar().getId()) {
                if (emprestimo.getStatus().equals("Emprestado")) {
                    return true;
                }
            }
        }
        return false;
    }
}
