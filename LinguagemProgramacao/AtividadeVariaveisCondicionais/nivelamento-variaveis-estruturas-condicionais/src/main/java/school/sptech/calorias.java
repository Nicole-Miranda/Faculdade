package school.sptech;

public class calorias {
    public static void main(String[] args) {
        Integer aquecimento = 30;
        Integer aerobicos = 40;
        Integer musculacao = 20;

        int caloriasAquecimento = 12;
        int caloriasAerobicos = 20;
        int caloriasMusculacao = 25;

        int calculoTempo = aquecimento + aerobicos + musculacao;

        int calculoCalorias = caloriasAquecimento + caloriasAerobicos + caloriasMusculacao;

        System.out.printf("Olá!. Você fez um total de %d minutos de exercícios e perdeu cerca de %d calorias", calculoTempo, calculoCalorias);
    }
}
