package daoImplements;

import dao.IAlunoDAO;
import database.sqlConn;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno " +
                "(nome, cpf, email, data_nascimento, telefone) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getData_nascimento()));
            stmt.setString(5, aluno.getTelefone());

            stmt.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar aluno: " + e.getMessage());
        }

    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT * FROM aluno ORDER BY nome ASC";

        List<Aluno> alunos = new ArrayList<>();
        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println(rs);

            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getInt("alunoId"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os alunos: " + e.getMessage());
        }

        return alunos;
    }

    @Override
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET " +
                "nome = ?, " +
                "cpf = ?, " +
                "email = ?, " +
                "data_nascimento = ?, " +
                "telefone = ? " +
                "WHERE alunoId = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(aluno.getData_nascimento()));
            stmt.setString(5, aluno.getTelefone());
            stmt.setInt(6, aluno.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com esse ID.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }

    }

    @Override
    public void excluirAluno(int id) {

    }

    @Override
    public Aluno listarPorId(int id) {
        String sql = "SELECT * FROM Aluno WHERE alunoId = ?";
        Aluno aluno = null;

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aluno = new Aluno(
                            rs.getInt("alunoId"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("email"),
                            rs.getDate("data_nascimento").toLocalDate(),
                            rs.getString("telefone")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o aluno por ID: " + e.getMessage());
        }

        return aluno;
    }


}
