package school.sptech;

public class Interpolacao {
    public static void main(String[] args) {
        Integer idade = 10;
        String nome = "Giuliana";
        Double altura = 1.5;
        String texto = "Meu nome é %s e minha idade é %d e minha altura é (talvez seja) %.2f "
                .formatted(nome, idade, altura);

        String texto2 = String.format("Meu nome é %s e minha idade " +
                "é %d e minha altura é (talvez seja) %.2f ", nome, idade, altura);

        System.out.println("Texto usando .formatted");
        System.out.println(texto);
        System.out.println("Texto usando String .format()");
        System.out.println(texto2);
        System.out.println("Texto usando String printf");
        System.out.printf("Meu nome é %s e minha idade " +
                "é %d e minha altura é (talvez seja) %.2f", nome, idade, altura);


        String textao = "\nMeu nome é %s \ne minha idade é %d \ne minha altura é (talvez seja) %.2f "
                .formatted(nome, idade, altura);
        System.out.println(textao);

    }
}
