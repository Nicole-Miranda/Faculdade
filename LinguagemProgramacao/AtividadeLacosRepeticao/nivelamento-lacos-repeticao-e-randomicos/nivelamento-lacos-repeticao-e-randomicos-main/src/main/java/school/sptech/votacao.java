package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class votacao {
    public static void main(String[] args) {

        int votosMussarela = 0;
        int votosCalabresa = 0;
        int votosQuatroQueijos = 0;

        for (int i = 1; i <= 10; i++) {
            int voto = ThreadLocalRandom.current().nextInt(1, 4);

            if (voto == 1) {
                votosMussarela++;
            } else if (voto == 2) {
                votosCalabresa++;
            } else if (voto == 3) {
                votosQuatroQueijos++;
            }
        }

        System.out.println("Mussarela: " + votosMussarela + " votos");
        System.out.println("Calabresa: " + votosCalabresa + " votos");
        System.out.println("Quatro Queijos: " + votosQuatroQueijos + " votos");

        if (votosMussarela > votosCalabresa && votosMussarela > votosQuatroQueijos) {
            System.out.println("O sabor favorito segundo a pesquisa é: Mussarela!");

        } else if (votosCalabresa > votosMussarela && votosCalabresa > votosQuatroQueijos) {
            System.out.println("O sabor favorito segundo a pesquisa é: Calabresa!");

        } else if (votosQuatroQueijos > votosMussarela && votosQuatroQueijos > votosCalabresa) {
            System.out.println("O sabor favorito segundo a pesquisa é: Quatro Queijos!");

        } else {
            System.out.println("Houve um empate no topo da pesquisa!");
        }
    }
    }

