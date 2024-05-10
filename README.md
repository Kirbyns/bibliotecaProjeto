# PROJETO FINAL

Neste projeto, vocês terão a oportunidade de aplicar e demonstrar seus conhecimentos em conceitos fundamentais da POO, como herança, encapsulamento e polimorfismo. Vocês serão responsáveis por desenvolver um sistema de gestão de biblioteca, que permitirá o cadastro, empréstimo, devolução e consulta de livros, além de gerenciar informações de usuários e funcionários da biblioteca. O sistema deve ser estruturado de forma organizada e eficiente, utilizando boas práticas de programação e seguindo os padrões de POO.

## INFORMAÇÕES

O projeto deve conter no mínimo 10 classes Java, com um nível médio de complexidade, e utilizar arrays para armazenar informações como livros, usuários e funcionários. É fundamental também a elaboração de um arquivo README que explique detalhadamente cada parte do projeto, suas funcionalidades e como os conceitos de POO foram aplicados em cada classe. Durante a apresentação do projeto, os alunos devem ser capazes de identificar e explicar onde estão sendo aplicados os conceitos de herança, encapsulamento, polimorfismo e arrays. Além disso, serão avaliados critérios como arquitetura do projeto, tratamento de exceções, eficiência das operações, qualidade da documentação e interface com o usuário. Vocês terão a oportunidade de mostrar sua criatividade, habilidades de programação e compreensão dos princípios da Programação Orientada a Objetos. Estão prontos para esse desafio? Mãos à obra e bom trabalho!

## Projeto: Sistema de Gestão de Biblioteca

### Classes

- Pessoa: Representa uma pessoa genérica com atributos como nome, idade e CPF.
- Usuario: Herda de Pessoa e contém informações específicas de um usuário da biblioteca, como número de matrícula e histórico de empréstimos.
- Funcionario: Herda de Pessoa e possui dados como cargo, salário e data de admissão na biblioteca.
- Livro: Representa um livro com atributos como título, autor, editora e ano de publicação.
- Exemplar: Representa uma cópia específica de um livro, com um número de identificação único.
- Emprestimo: Contém informações sobre empréstimos, como data de início, data de devolução prevista e status.
- Biblioteca: Contém um array de Exemplares e métodos para gerenciar empréstimos, devoluções e cadastros.
- Relatorio: Classe responsável por gerar relatórios de empréstimos, livros disponíveis, etc.
- Main: Classe principal para inicialização do sistema e interação com o usuário através do console.
- Utilitarios: Classe com métodos utilitários, como validação de CPF e cálculo de datas.

## Recursos de POO utilizados

- Herança: Utilizada nas classes Usuario e Funcionario, que herdam de Pessoa.
- Encapsulamento: Atributos privados em todas as classes com métodos getters e setters para acesso.
- Polimorfismo: Método de empréstimo na classe Biblioteca que aceita tanto usuários quanto funcionários como parâmetro, permitindo polimorfismo de tipo.

## Estrutura do Projeto

src/
models/: Pacote contendo as classes do modelo.
Pessoa.java
Usuario.java
Funcionario.java
Livro.java
Exemplar.java
Emprestimo.java
Biblioteca.java
Relatorio.java
Utilitarios.java
Main.java: Classe principal para execução do programa.
README.md: Arquivo de instruções e explicação do projeto.
