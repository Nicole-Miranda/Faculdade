package school.sptech.ex4;

public class Turma {

    String turma;
    Integer capacidadeMaxima;
    Integer quantidadeAlunosMatriculados;

    void matricularAluno(Integer alunosMatricular){

        if(alunosMatricular < 0){
            return;
        } else if (quantidadeAlunosMatriculados + alunosMatricular > capacidadeMaxima) {
            return;
        }else{
            quantidadeAlunosMatriculados += alunosMatricular;
        }

        return;
    }


    Double encontrarMaiorNota(Double[] notas){
    Double maiorNota = notas[0] ;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] > maiorNota){
                maiorNota = notas[i];
            }
        }

        return maiorNota;
    }

    Double calcularMediaTurma(Double[] notas){
        Double somaTotal = 0.0;
        Integer quantidade = notas.length;

        for (int i = 0; i < notas.length; i++) {
            somaTotal += notas[i];
        }

        return somaTotal / quantidade;
    }


    Integer contarAprovados(Double[] notas){
        int aprovados = 0;

        for (int i = 0; i < notas.length; i++) {
            if(notas[i] >= 6){
                aprovados++;
            }
        }

        return aprovados;
    }

    boolean validarQuantidadeNotas(Double[] notas){
        if(notas.length == quantidadeAlunosMatriculados){
            return true;
        } else {
            return false;
        }
    }



    Double encontrarNotaMaisProximaDaMedia(Double[] notas){
        Double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        Double media = soma / notas.length;

        Double notaMaisProxima = notas[0];
        Double menorDiferenca = Math.abs(notas[0] - media);

        for (int i = 1; i < notas.length; i++) {
            Double diferenca = Math.abs(notas[i] - media);
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                notaMaisProxima = notas[i];
            }
        }

        return notaMaisProxima;
    }
}
