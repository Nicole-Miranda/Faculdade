package schoo.sptech;

public class TestarCarro {
    public static void main(String[] args) {
        Carro carro = new  Carro(); // instÂncia do objeto
        carro.ano = 1972;
        carro.marca = "Fiat";
        carro.modelo = "Punto";
        carro.kmRodado = 10000;

        Carro carro2 = new Carro(); // Instancia do segundo objeto
        carro2.ano = 2003;
        carro2.marca = "VVV";
        carro2.modelo = "Polo";
        carro2.kmRodado = informarKM();

        System.out.println(carro2.ligado());
        System.out.println(carro2.modelo);

        if(carro2.ligado()){
            System.out.println(carro2.modelo + " EstÁ ligado\n");
            System.out.println(carro2.kmRodado + "Km rodados");
        }

    }

    static int informarKM(){
        int km = 15000;
        return km;
    }
}
