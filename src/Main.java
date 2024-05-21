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
    public static void editing_func(Funcionario funcionario, Scanner sc) {
        Utilitarios utilitarios = new Utilitarios();

        boolean editing_func = true;

        while (editing_func) {
            System.out
                    .println("O que deseja editar no(a) funcionário(a) " + funcionario.getNome() + "?");
            System.out.println("0 - Sair");
            System.out.println("1 - Nome");
            System.out.println("2 - Cargo");
            System.out.println("3 - Salário");
            System.out.println("4 - CPF");
            System.out.println("5 - Email");
            System.out.println("6 - Senha");
            int opcao_func = sc.nextInt();

            switch (opcao_func) {
                case 0:
                    editing_func = false;
                    break;
                case 1:
                    System.out.println("\nNome atual -> " + funcionario.getNome());
                    System.out.println("Novo Nome:");
                    sc.nextLine();
                    String nome_func = sc.nextLine();
                    funcionario.setNome(nome_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Novo nome: " + funcionario.getNome() + "\n");
                    break;
                case 2:
                    System.out.println("\nCargo atual -> " + funcionario.getCargo());
                    System.out.println("Novo Cargo:");
                    sc.nextLine();
                    String cargo_func = sc.nextLine();
                    funcionario.setCargo(cargo_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Novo cargo: " + funcionario.getCargo() + "\n");
                    break;
                case 3:
                    System.out.println("\nSalário atual -> " + funcionario.getSalario());
                    System.out.println("Novo Salário:");
                    double salario_func = sc.nextDouble();
                    funcionario.setSalario(salario_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Novo salário: " + funcionario.getSalario() + "\n");
                    break;
                case 4:
                    System.out
                            .println("\nCPF atual -> "
                                    + utilitarios.showCPFString(funcionario.getCpf()));
                    System.out.println("Novo CPF:");
                    String cpf_func = sc.next();
                    if (utilitarios.maskaraCPF(cpf_func) == null) {
                        System.out.println("CPF inválido!");
                        break;
                    }
                    funcionario.setCpf(utilitarios.maskaraCPF(cpf_func));
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println(
                            "Novo CPF: " + utilitarios.showCPFString(funcionario.getCpf()) + "\n");
                    break;
                case 5:
                    System.out.println("\nEmail atual -> " + funcionario.getEmail());
                    System.out.println("Novo Email:");
                    String email_func = sc.next();
                    funcionario.setEmail(email_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Novo email: " + funcionario.getEmail() + "\n");
                    break;
                case 6:
                    System.out.println("\nSenha atual -> " + funcionario.getSenha());
                    System.out.println("Nova Senha:");
                    String senha_func = sc.next();
                    funcionario.setSenha(senha_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Nova senha: " + funcionario.getSenha() + "\n");
                    break;
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }
    }

    public static void editing_user(Usuario usuario, Scanner sc, Biblioteca biblioteca, Relatorio relatorio) {
        Utilitarios utilitarios = new Utilitarios();

        boolean editing_func = true;

        while (editing_func) {

            System.out.println("\n-----------------------------");
            System.out.println("\nMatricula -> " + usuario.getMatricula());
            System.out.println("\nNome atual -> \n" + usuario.getNome());
            System.out.println("\nCPF atual -> ");
            System.out.println("\n" + utilitarios.showCPFString(usuario.getCpf()));
            relatorio.gerarRelatorioEmprestimosUsuario(usuario);
            System.out.println("\n-----------------------------");

            System.out
                    .println("O que deseja editar no(a) usuario(a) " + usuario.getNome() + "?");
            System.out.println("0 - Sair");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - Adicionar empréstimo");
            System.out.println("4 - Devolver empréstimo");
            int opcao_func = sc.nextInt();

            switch (opcao_func) {
                case 0:
                    editing_func = false;
                    break;
                case 1:
                    try {
                        System.out.println("\nNome atual -> " + usuario.getNome());
                        System.out.println("Novo Nome:");
                        sc.nextLine();
                        String nome_func = sc.nextLine();
                        usuario.setNome(nome_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Novo nome: " + usuario.getNome() + "\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("Nome inválido!");
                        break;
                    }
                case 2:
                    try {
                        System.out
                                .println("\nCPF atual -> "
                                        + utilitarios.showCPFString(usuario.getCpf()));
                        System.out.println("Novo CPF:");
                        String cpf_func = sc.next();
                        if (utilitarios.maskaraCPF(cpf_func) == null) {
                            System.out.println("CPF inválido!");
                            break;
                        }
                        usuario.setCpf(utilitarios.maskaraCPF(cpf_func));
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println(
                                "Novo CPF: " + utilitarios.showCPFString(usuario.getCpf()) + "\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("CPF inválido!");
                        break;
                    }
                case 3:
                    try {
                        relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                                biblioteca.getEmprestimos());

                        System.out.println("\nInsira os dados do novo empréstimo:");
                        System.out.println("Id do Exemplar:");
                        int id_exemplar = sc.nextInt();
                        LocalDate data_emprestimo = LocalDate.now();
                        String status_emprestimo = "Emprestado";

                        Exemplar exemplar_emprestando = utilitarios.findExemplarById(id_exemplar,
                                biblioteca.getExemplares());

                        if (exemplar_emprestando == null) {
                            System.out.println("Exemplar inexistente!");
                            break;
                        }
                        if (utilitarios.verificarEmprestimo(id_exemplar, biblioteca.getEmprestimos())) {
                            System.out.println("Exemplar indisponível!");
                            break;
                        }

                        Emprestimo new_emprestimo = new Emprestimo(utilitarios.generateIdEmprestimo(), data_emprestimo,
                                status_emprestimo, exemplar_emprestando,
                                usuario);

                        biblioteca.adicionarEmprestimo(new_emprestimo);
                        usuario.adicionarEmprestimo(new_emprestimo);

                        System.out.println("Empréstimo realizado com sucesso!");
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar o empréstimo!");
                        System.out.println("Erro: " + e);
                        break;
                    }
                case 4:
                    try {
                        relatorio.gerarRelatorioEmprestimosUsuario(usuario);

                        if (usuario.getHistoricoDeEmprestimo().isEmpty()) {
                            System.out.println();
                            break;
                        }
                        System.out.println("Insira o id do emprestimo que deseja devolver:");
                        int idEmprestimo = sc.nextInt();

                        Emprestimo emprestimo = utilitarios.findEmprestimoById(idEmprestimo,
                                biblioteca.getEmprestimos());

                        if (emprestimo == null) {
                            System.out.println("Empréstimo inexistente");
                            break;
                        }

                        if (!usuario.getHistoricoDeEmprestimo().contains(emprestimo)) {
                            System.out.println("Empréstimo inexistente");
                            break;
                        }

                        biblioteca.devolverExemplar(emprestimo);
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao devolver o empréstimo!");
                        System.out.println("Erro: " + e);
                        break;
                    }
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Instanciando Utilitários, Relatorio e Biblioteca
        Utilitarios utilitarios = new Utilitarios();
        Relatorio relatorio = new Relatorio();

        Biblioteca biblioteca = new Biblioteca();

        // Adicionando Funcionários
        Funcionario funcionario1 = new Funcionario("Diretor", 2800.00, LocalDate.now(), "Francisco Pavão", 23,
                utilitarios.maskaraCPF("012394890-90"), "admin@gmail.com", "1234", utilitarios.generateIdFuncionario());
        Funcionario funcionario2 = new Funcionario("Bibliotecário Diurno", 1300.00, LocalDate.now(), "Ednea Suarez", 65,
                utilitarios.maskaraCPF("741569852-32"), "bibliotecario.diurno@gmail.com", "1234",
                utilitarios.generateIdFuncionario());
        Funcionario funcionario3 = new Funcionario("Bibliotecário Noturno", 1800.00, LocalDate.now(), "Ângelo Alvares",
                35, utilitarios.maskaraCPF("569852456-56"), "bibliotecario.noturno@gmail.com", "1234",
                utilitarios.generateIdFuncionario());

        // Adicionando Usuários
        Usuario usuario1 = new Usuario("Victor", 18, utilitarios.maskaraCPF("123.456.789-89"),
                utilitarios.generateIdUsuario());
        Usuario usuario2 = new Usuario("Lorena", 28, utilitarios.maskaraCPF("263.798.556-92"),
                utilitarios.generateIdUsuario());

        // Adicionando Exemplares
        Exemplar exemplar1 = new Exemplar("Patrick Newman", "Os 4 patos da Lagoa", "Âncora Alerde", LocalDate.now(),
                utilitarios.generateIdExemplar());
        Exemplar exemplar2 = new Exemplar("Patrick Newman", "Os 3 patos da Lagoa e a Vingança", "Âncora Alerde",
                LocalDate.now(),
                utilitarios.generateIdExemplar());

        // Adicionando Emprestimo
        Emprestimo emprestimo1 = new Emprestimo(utilitarios.generateIdEmprestimo(), LocalDate.now(), "Emprestado",
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

        System.out.println("\nSeja bem-vindo!");
        // Iniciando o menu
        boolean run = true;
        while (run) {
            int response;

            System.out.println("\nO que deseja?");
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
            System.out.println("11. Tela de Funcionários");
            System.out.println("12. Tela de Usuários");

            response = sc.nextInt();

            // Verificando a resposta
            switch (response) {
                case 0:
                    run = false;
                    break;
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
                        break;
                    }
                case 2:
                    try {
                        relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                                biblioteca.getEmprestimos());
                        relatorio.listarUsuarios(biblioteca);

                        System.out.println("\nInsira os dados do novo empréstimo:");
                        System.out.println("Id do Exemplar:");
                        int id_exemplar = sc.nextInt();
                        System.out.println("Id do Usário:");
                        int id_user = sc.nextInt();
                        LocalDate data_emprestimo = LocalDate.now();
                        String status_emprestimo = "Emprestado";

                        Usuario user_emprestando = utilitarios.findUsuarioById(id_user, biblioteca.getUsuarios());

                        Exemplar exemplar_emprestando = utilitarios.findExemplarById(id_exemplar,
                                biblioteca.getExemplares());

                        if (user_emprestando == null) {
                            System.out.println("Usário inexistente!");
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

                        Emprestimo new_emprestimo = new Emprestimo(utilitarios.generateIdEmprestimo(), data_emprestimo,
                                status_emprestimo, exemplar_emprestando,
                                user_emprestando);

                        biblioteca.adicionarEmprestimo(new_emprestimo);
                        user_emprestando.adicionarEmprestimo(new_emprestimo);

                        System.out.println("Empréstimo realizado com sucesso!");
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar o empréstimo!");
                        System.out.println("Erro: " + e);
                        break;
                    }
                case 3:
                    try {
                        System.out.println("\nInsira os dados do novo usário:");
                        System.out.println("Nome:");
                        sc.nextLine();
                        String nome_user = sc.nextLine();
                        System.out.println("Idade:");
                        int idade_user = sc.nextInt();
                        System.out.println("CPF:");
                        String cpf_user = sc.next();

                        Usuario new_usuario = new Usuario(nome_user, idade_user, utilitarios.maskaraCPF(cpf_user),
                                utilitarios.generateIdUsuario());

                        biblioteca.adicionarUsuario(new_usuario);
                        System.out.println("\nUsário(a) " + new_usuario.getNome() + " adicionado com sucesso!");
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar o usário!");
                        System.out.println("Erro: " + e);
                        break;
                    }

                case 4:
                    try {
                        System.out.println("\nInsira os dados do novo funcionário:");

                        System.out.println("Nome:");
                        sc.nextLine();
                        String nome_func = sc.nextLine();
                        System.out.println("Idade:");
                        int idade_func = sc.nextInt();
                        System.out.println("Cargo:");
                        sc.nextLine();
                        String cargo = sc.nextLine();
                        System.out.println("Salário:");
                        double salario = sc.nextDouble();
                        LocalDate dataAdmissao = LocalDate.now();
                        System.out.println("CPF:");
                        String cpf_func = sc.next();
                        System.out.println("Email:");
                        String email_func = sc.next();
                        System.out.println("Senha:");
                        String senha_func = sc.next();

                        Funcionario new_funcionario = new Funcionario(cargo, salario, dataAdmissao, nome_func,
                                idade_func,
                                utilitarios.maskaraCPF(cpf_func),
                                email_func, senha_func, utilitarios.generateIdFuncionario());

                        biblioteca.adicionarFuncionarios(new_funcionario);
                        System.out
                                .println("\nFuncionário(a) " + new_funcionario.getNome() + " adicionado com sucesso!");
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar o funcionário!");
                        System.out.println(e);
                        break;
                    }
                case 5:
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
                        break;
                    }
                case 6:
                    relatorio.listarFuncionarios(biblioteca);
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
                case 11:
                    try {
                        relatorio.listarFuncionarios(biblioteca);

                        System.out.println("Qual funcionário(a) deseja editar?");

                        int id_func = sc.nextInt();
                        Funcionario funcionario = utilitarios.findFuncionarioById(id_func,
                                biblioteca.getFuncionarios());

                        if (funcionario == null) {
                            System.out.println("Funcionário inexistente");
                            break;
                        }

                        editing_func(funcionario, sc);

                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o funcionário!");
                        System.out.println("Erro: " + e);
                    }
                    break;
                case 12:
                    try {
                        relatorio.listarUsuarios(biblioteca);
                        System.out.println("Qual usário deseja editar?");
                        int id_user = sc.nextInt();
                        Usuario usuario = utilitarios.findUsuarioById(id_user, biblioteca.getUsuarios());
                        if (usuario == null) {
                            System.out.println("Usário inexistente");
                            break;
                        }
                        editing_user(usuario, sc, biblioteca, relatorio);
                        break;
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o usário!");
                        System.out.println("Erro: " + e);
                    }
                    break;
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }

        System.out.println("\nAté mais!");
        // Encerrando o programa
        sc.close();
    }
}