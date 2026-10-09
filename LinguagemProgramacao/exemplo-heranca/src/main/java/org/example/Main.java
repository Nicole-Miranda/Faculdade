package org.example;

import school.sptech.Aluno;
import school.sptech.AlunoPos;
import school.sptech.Faculdade;

public class Main {
    public static void main(String[] args) {
        Aluno aluno01 = new Aluno("Lucas", "040812747");
        aluno01.setNotaAc1(5.0);
        aluno01.setNotaAc2(7.0);
        aluno01.setNotaAc3(4.0);
        System.out.println(aluno01);
        System.out.println("Nota final do aluno: " + aluno01.calcularNotaFinal());

        Aluno alunoPos01 = new AlunoPos("Nicole","234435454");
        alunoPos01.setNotaAc1(8.0);
        alunoPos01.setNotaAc2(9.0);
        alunoPos01.setNotaAc3(10.0);
        //alunoPos01.setNotaTcc(7.0);
        System.out.println("Nota final do aluno da pos: " + alunoPos01.calcularNotaFinal());

        if(alunoPos01 instanceof AlunoPos){
            //casting -> mudar o tipo de variavel
            AlunoPos alunoPosConfirmado = (AlunoPos) alunoPos01;
            alunoPosConfirmado.setNotaTcc(7.0);
        }


        Faculdade faculdade = new Faculdade("SPTech");
        faculdade.adicionarAluno(aluno01);
        faculdade.adicionarAluno(alunoPos01);
        System.out.println("Média nota finais a da faculdade: " + faculdade.calcularMediaNotasFinais());

    }
}