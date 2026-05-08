package org.example;

import daoImplements.AlunoDAOImplements;
import database.sqlConn;
import model.Aluno;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        sqlConn.testConnection();
        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        Scanner read = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======= MENU ========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Aluno por id");
            System.out.println("0. Sair do programa");
            System.out.println("Escolha uma opção: ");

            opcao = read.nextInt();
            read.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Cadastro de aluno");
                    break;
                case 2:
                    System.out.println("Atualizar de aluno");
                    break;
                case 3:
                    System.out.println("Excluir de aluno");
                    break;
                case 4:
                    System.out.println("Listar de aluno");

                    List<Aluno> todosAlunos = alunoDaoMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty()){
                        System.out.println("Nenhum aluno encontrado");
                    } else {
                        for (Aluno aluno : todosAlunos){
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 5:
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

            }

        } while (opcao != 0);
    }
}
