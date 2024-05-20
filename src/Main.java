import models.Biblioteca;
import models.Funcionario;
import models.Relatorio;
import models.Utilitarios;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utilitarios utilitarios = new Utilitarios();
        Relatorio relatorio = new Relatorio();

        Biblioteca biblioteca = new Biblioteca();

        Funcionario funcionario1 = new Funcionario("Coordenador", 2800.00, LocalDate.now(), "Francisco Pavão", 23,  utilitarios.maskaraCPF("012394890-90"));
        Funcionario funcionario2 = new Funcionario("Bibliotecário Diurno", 1300.00, LocalDate.now(), "Ednea Suarez", 65,  utilitarios.maskaraCPF("741569852-32"));
        Funcionario funcionario3 = new Funcionario("Bibliotecário Noturno", 1800.00, LocalDate.now(), "Ângelo Alvares", 35,  utilitarios.maskaraCPF("569852456-56"));

        biblioteca.adicionarFuncionarios(funcionario1);
        biblioteca.adicionarFuncionarios(funcionario2);
        biblioteca.adicionarFuncionarios(funcionario3);

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            int response;

            System.out.println("Seja bem-vindo! O que deseja?");
            System.out.println("0. Encerrar");
            System.out.println("1. Criar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Criar Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Adicionar Exemplar");
            System.out.println("6. Listar todos os Exemplares");
            System.out.println("7. Listar os Exemplares que podem ser Emprestados");

            response = sc.nextInt();

            switch (response){
                case 0:
                    run = false;
                    break;
                case 1:
                    break;
                case 2:
                    relatorio.listarFuncionarios(biblioteca);
                    break;
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }

        sc.close();
    }
}