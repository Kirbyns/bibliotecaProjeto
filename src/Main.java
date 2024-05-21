import java.time.LocalDate;
import java.util.Scanner;

import models.Biblioteca;
import models.Emprestimo;
import models.Exemplar;
import models.Funcionario;
import models.Relatorio;
import models.Usuario;
import models.Utilitarios;

public class Main {
    public static void main(String[] args) {
        Utilitarios utilitarios = new Utilitarios();
        Relatorio relatorio = new Relatorio();

        Biblioteca biblioteca = new Biblioteca();

        Funcionario funcionario1 = new Funcionario("Coordenador", 2800.00, LocalDate.now(), "Francisco Pavão", 23,
                utilitarios.maskaraCPF("012394890-90"));
        Funcionario funcionario2 = new Funcionario("Bibliotecário Diurno", 1300.00, LocalDate.now(), "Ednea Suarez", 65,
                utilitarios.maskaraCPF("741569852-32"));
        Funcionario funcionario3 = new Funcionario("Bibliotecário Noturno", 1800.00, LocalDate.now(), "Ângelo Alvares",
                35, utilitarios.maskaraCPF("569852456-56"));

        Usuario usuario1 = new Usuario("Victor", 18, utilitarios.maskaraCPF("123.456.789-89"),
                utilitarios.generateIdUsuario());
        Usuario usuario2 = new Usuario("Lorena", 28, utilitarios.maskaraCPF("263.798.556-92"),
                utilitarios.generateIdUsuario());

        Exemplar exemplar1 = new Exemplar("Patrick Newman", "Os 4 patos da Lagoa", "Âncora Alerde", LocalDate.now(),
                utilitarios.generateIdExemplar());
        Exemplar exemplar2 = new Exemplar("Patrick Newman", "Os 3 patos da Lagoa e a Vingança", "Âncora Alerde",
                LocalDate.now(),
                utilitarios.generateIdExemplar());

        Emprestimo emprestimo1 = new Emprestimo(utilitarios.generateIdEmprestimo(), LocalDate.now(), "Emprestado",
                exemplar2, usuario2);

        biblioteca.adicionarFuncionarios(funcionario1);
        biblioteca.adicionarFuncionarios(funcionario2);
        biblioteca.adicionarFuncionarios(funcionario3);

        biblioteca.adicionarUsuario(usuario1);
        biblioteca.adicionarUsuario(usuario2);

        biblioteca.adicionarExemplar(exemplar1);
        biblioteca.adicionarExemplar(exemplar2);

        biblioteca.adicionarEmprestimo(emprestimo1);

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            int response;

            System.out.println("\nSeja bem-vindo! O que deseja?");
            System.out.println("0. Encerrar");
            System.out.println("1. Adicionar Exemplar");
            System.out.println("2. Fazer Empréstimo");
            System.out.println("3. Criar Usuário");
            System.out.println("4. Criar Funcionário");
            System.out.println("5. Devolver Exemplar");
            System.out.println("6. Listar Funcionários");
            System.out.println("7. Listar Usuários");
            System.out.println("8. Listar todos os Exemplares");
            System.out.println("9. Listar os Exemplares que podem ser Emprestados");
            System.out.println("10. Listar os Exemplares Emprestados");

            response = sc.nextInt();

            switch (response) {
                case 0:
                    run = false;
                    break;
                case 1:
                    break;
                case 6:
                    relatorio.listarFuncionarios(biblioteca);
                    break;
                case 3:
                    break;
                case 7:
                    relatorio.listarUsuarios(biblioteca);
                    break;
                case 8:
                    relatorio.gerarRelatorioTodosOsLivros(biblioteca.getExemplares());
                    break;
                case 9:
                    relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                            biblioteca.getEmprestimos());
                    break;
                case 10:
                    relatorio.gerarRelatorioEmprestimosBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }

        sc.close();
    }
}