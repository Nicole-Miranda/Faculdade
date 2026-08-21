package school.sptech;

public class Calculadora {
    int somar(int n1, int n2){
        return n1+n2;
    }
    int subtrair(int n1, int n2){
        return n1-n2;
    }
    int multiplicar(int n1, int n2){
        return (somar(n1,n2)*n2)*n1;
    }
    double dividir(int n1, int n2){
        return n1/n2;
    }
    double dividir (int n1, int n2, int n3){
        return 0;
    }
    double dividir (double n1, double n2){
        return n1/n2;
    }
    double dividir (int n1, int n2, double n3){
        return n1/n2/n3;
    }

    int soma = 0;
    //vetor numeros = new vetor();

    Integer somar(Integer[] numeros2){

        for (int i = 0; i < numeros2.length; i++) {
            soma+=numeros2[i];
        }
        System.out.println(soma);

        return soma;
    }


}
