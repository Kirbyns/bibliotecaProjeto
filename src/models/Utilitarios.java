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

    // Método para verificar login
    public boolean verificarLogin(String email, String senha, Biblioteca biblioteca) {
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar role do Funcionário
    public int getCargoFuncionario(String email, String senha, Biblioteca biblioteca) {
        for (Funcionario funcionario : biblioteca.getFuncionarios()) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return funcionario.getRole();
            }
        }
        return 3;
    }

    // Método para encontrar um Funcionário pelo login
    public Funcionario findFuncionarioByLogin(String email, String senha, ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
    }

    // Método para transformar o CPF em Long
    public Long maskaraCPF(String cpf) {
        return Long.valueOf(cpf.replaceAll("[^0-9]", ""));
    }

    // Método para verificar se o CPF tem 11 digitos e se o CPF existe
    public boolean verficarCPF(Long cpf, Biblioteca biblioteca) {

        String cpf_string = Long.toString(cpf);
        if (cpf_string.length() == 11) {

            for (Funcionario funcionario : biblioteca.getFuncionarios()) {
                if (funcionario.getCpf().equals(cpf)) {
                    return false;
                }
            }

            for (Usuario usuario : biblioteca.getUsuarios()) {
                if (usuario.getCpf().equals(cpf)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    // Método para mostrar o CPF em formato de String
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

    // Método para mostrar a data em formato de String
    public String maskaraDate(LocalDate lt) {
        return lt.format(formatter);
    }

    // Método para gerar um novo ID de Funcionário
    public int generateIdFuncionario() {
        Random random = new Random();
        int newNumber;

        if (idFuncionario.size() > 0) {
            do {
                newNumber = random.nextInt(999);
            } while (idFuncionario.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idFuncionario.add(newNumber);
        return newNumber;
    }

    // Método para gerar um novo ID de Usuário
    public int generateIdUsuario() {
        Random random = new Random();
        int newNumber;

        if (idUsuario.size() > 0) {
            do {
                newNumber = random.nextInt(999);
            } while (idUsuario.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idUsuario.add(newNumber);
        return newNumber;
    }

    // Método para gerar um novo ID de Empréstimo
    public int generateIdEmprestimo() {
        Random random = new Random();
        int newNumber;

        if (idEmprestimo.size() > 0) {
            do {
                newNumber = random.nextInt(999);
            } while (idEmprestimo.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idEmprestimo.add(newNumber);

        return newNumber;
    }

    // Método para gerar um novo ID de Exemplar
    public int generateIdExemplar() {
        Random random = new Random();
        int newNumber;

        if (idExemplar.size() > 0) {
            do {
                newNumber = random.nextInt(999);
            } while (idExemplar.contains(newNumber));
        } else {
            newNumber = random.nextInt(999);
        }

        idExemplar.add(newNumber);

        return newNumber;
    }

    // Método para encontrar um Empréstimo pelo ID
    public Emprestimo findEmprestimoById(int id, ArrayList<Emprestimo> emprestimos) {
        for (Emprestimo emprestimo : emprestimos) {
            if (id == emprestimo.getId()) {
                return emprestimo;
            }
        }
        return null;
    }

    // Método para encontrar um Exemplar pelo ID
    public Exemplar findExemplarById(int id, ArrayList<Exemplar> exemplares) {
        for (Exemplar exemplar : exemplares) {
            if (id == exemplar.getId()) {
                return exemplar;
            }
        }
        return null;
    }

    // Método para encontrar um Funcionário pelo ID
    public Funcionario findFuncionarioById(int id, ArrayList<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (id == funcionario.getIdFuncionario()) {
                return funcionario;
            }
        }
        return null;
    }

    // Método para encontrar um Usuário pelo ID
    public Usuario findUsuarioById(int id, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (id == usuario.getMatricula()) {
                return usuario;
            }
        }
        return null;
    }

    // Método para verificar se um Exemplar está emprestado
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
