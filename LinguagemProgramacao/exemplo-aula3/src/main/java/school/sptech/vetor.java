package school.sptech;

import java.util.Arrays;

public class vetor {
    public static void main(String[] args) {
        // Vetor em JS -> let numeros = []



        //Integer[] numeros = new Integer[]{10,20,30};
        Integer[] numeros2 = {10,20,30};

        /*numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;*/
        System.out.println(Arrays.toString(numeros2));

        //numeroS2.fori
        for (int i = 0; i < numeros2.length; i ++){
            Integer numeroDaVez = numeros2[i];
            System.out.println(numeroDaVez);
        }

        System.out.println("For reverso: ");
        // numeros2.forr
        for (int i = numeros2.length - 1; i >= 0; i --){
            System.out.println(numeros2[i]);
        }

        System.out.println("For aprimorado: ");
        // numeros2.for
        for(Integer numeroDaVez : numeros2){
            System.out.println(numeroDaVez);
        }



        System.out.println("Resultado do somar:");

        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.somar(numeros2));

    }
}
