package dao;

import model.Aluno;

import java.util.List;

public interface IAlunoDAO {
    //Crud
    //C - Create
    void salvar(Aluno aluno);

    //R - Read
    List<Aluno> listarTodosAlunos();

    //U - Update
    void atualizarAluno(Aluno aluno);

    //D - Delete
    void excluirAluno(int id);
}
