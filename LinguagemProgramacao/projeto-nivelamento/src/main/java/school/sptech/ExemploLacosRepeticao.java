package school.sptech;

public class ExemploLacosRepeticao {
    public static void main(String[] args) {
        //for, while
        for(int i = 0; i < 10; i++){
            System.out.println("Número dentro do for:" + i);
        }

        int num = 10;
        while(num < 10){
            System.out.println("Número dentro do while:" + num);
            num++;
        }

        // do-while
        int numDoWhile = 11;
        do{
            System.out.println("Número dentro do Dowhile:" + numDoWhile);
            numDoWhile++;
        } while(numDoWhile < 10);
    }
}
