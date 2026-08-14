package school.sptech;

public class Condicionais {
    public static void main(String[] args) {
        //if,else,else-if
        Integer idade = 18;

          if (idade <= 18){
            System.out.println("Você é menor de idade, não pode dirigir e votar");
        } else if (idade >= 16){
            System.out.println("Você é menor de idade, pode votar, mas não dirigir");
        } else{
            System.out.println("Você é menor de idade, não pode votar e nem dirigir");
        }

          // Operador ternário
        //String texto = "";
          //String = idade >= 18 ? "Maior de idade" : "Menor de idade";
        //if (idade < 18){
          // texto = "Você é maior de idade";
       // }

        // Toda vez que for comparar igualdade com tipo wrapper use .equals()
          Integer num1 = 1000;
          Integer num2 = 1000;

          if (num1.equals(num2)){
              System.out.println("São iguais!");
          } else{
              System.out.println("São diferentes!");
          }

          String nome = "Lucas";
          String nome2 = "lucas";

        if (nome.equalsIgnoreCase(nome2)){
            System.out.println("São iguais!");
        } else{
            System.out.println("São diferentes!");
        }

    }
}
