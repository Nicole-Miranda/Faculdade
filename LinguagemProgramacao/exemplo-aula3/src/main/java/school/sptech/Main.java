package school.sptech;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        //metodo principal
        /*mensagem();
        mensagem2();
        System.out.println(mensagem2());
        String aula = mensagem2();
        System.out.println("Sexta feira:" + aula);
        System.out.println(calcular());
        System.out.println(calucularMedia(3.9,9.6,8.6));

        if (calcular().equals(calucularMedia(3.9,9.6,8.6))){
            System.out.println("São iguais");
        }else{
            System.out.println("São diferentes!");
        }*/
        Calculadora calculadora = new Calculadora();

        int soma = calculadora.somar(5, 5);
        int subtracao = calculadora.subtrair(5, 5);
        System.out.println(soma);
        System.out.println(subtracao);
        System.out.println(calculadora.dividir(10,20,40));
        double resultado = calculadora.multiplicar(
                calculadora.somar(10,7),
                calculadora.multiplicar(3,9));
    }
    static void mensagem(){
        //void um metodo que não possui retorno, um metodo que vai ser apenas executado
        //System.out.println("Hello World!");
    }

    static String mensagem2(){
        return "Aula de java";
    }

   static Double calcular(){
        return 3.0 + 5.9;
    }

    static Double calucularMedia(double n1, double n2, double n3){
        return (n1 + n2 + n3)/3;
    }

}