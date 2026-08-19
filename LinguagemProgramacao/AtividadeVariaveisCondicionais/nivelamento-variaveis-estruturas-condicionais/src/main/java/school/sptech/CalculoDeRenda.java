package school.sptech;

public class CalculoDeRenda {
    public static void main(String[] args) {
        Integer filhos03 = 2;
        Integer filhos416 = 3;
        Integer filhos1718 = 2;


         double filho0a3 = 25.12;
         double filho4a16 = 15.88;
         double filho17a18 = 12.44;

         double calculo = filho0a3 * filhos03 +
                 filho4a16 * filhos416 +
                 filho17a18 * filhos1718;

         int totalFilhos = filhos03 + filhos416 + filhos1718;


        System.out.printf("Você tem o total de %d filhos e vai receber R$%.2f reais de bolsa", totalFilhos, calculo);



    }
}
