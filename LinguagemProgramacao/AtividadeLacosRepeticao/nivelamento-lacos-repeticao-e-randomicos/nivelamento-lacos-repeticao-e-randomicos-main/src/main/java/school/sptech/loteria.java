package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class loteria {
  public static void main(String[] args) {
    Integer numero = 5;
    Integer sorteio;
    Integer tentativas = 0;

    do {
      sorteio = ThreadLocalRandom.current().nextInt(11);
      tentativas++;
      System.out.println("Sorteado: " + sorteio);
    } while (!sorteio.equals(numero));

    System.out.println("Acertou em " + tentativas + " tentativa(s)!");

    if (tentativas <= 3) {
      System.out.println("Você é MUITO sortudo");
    } else if (tentativas <= 10) {
      System.out.println("Você é sortudo");
    } else {
      System.out.println("É melhor você parar de apostar e ir trabalhar");
    }
  }
}