package models;

import java.util.Scanner;

public class ActionsFuncSemAcesso extends Action {

    Funcionario funcionario;

    // Construtor da classe
    public ActionsFuncSemAcesso(Funcionario funcionario, Scanner sc, Biblioteca biblioteca, Relatorio relatorio,
            Utilitarios utilitarios) {
        super(sc, biblioteca, relatorio, utilitarios);
        this.funcionario = funcionario;
    }

    // Polimorfismo para o método menu, criando o menu para o Funcionario com acesso
    // apenas às suas informações básicas
    @Override
    public void menu() {
        boolean run = true;
        while (run) {
            int response;

            System.out.println("\nO que deseja?");
            System.out.println("0. Encerrar");
            System.out.println("1. Tela do Funcionário");

            try {

                response = sc.nextInt();

                // Verificando a resposta
                switch (response) {

                    // Retorna para o login
                    case 0:
                        run = false;
                        break;

                    // Abre o menu do(a) funcionário(a) com acesso limitado
                    case 1:
                        try {

                            if (funcionario == null) {
                                System.out.println("Funcionário inexistente");
                                break;
                            }

                            // Abre o menu do(a) funcionário(a) com acesso limitado
                            editing_funcByFunc(funcionario, sc);

                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao editar o funcionário!");
                            System.out.println("Erro: " + e);
                        }
                    default:
                        System.out.println("\nResposta inválida!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Resposta inválida!");
                System.out.println("Erro: " + e);
                sc.nextLine();
            }
        }
    }

}
