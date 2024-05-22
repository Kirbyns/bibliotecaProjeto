import java.time.LocalDate;
import java.util.Scanner;

import models.ActionsAdmin;
import models.ActionsFuncComAcesso;
import models.ActionsFuncSemAcesso;
import models.Biblioteca;
import models.Emprestimo;
import models.Exemplar;
import models.Funcionario;
import models.Relatorio;
import models.Usuario;
import models.Utilitarios;

public class Main {

        // Main
        public static void main(String[] args) {
                // Instanciando Utilitários, Relatorio e Biblioteca
                Utilitarios utilitarios = new Utilitarios();
                Relatorio relatorio = new Relatorio();

                Biblioteca biblioteca = new Biblioteca();

                // Adicionando Funcionários
                Funcionario funcionario1 = new Funcionario("Diretor", 2800.00, LocalDate.now(), "Francisco Pavão", 23,
                                utilitarios.maskaraCPF("012394890-90"), "admin@gmail.com", "1234",
                                utilitarios.generateIdFuncionario(),
                                0);
                Funcionario funcionario2 = new Funcionario("Bibliotecário Diurno", 1300.00, LocalDate.now(),
                                "Ednea Suarez", 65,
                                utilitarios.maskaraCPF("741569852-32"), "bd@gmail.com", "1234",
                                utilitarios.generateIdFuncionario(), 1);
                Funcionario funcionario3 = new Funcionario("Bibliotecário Noturno", 1800.00, LocalDate.now(),
                                "Ângelo Alvares",
                                35, utilitarios.maskaraCPF("569852456-56"), "bn@gmail.com", "1234",
                                utilitarios.generateIdFuncionario(), 1);

                // Adicionando Usuários
                Usuario usuario1 = new Usuario("Victor", 18, utilitarios.maskaraCPF("123.456.789-89"),
                                utilitarios.generateIdUsuario());
                Usuario usuario2 = new Usuario("Lorena", 28, utilitarios.maskaraCPF("263.798.556-92"),
                                utilitarios.generateIdUsuario());

                // Adicionando Exemplares
                Exemplar exemplar1 = new Exemplar("Patrick Newman", "Os 4 patos da Lagoa", "Âncora Alerde",
                                LocalDate.now(),
                                utilitarios.generateIdExemplar());
                Exemplar exemplar2 = new Exemplar("Patrick Newman", "Os 3 patos da Lagoa e a Vingança", "Âncora Alerde",
                                LocalDate.now(),
                                utilitarios.generateIdExemplar());

                // Adicionando Emprestimo
                Emprestimo emprestimo1 = new Emprestimo(utilitarios.generateIdEmprestimo(), LocalDate.now(),
                                "Emprestado",
                                exemplar2, usuario2);

                biblioteca.adicionarFuncionarios(funcionario1);
                biblioteca.adicionarFuncionarios(funcionario2);
                biblioteca.adicionarFuncionarios(funcionario3);

                biblioteca.adicionarUsuario(usuario1);
                biblioteca.adicionarUsuario(usuario2);

                biblioteca.adicionarExemplar(exemplar1);
                biblioteca.adicionarExemplar(exemplar2);

                usuario2.adicionarEmprestimo(emprestimo1);
                biblioteca.adicionarEmprestimo(emprestimo1);

                // Iniciando o programa
                Scanner sc = new Scanner(System.in);

                System.out.println("Bem-vindo!");

                boolean open = true;

                while (open) {
                        System.out.println("\nO que deseja fazer?");
                        System.out.println("0. Encerrar");
                        System.out.println("1. Entrar");
                        int open_response = sc.nextInt();
                        if (open_response == 0) {
                                // Encerrando o programa
                                open = false;
                                break;
                        } else if (open_response == 1) {

                                // Verificando Login
                                System.out.println("Insira seu e-mail:");
                                String email = sc.next();
                                System.out.println("Insira sua senha:");
                                String senha = sc.next();

                                while (!utilitarios.verificarLogin(email, senha, biblioteca)) {
                                        System.out.println("Email ou senha inválidos. Tente novamente.");
                                        System.out.println("Insira seu e-mail:");
                                        email = sc.next();
                                        System.out.println("Insira sua senha:");
                                        senha = sc.next();
                                }

                                int role = utilitarios.getCargoFuncionario(email, senha, biblioteca);

                                System.out.println("\nSeja bem-vindo!");

                                // Iniciando o menu
                                switch (role) {
                                        // Admin com acesso a todo o sistema
                                        case 0:
                                                ActionsAdmin aa = new ActionsAdmin(sc, biblioteca, relatorio,
                                                                utilitarios);
                                                aa.menu();
                                                break;

                                        // Funcionário com acesso limitado ao sistema
                                        case 1:
                                                Funcionario funcionario = utilitarios.findFuncionarioByLogin(email,
                                                                senha,
                                                                biblioteca.getFuncionarios());
                                                ActionsFuncComAcesso afca = new ActionsFuncComAcesso(funcionario, sc,
                                                                biblioteca, relatorio,
                                                                utilitarios);
                                                afca.menu();
                                                break;

                                        // Funcionário com acesso somente a suas informações básicas
                                        case 2:
                                                Funcionario funcionarioSemAcesso = utilitarios.findFuncionarioByLogin(
                                                                email, senha,
                                                                biblioteca.getFuncionarios());
                                                ActionsFuncSemAcesso actionsFuncSemAcesso = new ActionsFuncSemAcesso(
                                                                funcionarioSemAcesso, sc,
                                                                biblioteca, relatorio, utilitarios);
                                                actionsFuncSemAcesso.menu();
                                                break;
                                        default:
                                                System.out.println("\nVocê não tem acesso a este sistema!");
                                                break;
                                }
                        } else {
                                System.out.println("Resposta inválida!");
                        }
                }
                System.out.println("\nAté mais!");
                // Encerrando o programa
                sc.close();
        }
}