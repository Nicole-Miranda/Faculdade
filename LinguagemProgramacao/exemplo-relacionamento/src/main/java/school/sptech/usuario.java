package school.sptech;

import java.time.LocalDate;

public class usuario {
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;

    public usuario(String nome, LocalDate dataNascimento, String email, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }


}
