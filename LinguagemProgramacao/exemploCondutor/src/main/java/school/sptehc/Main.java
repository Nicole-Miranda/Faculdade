package school.sptehc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> plataformas = new ArrayList<>(List.of("PS5", "Xbox Series X", "Nintendo Switch"));

        Jogo jogo = new Jogo("GTA VI", "Mundo Aberto", "Rockstar", false, plataformas);

        jogo.setPreco(600.0);
        System.out.println(jogo);
        System.out.println(jogo.getPreco());

    }

}
