package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
       //numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
        Integer numero = 0;
        Integer numeroAleatorio;
        Integer soma = 0;
        do {
            //soma += numeroAleatorio;
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
            soma += numeroAleatorio;
            System.out.println("Sorteado: " + numeroAleatorio);
        }while(!numeroAleatorio.equals(numero));

        System.out.println("A soma dos números é: f" + soma);
    }
}
