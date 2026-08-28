package school.sptech;

public class ExercicioVetores {

    Integer somar(Integer[] vetor) {

        Integer soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }

      return soma;
    }


    Double calcularMedia(Double[] notas){
        Double somaTotal = 0.0;
        int quantidade = notas.length;
        for (int i = 0; i < notas.length; i++) {
            somaTotal += notas[i];
        }

        Double media = somaTotal/quantidade;

        return media;
    }

    Integer buscarMaiorNumero(Integer[] vetor){
        Integer maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    Integer calcularDecimal(Integer[] binario){

       // Integer numero = 2;
        int resultado= 0;

        for (int i = binario.length - 1; i >= 0; i--) {
            binario[i] *= ((int) Math.pow(2.0, binario.length - 1 - i));
            resultado += binario[i];

        }
            return resultado;

    }

    Character[] inverter(Character[] vetor){

        Character[] invertido = new Character[vetor.length];
        Integer posicao = 0;
        for (Integer i = vetor.length - 1; i >= 0; i--) {
                invertido[posicao] = vetor[i];
                posicao++;

        }
       return invertido;
    }

    Integer[] mesclar(Integer[] vetor1, Integer[] vetor2){

        //Integer[] mesclar = new Integer[vetor1.length + vetor2.length];
        //Integer posicaoVetor1 = 0;
        //Integer posicaoVetor2 = 0;
        //Integer posicaoMesclar = 0;

        Integer[] mesclar = new Integer[vetor1.length + vetor2.length];

        for (int k = 0; k < vetor1.length; k++) {
            mesclar[k] = vetor1[k];
        }

        for (int l = 0; l < vetor2.length; l++) {
            mesclar[l + vetor1.length] = vetor2[l];
        }

        for (int i = 0; i < mesclar.length; i++) {
            for (int j = 0; j < mesclar.length; j++) {
                if (mesclar[i] < mesclar[j]) {
                    int numero = mesclar[i];
                    mesclar[i] = mesclar[j];
                    mesclar[j] = numero;
                }
            }
        }
        return mesclar;
    }

    Integer[] somarDois(Integer[] vetor, Integer alvo){

        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] + vetor[j] == alvo) {
                    Integer[] resultado = new Integer[2];
                    resultado[0] = i;
                    resultado[1] = j;
                    return resultado;
                }
            }
        }

        return null;
    }




}






