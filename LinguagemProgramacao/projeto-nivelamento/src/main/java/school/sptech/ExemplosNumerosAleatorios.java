package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class ExemplosNumerosAleatorios {
    public static void main(String[] args) {
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(10);
        System.out.println(numeroAleatorio);
    }
}
