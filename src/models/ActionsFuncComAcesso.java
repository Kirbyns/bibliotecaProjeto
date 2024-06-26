package models;

import java.time.LocalDate;
import java.util.Scanner;

public class ActionsFuncComAcesso extends Action {

    Funcionario funcionario;

    // Construtor da classe
    public ActionsFuncComAcesso(Funcionario funcionario, Scanner sc, Biblioteca biblioteca, Relatorio relatorio,
            Utilitarios utilitarios) {
        super(sc, biblioteca, relatorio, utilitarios);
        this.funcionario = funcionario;
    }

    // Polimorfismo para o método menu, criando o menu para o funcionário com
    // acesso limitado ao sistema
    @Override
    public void menu() {
        boolean run = true;
        while (run) {
            int response;

            // Criando o menu
            System.out.println("\nO que deseja?");
            System.out.println("0. Encerrar");
            System.out.println("1. Adicionar Exemplar");
            System.out.println("2. Fazer Empréstimo");
            System.out.println("3. Criar Usuário");
            System.out.println("4. Devolver Exemplar");
            System.out.println("5. Listar Usuários");
            System.out.println("6. Listar todos os Exemplares");
            System.out.println("7. Listar os Exemplares que podem ser Emprestados");
            System.out.println("8. Listar os Exemplares Emprestados");
            System.out.println("9. Tela do Funcionário");
            System.out.println("10. Tela de Usuários");

            try {

                response = sc.nextInt();

                // Verificando a resposta
                switch (response) {

                    // Retorna para o login
                    case 0:
                        run = false;
                        break;

                    // Adiciona um novo exemplar
                    case 1:
                        try {
                            System.out.println("\nInsira os dados do novo exemplar:");

                            System.out.println("Autor:");
                            sc.nextLine();
                            String autor = sc.nextLine();
                            System.out.println("Título:");
                            String titulo = sc.nextLine();
                            System.out.println("Editora:");
                            String editora = sc.nextLine();
                            System.out.println("Ano de Publicação:");
                            int ano_publicacao = sc.nextInt();
                            System.out.println("Mês de Publicação:");
                            int mes_publicacao = sc.nextInt();
                            System.out.println("Dia de Publicação:");
                            int dia_publicacao = sc.nextInt();

                            Exemplar new_exemplar = new Exemplar(autor, titulo, editora,
                                    LocalDate.of(ano_publicacao, mes_publicacao, dia_publicacao),
                                    utilitarios.generateIdExemplar());

                            biblioteca.adicionarExemplar(new_exemplar);

                            System.out.println("\nExemplar " + new_exemplar.getId() + " - " + new_exemplar.getTitulo()
                                    + " adicionado com sucesso!");

                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar exemplar");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
                        }

                        // Cria um novo empréstimo
                    case 2:
                        try {
                            relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                                    biblioteca.getEmprestimos());
                            relatorio.listarUsuarios(biblioteca);

                            System.out.println("\nInsira os dados do novo empréstimo:");
                            System.out.println("Id do Exemplar:");
                            int id_exemplar = sc.nextInt();
                            System.out.println("Id do Usuário:");
                            int id_user = sc.nextInt();
                            LocalDate data_emprestimo = LocalDate.now();
                            String status_emprestimo = "Emprestado";

                            Usuario user_emprestando = utilitarios.findUsuarioById(id_user, biblioteca.getUsuarios());

                            Exemplar exemplar_emprestando = utilitarios.findExemplarById(id_exemplar,
                                    biblioteca.getExemplares());

                            if (user_emprestando == null) {
                                System.out.println("Usuário inexistente!");
                                break;
                            }
                            if (exemplar_emprestando == null) {
                                System.out.println("Exemplar inexistente!");
                                break;
                            }
                            if (utilitarios.verificarEmprestimo(id_exemplar, biblioteca.getEmprestimos())) {
                                System.out.println("Exemplar indisponível!");
                                break;
                            }

                            Emprestimo new_emprestimo = new Emprestimo(utilitarios.generateIdEmprestimo(),
                                    data_emprestimo,
                                    status_emprestimo, exemplar_emprestando,
                                    user_emprestando);

                            biblioteca.adicionarEmprestimo(new_emprestimo);
                            user_emprestando.adicionarEmprestimo(new_emprestimo);

                            System.out.println("Empréstimo realizado com sucesso!");
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao realizar o empréstimo!");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
                        }

                        // Cria um novo usuário
                    case 3:
                        try {
                            System.out.println("\nInsira os dados do novo usuário:");
                            System.out.println("Nome:");
                            sc.nextLine();
                            String nome_user = sc.nextLine();
                            System.out.println("Idade:");
                            int idade_user = sc.nextInt();
                            System.out.println("CPF:");
                            String cpf_user = sc.next();

                            if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_user), biblioteca)) {
                                System.out.println("CPF já cadastrado ou inválido!");
                                break;
                            }

                            Usuario new_usuario = new Usuario(nome_user, idade_user, utilitarios.maskaraCPF(cpf_user),
                                    utilitarios.generateIdUsuario());

                            biblioteca.adicionarUsuario(new_usuario);
                            System.out.println("\nUsuário(a) " + new_usuario.getNome() + " adicionado com sucesso!");
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar o usuário!");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
                        }

                        // Devolve um empréstimo
                    case 4:
                        try {
                            relatorio.gerarRelatorioEmprestimosBiblioteca(biblioteca);
                            System.out.println("Insira o id do emprestimo que deseja devolver:");
                            int idEmprestimo = sc.nextInt();

                            Emprestimo emprestimo = utilitarios.findEmprestimoById(idEmprestimo,
                                    biblioteca.getEmprestimos());

                            if (emprestimo == null) {
                                System.out.println("Empréstimo inexistente");
                                break;
                            }

                            biblioteca.devolverExemplar(emprestimo);
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao devolver o empréstimo!");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
                        }

                        // Lista os Usuários da biblioteca
                    case 5:
                        relatorio.listarUsuarios(biblioteca);
                        break;

                    // Lista todos os Exemplares da biblioteca
                    case 6:
                        relatorio.gerarRelatorioTodosOsLivros(biblioteca.getExemplares());
                        break;

                    // Lista os Exemplares que podem ser emprestados
                    case 7:
                        relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                                biblioteca.getEmprestimos());
                        break;

                    // Lista os Exemplares emprestados
                    case 8:
                        relatorio.gerarRelatorioEmprestimosBiblioteca(biblioteca);
                        break;

                    // Tela do funcionário logado
                    case 9:
                        try {

                            if (funcionario == null) {
                                System.out.println("Funcionário inexistente");
                                break;
                            }

                            // Abre o menu do(a) funcionário(a) com acesso limitado
                            editing_func(funcionario, sc);

                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao editar o funcionário!");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
                        }

                        // Tela dos Usuários da biblioteca
                    case 10:
                        try {
                            relatorio.listarUsuarios(biblioteca);
                            System.out.println("Qual o id do(a) usuário(a) que deseja editar?");
                            int id_user = sc.nextInt();
                            Usuario usuario = utilitarios.findUsuarioById(id_user, biblioteca.getUsuarios());
                            if (usuario == null) {
                                System.out.println("Usuário inexistente");
                                break;
                            }

                            // Abre o menu do(a) usuário(a)
                            editing_user(usuario, sc, biblioteca, relatorio);
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao editar o usuário!");
                            System.out.println("Erro: " + e);
                            sc.nextLine();
                            break;
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
