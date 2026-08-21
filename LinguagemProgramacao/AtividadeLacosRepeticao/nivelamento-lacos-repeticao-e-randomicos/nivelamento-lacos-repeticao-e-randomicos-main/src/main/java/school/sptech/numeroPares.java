package school.sptech;

public class numeroPares {
    public static void main(String[] args) {
        int numero = 0;

        while (numero <= 40) {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero++;
        }
    }
}