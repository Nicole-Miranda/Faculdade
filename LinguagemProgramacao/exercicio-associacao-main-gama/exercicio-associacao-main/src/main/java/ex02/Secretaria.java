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
        totalInadimplentes++;
        aluno.setQtdMesesInadimplente(aluno.getQtdMesesInadimplente() + 1);
    }

    public Boolean registraCancelamento(Aluno aluno) {
        if(aluno.getQtdMesesInadimplente() >= 3) {
            aluno.setAtivo(false);
            totalCancelamentos++;
            return true;
        } else {
            return false;
        }
    }

    public Boolean verificaAprovacaoAluno(Aluno aluno) {
        return (!aluno.getNome().isBlank() &&
            aluno.getNome() != null &&
            !aluno.getRa().isBlank() &&
            aluno.getRa() != null &&
            aluno.getAtivo() &&
            aluno.getQtdMesesInadimplente() <= 0 &&
            aluno.calcularMedia() >= 6.0);
    }

    public Double calcularMediaGeralTurma(List<Aluno> alunos) {
        Double SomaMedias = 0.0;
        Integer qtd_ativos = 0;

        if(!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                if(aluno.getAtivo()) {
                    SomaMedias += aluno.calcularMedia();
                    qtd_ativos ++;
                }
            }
            if (qtd_ativos != 0) {
                SomaMedias /= qtd_ativos;
            }
        }
        return SomaMedias;
    }

    public Double calcularPercentualInadimplencia(List<Aluno> alunos) {
        Integer qtd_inadimplentes = 0;
        Double percentual = 0.0;

        if(!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                if(aluno.getQtdMesesInadimplente() > 0) {
                    qtd_inadimplentes++;
                }
            }
            if (qtd_inadimplentes != 0) {
                percentual = (qtd_inadimplentes * 100.00) / alunos.size() ;
            }
        }
        return percentual;
    }

    public Double calcularDesvioPadraoTurma(List<Aluno> alunos) {
        Integer qtd_alunosAtivos = 0;
        Double SomaDosQuadrados = 0.0;
        if(!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                if (aluno.getAtivo()) {
                    SomaDosQuadrados += Math.pow(aluno.calcularMedia() - calcularMediaGeralTurma(alunos), 2);
                    qtd_alunosAtivos++;
                }
            }
            if(qtd_alunosAtivos != 0) {
                return Math.sqrt(SomaDosQuadrados / qtd_alunosAtivos);
            }
        }
        return SomaDosQuadrados;
    }
}

