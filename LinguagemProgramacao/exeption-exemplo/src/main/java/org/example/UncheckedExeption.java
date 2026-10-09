package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Exeption -> tudo que foge da regra de negócio de alguma classe ou operação
//Unchecked Exception -> não é obrigatório tratar
//são classes que herdam de RuntimeException

public class UncheckedExeption {
    public static void main (String[] args){
        //try-catch
        try {
            String nome = null;
            System.out.println(nome.toLowerCase());
            List<Integer> lista = new ArrayList<>();
            lista.get(10);
        }catch(IndexOutOfBoundsException indexOutOfBoundsException){
                System.out.println("Tentou acessar um indice que não existe");
            } catch(RuntimeException runtimeException){
            System.out.println("A variavável está nula");
            //System.out.println(runtimeException.getMessage());
            System.err.println(runtimeException.getMessage());
        }

        System.out.println("Mensagem!");

    }
}
