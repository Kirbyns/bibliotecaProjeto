package models;

import java.util.Scanner;

public class ActionsFuncSemAcesso extends Action {

    Funcionario funcionario;

    public ActionsFuncSemAcesso(Funcionario funcionario, Scanner sc, Biblioteca biblioteca, Relatorio relatorio,
            Utilitarios utilitarios) {
        super(sc, biblioteca, relatorio, utilitarios);
        this.funcionario = funcionario;
    }

    @Override
    public void menu() {
        boolean run = true;
        while (run) {
            int response;

            System.out.println("\nO que deseja?");
            System.out.println("0. Encerrar");
            System.out.println("1. Tela do Funcionário");

            response = sc.nextInt();

            // Verificando a resposta
            switch (response) {
                case 0:
                    run = false;
                    break;
                case 1:
                    try {

                        if (funcionario == null) {
                            System.out.println("Funcionário inexistente");
                            break;
                        }

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
        }
    }

}
