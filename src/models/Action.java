package models;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Action {

    public Scanner sc;
    public Biblioteca biblioteca;
    public Relatorio relatorio;
    public Utilitarios utilitarios;

    // Construtor da classe
    public Action(Scanner sc, Biblioteca biblioteca, Relatorio relatorio, Utilitarios utilitarios) {
        this.sc = sc;
        this.biblioteca = biblioteca;
        this.relatorio = relatorio;
        this.utilitarios = utilitarios;
    }

    // Método para mostrar o menu (será sobrescrito nas classes filhas)
    public void menu() {

    }

    public void editing_funcByFunc(Funcionario funcionario, Scanner sc) {
        Utilitarios utilitarios = new Utilitarios();

        boolean editing_func = true;

        while (editing_func) {
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
            System.out.println("3 - CPF");
            System.out.println("4 - Email");
            System.out.println("5 - Senha");
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
                    System.out.println("\nIdade atual -> " + funcionario.getIdade());
                    System.out.println("Nova idade:");
                    sc.nextLine();
                    int idade_func = sc.nextInt();
                    funcionario.setIdade(idade_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Nova idade: " + funcionario.getIdade() + "\n");
                    break;
                case 3:
                    System.out
                            .println("\nCPF atual -> "
                                    + utilitarios.showCPFString(funcionario.getCpf()));
                    System.out.println("Novo CPF:");
                    String cpf_func = sc.next();

                    if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_func), biblioteca)) {
                        System.out.println("CPF já cadastrado ou inválido!");
                        break;
                    }

                    if (utilitarios.maskaraCPF(cpf_func) == null) {
                        System.out.println("CPF inválido!");
                        break;
                    }
                    funcionario.setCpf(utilitarios.maskaraCPF(cpf_func));
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println(
                            "Novo CPF: " + utilitarios.showCPFString(funcionario.getCpf()) + "\n");
                    break;
                case 4:
                    System.out.println("\nEmail atual -> " + funcionario.getEmail());
                    System.out.println("Novo Email:");
                    String email_func = sc.next();
                    funcionario.setEmail(email_func);
                    System.out.println("\nFuncionário(a) editado com sucesso!");
                    System.out.println("Novo email: " + funcionario.getEmail() + "\n");
                    break;
                case 5:
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

    public void editing_user(Usuario usuario, Scanner sc, Biblioteca biblioteca, Relatorio relatorio) {
        Utilitarios utilitarios = new Utilitarios();

        boolean editing_user = true;

        while (editing_user) {

            System.out.println("\n-----------------------------");
            System.out.println("\nMatricula -> " + usuario.getMatricula());
            System.out.println("\nNome atual -> \n" + usuario.getNome());
            System.out.println("\nCPF atual -> ");
            System.out.println("\n" + utilitarios.showCPFString(usuario.getCpf()));
            relatorio.gerarRelatorioEmprestimosUsuario(usuario);
            System.out.println("\n-----------------------------");

            System.out
                    .println("\nO que deseja editar no(a) usuario(a) " + usuario.getNome() + "?");
            System.out.println("0 - Sair");
            System.out.println("1 - Nome");
            System.out.println("2 - CPF");
            System.out.println("3 - Adicionar empréstimo");
            System.out.println("4 - Devolver empréstimo");
            int opcao_user = sc.nextInt();

            switch (opcao_user) {
                case 0:
                    editing_user = false;
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
                        String cpf_user = sc.next();

                        if (!utilitarios.verficarCPF(utilitarios.maskaraCPF(cpf_user), biblioteca)) {
                            System.out.println("CPF já cadastrado ou inválido!");
                            break;
                        }

                        if (utilitarios.maskaraCPF(cpf_user) == null) {
                            System.out.println("CPF inválido!");
                            break;
                        }
                        usuario.setCpf(utilitarios.maskaraCPF(cpf_user));
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
}
