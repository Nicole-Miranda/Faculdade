package org.example;

import java.io.FileNotFoundException;

//CheckdException -> é obrigatório tratar a exceção
public class CheckedException {
    public static void main(String[] args){
        Leitor leitor = new Leitor();
        try {
            leitor.ler();

        }catch (Exception e){
            System.out.println("Arquivo não encontrado");
        }


    }

}
