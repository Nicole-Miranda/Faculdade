package org.example;

import java.util.ArrayList;
import java.util.List;




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Nome do projeto - Exemplo Listas
    public static void main(String[] args) {
        //Vetor estÁtico
        Integer[] nums = new Integer[10];
        //nums[0] = "";

        //Vetor dinÂmico -> lembrar de SEMPRE tipar a lista

        List <String> nomes = new ArrayList();
        nomes.add("Diego");
        nomes.add("Nicole");
        nomes.add("Rafael");
        nomes.add("Fernanda");
        System.out.println(nomes);
        System.out.println("Tamanho da lista: " + nomes.size());
        System.out.println("O primeiro elemento da lista: " + nomes.get(0));
        System.out.println("O segundo elemento da lista: " + nomes.get(1));
        System.out.println("O Último elemento da lista: " + nomes.get(nomes.size() - 1)); //nomes.getLast()
        //nomes.gestFisrt()

        //nomes.add(1);
       // nomes.add(true);
        //nomes.add(10.0)

        nomes.remove("Diego");
        //nomes.remove(index:0);


        nomes.set(2, "vanderson");
        System.out.println(nomes);
        //List <Integer> numeros = new ArrayList();
        //numeros.add(1);
        //numeros.add(2);
        //numeros.add(3);
        //System.out.println(numeros);
        //Integer numero = 2;
        //numeros.remove(numero);
        //System.out.println(numeros);


        List <Integer> numerosMutavel = new ArrayList();
        numerosMutavel.add(10);
        System.out.println(numerosMutavel);

        List <Integer> numerosImutavel = List.of(10);
        numerosImutavel.add(20);
        System.out.println(numerosImutavel);

    }
}