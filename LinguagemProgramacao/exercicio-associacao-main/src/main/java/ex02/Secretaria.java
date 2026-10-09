package ex02;

import java.util.List;

public class Secretaria {

    private Integer totalInadimplentes;
    private Integer totalCancelamentos;
    private Integer totalPagamentos;

    public Secretaria() {
        this.totalInadimplentes = 0;
        this.totalCancelamentos = 0;
        this.totalPagamentos = 0;
    }

    public Integer getTotalInadimplentes() {
        return totalInadimplentes;
    }

    public Integer getTotalCancelamentos() {
        return totalCancelamentos;
    }

    public Integer getTotalPagamentos() {
        return totalPagamentos;
    }

    public void registraPagamento(Aluno aluno) {
        aluno.setQtdMesesInadimplente(0);
        totalPagamentos++;
    }

    public void registraInadimplencia(Aluno aluno) {
        aluno.setQtdMesesInadimplente(aluno.getQtdMesesInadimplente() + 1);
        totalInadimplentes++;
    }

    public Boolean registraCancelamento(Aluno aluno) {
        if (aluno.getQtdMesesInadimplente() >= 3) {
            aluno.setAtivo(false);
            totalCancelamentos++;
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaAprovacaoAluno(Aluno aluno) {
        if (aluno.getNome() != null
                && aluno.getAtivo()
                && !aluno.getRa().isBlank()
                && aluno.getQtdMesesInadimplente() <= 0
                && aluno.calcularMedia() >= 6) {
            return true;
        } else {
            return false;
        }
    }

    public Double calcularMediaGeralTurma(List<Aluno> alunos){
        Double totalFinal = 0.0;
        Integer alunosAtivos = 0;

        if(!alunos.isEmpty()){
            for (Aluno aluno : alunos){
                if(aluno.getAtivo()){
                    totalFinal += aluno.calcularMedia();
                    alunosAtivos++;
                }
            }
        }

        if(alunosAtivos == 0){
            return 0.0;
        }

        return totalFinal / alunosAtivos;
    }


    public Double calcularPercentualInadimplencia(List<Aluno> alunos) {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        Integer inadimplentes = 0;
        for (Aluno aluno : alunos) {
            if (aluno.getQtdMesesInadimplente() > 0) {
                inadimplentes++;
            }
        }

        return (inadimplentes * 100.0) / alunos.size();
    }

    public Double calcularDesvioPadraoTurma(List<Aluno> alunos) {
        Double media= calcularMediaGeralTurma(alunos);
        Double soma = 0.0;
        Integer ativos = 0;

        for (Aluno aluno : alunos) {
            if (aluno.getAtivo()) {
                Double mediaAluno = aluno.calcularMedia();
                Double diferenca = mediaAluno - media;
                soma += Math.pow(diferenca, 2);
                ativos++;
            }
        }

        if (ativos == 0) {
            return 0.0;
        }

        Double variancia = soma / ativos;
        return Math.sqrt(variancia);
    }

}