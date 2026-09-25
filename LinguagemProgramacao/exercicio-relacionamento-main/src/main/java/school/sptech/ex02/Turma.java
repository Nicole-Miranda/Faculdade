package school.sptech.ex02;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String nome;
    private List<Aluno> alunos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void matricular(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().trim().isEmpty()) {
            return;
        }
        if (aluno.getIdade() == null || aluno.getIdade() < 0) {
            return;
        }
        if (aluno.getNotaProva() == null || aluno.getNotaAtividade() == null) {
            return;
        }
        if (aluno.getNotaProva() < 0.0 || aluno.getNotaProva() > 10.0) {
            return;
        }
        if (aluno.getNotaAtividade() < 0.0 || aluno.getNotaAtividade() > 10.0) {
            return;
        }

        alunos.add(aluno);
    }

    public List<Aluno> buscarPorParteDoNome(String nome) {
        List<Aluno> encontrados = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(a);
            }
        }

        return encontrados;
    }

    public List<Aluno> buscarAprovados(Double notaMinima) {
        List<Aluno> aprovados = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            if (a.calcularNotaFinal() >= notaMinima) {
                aprovados.add(a);
            }
        }

        return aprovados;
    }

    public Double calcularMediaTurma() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).calcularNotaFinal();
        }

        return soma / alunos.size();
    }

    public List<Aluno> buscarAcimaDaMedia() {
        List<Aluno> acimaDaMedia = new ArrayList<>();
        double media = calcularMediaTurma();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            if (a.calcularNotaFinal() > media) {
                acimaDaMedia.add(a);
            }
        }

        return acimaDaMedia;
    }

    public Aluno buscarMenorNota() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno menor = alunos.get(0);

        for (int i = 1; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            if (a.calcularNotaFinal() < menor.calcularNotaFinal()) {
                menor = a;
            }
        }

        return menor;
    }

    public Double calcularIdadeMedia() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double soma = 0.0;
        for (int i = 0; i < alunos.size(); i++) {
            soma += alunos.get(i).getIdade();
        }

        return soma / alunos.size();
    }

    public Double calcularAmplitudeNotas() {
        if (alunos.isEmpty()) {
            return 0.0;
        }

        double maior = alunos.get(0).calcularNotaFinal();
        double menor = alunos.get(0).calcularNotaFinal();

        for (int i = 1; i < alunos.size(); i++) {
            double notaFinal = alunos.get(i).calcularNotaFinal();
            if (notaFinal > maior) {
                maior = notaFinal;
            }
            if (notaFinal < menor) {
                menor = notaFinal;
            }
        }

        return maior - menor;
    }

    public List<Aluno> encontrarAlunosComMesmaNota() {
        List<Aluno> repetidos = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno atual = alunos.get(i);
            boolean temDuplicata = false;

            for (int j = 0; j < alunos.size(); j++) {
                if (i != j && atual.calcularNotaFinal().equals(alunos.get(j).calcularNotaFinal())) {
                    temDuplicata = true;
                    break;
                }
            }

            if (temDuplicata && !repetidos.contains(atual)) {
                repetidos.add(atual);
            }
        }

        return repetidos;
    }
}