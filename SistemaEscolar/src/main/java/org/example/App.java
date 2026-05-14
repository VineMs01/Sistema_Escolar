package org.example;

import daoImplements.AlunoDAOImplements;
import daoImplements.TurmaDAOImplements;
import database.sqlConn;
import model.Aluno;
import model.Turma;


import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        sqlConn.testConnection();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        TurmaDAOImplements turmaDaoMethods = new TurmaDAOImplements();
        Scanner read = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======= MENU ========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Aluno por id");
            System.out.println("6. Listar Turmas e Alunos");
            System.out.println("0. Sair do programa");
            System.out.println("Escolha uma opção: ");

            opcao = read.nextInt();
            read.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar aluno");
                    System.out.print("Nome: ");
                    String nome = read.nextLine();

                    System.out.print("CPF: ");
                    String cpf = read.nextLine();

                    System.out.print("Email: ");
                    String email = read.nextLine();

                    System.out.print("Data de nascimento (dd/MM/yyyy): ");

                    LocalDate dataNascimento;

                    try {
                        dataNascimento = LocalDate.parse(
                                read.nextLine(),
                                formatter
                        );
                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                        break;
                    }

                    System.out.print("Telefone: ");
                    String telefone = read.nextLine();

                    Aluno novoAluno = new Aluno(
                            0,
                            nome,
                            cpf,
                            email,
                            dataNascimento,
                            telefone
                    );

                    alunoDaoMethods.salvar(novoAluno);
                    break;
                case 2:
                    System.out.println("Atualizar aluno");
                    System.out.print("Digite o ID do aluno: ");
                    int idAtualizar = read.nextInt();
                    read.nextLine();

                    Aluno alunoExistente =
                            alunoDaoMethods.listarPorId(idAtualizar);

                    if (alunoExistente == null) {
                        System.out.println("Aluno não encontrado!");
                        break;
                    }

                    System.out.print("Novo nome: ");
                    String novoNome = read.nextLine();

                    System.out.print("Novo CPF: ");
                    String novoCpf = read.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = read.nextLine();

                    System.out.print("Nova data nascimento (dd/MM/yyyy): ");

                    LocalDate novaData;

                    try {
                        novaData = LocalDate.parse(
                                read.nextLine(),
                                formatter
                        );
                    } catch (Exception e) {
                        System.out.println("Data inválida!");
                        break;
                    }

                    System.out.print("Novo telefone: ");
                    String novoTelefone = read.nextLine();

                    Aluno alunoAtualizado = new Aluno(
                            idAtualizar,
                            novoNome,
                            novoCpf,
                            novoEmail,
                            novaData,
                            novoTelefone
                    );

                    alunoDaoMethods.atualizarAluno(alunoAtualizado);
                    break;
                case 3:
                    System.out.println("Excluir aluno");
                    System.out.print("Digite o ID do aluno: ");
                    int idExcluir = read.nextInt();
                    read.nextLine();

                    alunoDaoMethods.excluirAluno(idExcluir);
                    break;
                case 4:
                    System.out.println("Listar Alunos");

                    List<Aluno> todosAlunos = alunoDaoMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Aluno aluno : todosAlunos) {
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Listar Aluno por ID");
                    System.out.println("Por qual id você quer procurar: ");
                    int idBusca = read.nextInt();
                    read.nextLine();

                    Aluno idAluno = alunoDaoMethods.listarPorId(idBusca);

                    if (idAluno != null) {
                        System.out.println("Aluno encontrado:");
                        System.out.println(idAluno);
                    } else {
                        System.out.println("Nenhum aluno encontrado com o ID: " + idBusca);
                    }
                    break;
                case 6:
                    System.out.println("Listar Turmas");

                    List<Turma> todasTurmas = turmaDaoMethods.listarTodasTurmas();

                    if (todasTurmas.isEmpty()) {
                        System.out.println("Nenhuma turma encontrada");
                    } else {
                        for (Turma turma : todasTurmas) {
                            System.out.println(turma);
                        }
                        System.out.println("Informe o id da turma para visualizar os alunos: ");
                        int idInformado = read.nextInt();

                        List<Aluno> alunosTurmaEncontradas = turmaDaoMethods.listarAlunosPorTurmaID(idInformado);

                        if (alunosTurmaEncontradas.isEmpty()) {
                            System.out.println("Nenhum aluno encontrado nesta turma!");
                        } else {
                            System.out.println("Alunos matriculados: ");
                            for (Aluno aluno : alunosTurmaEncontradas) {
                                System.out.println(aluno);
                            }
                        }
                    }

                        break;

                    }

            }
            while (opcao != 0) ;
        }
    }
