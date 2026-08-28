package school.sptech;

public class ExercicioMetodos {

    Boolean verificarMaioridade(Integer idade){
        return idade>=18;
    }

    Double calcularMedia(Double valor1, Double valor2, Double valor3){
        return (valor1 + valor2 + valor3)/3;
    }

    Integer maiorNumero(Integer valor1, Integer valor2, Integer valor3){
    return Math.max(Math.max(valor1, valor2),valor3);
    }

    Integer calcularFatorial(Integer valor){

        int fatorial = 1;
        for (Integer i = valor; i > 0; i--) {
           fatorial *= i;
        }

        return fatorial;
    }

    Boolean verificarPrimo(Integer valor) {
        if (valor == null || valor <= 1) {
            return false;
        }
        boolean primo = true;
        int contador = 0;
        for (Integer i = 1; i <= valor; i++) {

            if (valor % i == 0) {
                contador++;
            }
        }
        if (contador != 2) {
            primo = false;
        }
        return primo;
    }


    Integer calcularPotencia(Integer base, Integer expoente){
        Integer resultado = 1;
        for (int i = 0; i < expoente; i++) {
            resultado *= base;
        }
      return resultado;
    }

    Integer calcularTrocoEmBalas(Double valorCompra, Double valorRecebido){

        if (valorCompra == null || valorRecebido == null || valorRecebido < valorCompra) {
            return 0;
        }

        Double troco = valorRecebido - valorCompra;
        Integer resultadoBalas = 0;

        while (troco >= 0.249) {
            troco -= 0.25;
            resultadoBalas++;
        }

        return resultadoBalas;
    }



}

