package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class sorteio {
    public static void main(String[] args) {

       Integer numero = 80;
       Integer sorteio;
       Integer pares = 0;
       Integer impares = 0;

       for (int i = 1; i <= 200; i++) {
           sorteio = ThreadLocalRandom.current().nextInt(1, 100);
           if(numero == sorteio){
               System.out.println("Posição do número 80: " + i);
           }else if(sorteio %2 == 0){
            pares++;
               //System.out.println("Números pares: " + pares);
           } else {
               impares++;
               //System.out.println("Números impares: " + impares);
           }

       }

        System.out.println("Números pares: " + pares);
        System.out.println("Números impares: " + impares);

    }
}
