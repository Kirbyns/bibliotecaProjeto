package models;

import java.time.LocalDate;
import java.util.Scanner;

public class ActionsAdmin extends Action {

    // Construtor da classe
    public ActionsAdmin(Scanner sc, Biblioteca biblioteca, Relatorio relatorio, Utilitarios utilitarios) {
        super(sc, biblioteca, relatorio, utilitarios);
    }

    // Método para abrir menu e editar os dados de um funcionário
    public void editing_func(Funcionario funcionario, Scanner sc) {
        Utilitarios utilitarios = new Utilitarios();

        boolean editing_func = true;

        while (editing_func) {

            // Mostrando os dados do funcionário
            System.out.println("\n-----------------------------");
            System.out.println("\nId -> " + funcionario.getIdFuncionario());
            System.out.println("\nNome atual -> \n" + funcionario.getNome());
            System.out.println("\nIdade atual -> \n" + funcionario.getIdade());
            System.out.println("\nCPF atual -> ");
            System.out.println("\n" + utilitarios.showCPFString(funcionario.getCpf()));
            System.out.println("\nCargo atual -> " + funcionario.getCargo());
            System.out.println("\nSalário atual -> " + funcionario.getSalario());
            System.out
                    .println("\nData de admissão atual -> " + utilitarios.maskaraDate(funcionario.getDataDeAdmissao()));
            System.out.println("\nEmail atual -> " + funcionario.getEmail());
            System.out.println("\nRole no sistema -> " + funcionario.getRole());

            System.out.println("\n-----------------------------");

            System.out
                    .println("O que deseja editar no(a) funcionário(a) " + funcionario.getNome() + "?");
            System.out.println("0 - Sair");
            System.out.println("1 - Nome");
            System.out.println("2 - Idade");
            System.out.println("3 - Cargo");
            System.out.println("4 - Salário");
            System.out.println("5 - CPF");
            System.out.println("6 - Email");
            System.out.println("7 - Senha");
            System.out.println("8 - Role");
            int opcao_func = sc.nextInt();

            switch (opcao_func) {
                // Retorna para a tela anterior
                case 0:
                    editing_func = false;
                    break;

                // Edita o nome do funcionário
                case 1:
                    try {
                        System.out.println("\nNome atual -> " + funcionario.getNome());
                        System.out.println("Novo Nome:");
                        sc.nextLine();
                        String nome_func = sc.nextLine();
                        funcionario.setNome(nome_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Novo nome: " + funcionario.getNome() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o nome do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita a idade do funcionário
                case 2:
                    try {
                        System.out.println("\nIdade atual -> " + funcionario.getIdade());
                        System.out.println("Nova idade:");
                        sc.nextLine();
                        int idade_func = sc.nextInt();
                        funcionario.setIdade(idade_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Nova idade: " + funcionario.getIdade() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar a idade do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita o cargo do funcionário
                case 3:
                    try {
                        System.out.println("\nCargo atual -> " + funcionario.getCargo());
                        System.out.println("Novo Cargo:");
                        sc.nextLine();
                        String cargo_func = sc.nextLine();
                        funcionario.setCargo(cargo_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Novo cargo: " + funcionario.getCargo() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o cargo do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita o salário do funcionário
                case 4:
                    try {
                        System.out.println("\nSalário atual -> " + funcionario.getSalario());
                        System.out.println("Novo Salário:");
                        double salario_func = sc.nextDouble();
                        funcionario.setSalario(salario_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Novo salário: " + funcionario.getSalario() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o salário do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita o CPF do funcionário
                case 5:
                    try {
                        System.out
                                .println("\nCPF atual -> "
                                        + utilitarios.showCPFString(funcionario.getCpf()));
                        System.out.println("Novo CPF:");
                        String cpf_func = sc.next();

                        // Verificando se o CPF está no tamanho correto e se existe no sistema
                        if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_func), this.biblioteca)) {
                            System.out.println("CPF já cadastrado ou inválido!");
                            break;
                        }

                        // Realiza a mascara do CPF, transformando ele em Long
                        if (utilitarios.maskaraCPF(cpf_func) == null) {
                            System.out.println("CPF inválido!");
                            break;
                        }
                        funcionario.setCpf(utilitarios.maskaraCPF(cpf_func));
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println(
                                "Novo CPF: " + utilitarios.showCPFString(funcionario.getCpf()) + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o CPF do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita o email do funcionário
                case 6:
                    try {
                        System.out.println("\nEmail atual -> " + funcionario.getEmail());
                        System.out.println("Novo Email:");
                        String email_func = sc.next();
                        funcionario.setEmail(email_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Novo email: " + funcionario.getEmail() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar o email do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                // Edita a senha do funcionário
                case 7:
                    try {
                        System.out.println("\nSenha atual -> " + funcionario.getSenha());
                        System.out.println("Nova Senha:");
                        String senha_func = sc.next();
                        funcionario.setSenha(senha_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Nova senha: " + funcionario.getSenha() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar a senha do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                    break;

                case 8:
                    try {
                        System.out.println("\nRole atual -> " + funcionario.getRole());
                        System.out.println(
                                "0 - Admin com acesso ilimitado | 1 - Funcionário c/ acesso limitado | 2 - Funcionário c/ acesso a si mesmo");
                        System.out.println("Nova Role:");
                        int acesso_func = sc.nextInt();

                        funcionario.setRole(acesso_func);
                        System.out.println("\nFuncionário(a) editado com sucesso!");
                        System.out.println("Nova role: " + funcionario.getRole() + "\n");
                    } catch (Exception e) {
                        System.out.println("Erro ao editar a role do funcionário(a)");
                        System.out.println("Erro: " + e);
                    }
                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }
    }

    // Polimorfismo para o método menu, criando o menu para o admin
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
            System.out.println("4. Criar Funcionário");
            System.out.println("5. Devolver Exemplar");
            System.out.println("6. Listar Funcionários");
            System.out.println("7. Listar Usuários");
            System.out.println("8. Listar todos os Exemplares");
            System.out.println("9. Listar os Exemplares que podem ser Emprestados");
            System.out.println("10. Listar os Exemplares Emprestados");
            System.out.println("11. Tela de Funcionários");
            System.out.println("12. Tela de Usuários");

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
                            break;
                        }

                        // Cria um novo usário
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

                            if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_user), biblioteca)) {
                                System.out.println("CPF já cadastrado ou inválido!");
                                break;
                            }

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

                        // Cria um novo funcionário
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

                            if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_func), biblioteca)) {
                                System.out.println("CPF já cadastrado ou inválido!");
                                break;
                            }

                            System.out.println("Email:");
                            String email_func = sc.next();
                            System.out.println("Senha:");
                            String senha_func = sc.next();
                            System.out.println(
                                    "0 - Admin com acesso ilimitado | 1 - Funcionário c/ acesso limitado | 2 - Funcionário c/ acesso a si mesmo");
                            int acesso_func = sc.nextInt();

                            Funcionario new_funcionario = new Funcionario(cargo, salario, dataAdmissao, nome_func,
                                    idade_func,
                                    utilitarios.maskaraCPF(cpf_func),
                                    email_func, senha_func, utilitarios.generateIdFuncionario(), acesso_func);

                            biblioteca.adicionarFuncionarios(new_funcionario);
                            System.out
                                    .println("\nFuncionário(a) " + new_funcionario.getNome()
                                            + " adicionado com sucesso!");
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar o funcionário!");
                            System.out.println(e);
                            break;
                        }

                        // Devolve um empréstimo
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

                        // Lista os dados dos Funcionários
                    case 6:
                        relatorio.listarFuncionarios(biblioteca);
                        break;

                    // Lista os dados dos Usuários
                    case 7:
                        relatorio.listarUsuarios(biblioteca);
                        break;

                    // Lista os dados de todos os livros
                    case 8:
                        relatorio.gerarRelatorioTodosOsLivros(biblioteca.getExemplares());
                        break;

                    // Lista todos os livros que podem ser emprestados
                    case 9:
                        relatorio.gerarRelatorioLivrosNaoEmprestados(biblioteca.getExemplares(),
                                biblioteca.getEmprestimos());
                        break;

                    // Lista os dados de todos os empréstimos
                    case 10:
                        relatorio.gerarRelatorioEmprestimosBiblioteca(biblioteca);
                        break;

                    // Edita os dados de um funcionário específico
                    case 11:
                        try {
                            relatorio.listarFuncionarios(biblioteca);

                            System.out.println("Qual o id do(a) funcionário(a) que deseja editar?");

                            int id_func = sc.nextInt();
                            Funcionario funcionario = utilitarios.findFuncionarioById(id_func,
                                    biblioteca.getFuncionarios());

                            if (funcionario == null) {
                                System.out.println("Funcionário inexistente");
                                break;
                            }

                            // Chama o método para editar os dados do Funcionário
                            editing_func(funcionario, sc);

                            break;
                        } catch (Exception e) {
                            System.out.println("Erro ao editar o funcionário!");
                            System.out.println("Erro: " + e);
                        }
                        break;

                    // Edita os dados de um usário específico
                    case 12:
                        try {
                            relatorio.listarUsuarios(biblioteca);
                            System.out.println("Qual o id do(a) usário(a) que deseja editar?");
                            int id_user = sc.nextInt();
                            Usuario usuario = utilitarios.findUsuarioById(id_user, biblioteca.getUsuarios());
                            if (usuario == null) {
                                System.out.println("Usário inexistente");
                                break;
                            }

                            // Chama o método para editar os dados do Usuário
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
            } catch (Exception e) {
                System.out.println("Resposta inválida!");
                System.out.println("Erro: " + e);
                sc.nextLine();
            }
        }
    }

}
