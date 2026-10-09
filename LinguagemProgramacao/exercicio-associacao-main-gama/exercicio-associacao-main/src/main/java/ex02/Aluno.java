package ex02;

import java.util.List;

public class Aluno {
    private String ra;
    private String nome;
    private Boolean ativo;
    private Integer qtdMesesInadimplente;
    private List<Double> notas;

    public Aluno(String ra, String nome, Boolean ativo, Integer qtdMesesInadimplente, List<Double> notas) {
        this.ra = ra;
        this.nome = nome;
        this.ativo = ativo;
        this.qtdMesesInadimplente = qtdMesesInadimplente;
        this.notas = notas;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getQtdMesesInadimplente() {
        return qtdMesesInadimplente;
    }

    public void setQtdMesesInadimplente(Integer qtdMesesInadimplente) {
        this.qtdMesesInadimplente = qtdMesesInadimplente;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public Double calcularMedia() {
        if(!getNotas().isEmpty()) {
            Double Media = 0.0;
            for (Double nota : getNotas()) {
                Media += nota;
            }
            return Media / getNotas().size();
        } else {
            return 0.0;
        }
    }
}
