package school.sptech;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        usuario usuario = new usuario(
                "Nicole Miranda",
                LocalDate.of(2006, 8, 4),
                "nicole.miranda@gmail.com",
                "12345678910"
        );

        Musica musica02 = new Musica(

                "Yound and Beautiful",
                "Lana Del Rey",
                4,
                2013

        );

        playlist playlist = new playlist("As melhores do CCOA", usuario);

        playlist.adicionarMusica(musica02);
        System.out.println(playlist);

        playlist.removerMusica(musica02);
        System.out.println(playlist);


    }

}