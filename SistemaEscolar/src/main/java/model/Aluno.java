package model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Aluno {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate data_nascimento;
    private String telefone;

    // Construtor para CRIAR um novo aluno
    public Aluno(String nome, String cpf, String email, LocalDate data_nascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    // Construtor para LEITURA do banco (id ja existe)
    public Aluno(int id, String nome, String cpf, String email, LocalDate data_nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
                "==============================\n" +
                        "ID: %d\n" +
                        "Nome: %s\n" +
                        "CPF: %s\n" +
                        "Email: %s\n" +
                        "Nascimento: %s\n" +
                        "Telefone: %s\n" +
                        "==============================",
                id, nome, cpf, email, data_nascimento, telefone
        );
    }
}
