package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {
    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome){
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public Double calcularMediaNotasFinais(){
        Double total = 0.0;

        for (Aluno aluno : alunos){
            total += aluno.calcularNotaFinal();
        }

        return  total / alunos.size();
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public Double calcularMediaNotaPos(){
        Double total = 0.0;
        Integer qtdAlunoPos = 0;


        for (Aluno aluno : alunos){
            if(aluno instanceof AlunoPos alunoPos){
                total += alunoPos.calcularNotaFinal();
                qtdAlunoPos ++;
            }

        }

        return  total / qtdAlunoPos;
    }


    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Faculdade{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
