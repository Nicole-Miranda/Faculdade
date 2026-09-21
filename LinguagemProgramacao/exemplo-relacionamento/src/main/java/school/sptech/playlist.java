package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class playlist {

    private String nome;
    private usuario dono;
    private List<Musica> musica;

    public playlist(String nome, usuario dono) {
        this.nome = nome;
        this.dono = dono;
        this.musica = new ArrayList<>();
    }

    public void adicionarMusica(Musica musicas){
        if(musicas == null){
            System.out.println("Música inválida");
            return;
        }


        this.musica.add(musicas);
    }

    public void removerMusica(Musica musica){
        if(musica == null){
            System.out.println("Musica inválida");
            return;
        }

        this.musica.remove(musica);
    }

    public void removerMusica(Integer indice){
        if(indice < 0 || indice >= this.musica.size()){
            System.out.println("Música inválida");
            return;

        }
       this.musica.remove(musica);
    }



    //Campo calculado
    public Integer getDuracaoTotal(){
        Integer total = 0;

        for (Musica musica : this.musica){
            total += musica.getDuracaoMin();
        }

        return total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public usuario getDono() {
        return dono;
    }

    public void setDono(usuario dono) {
        this.dono = dono;
    }

    public List<Musica> getMusica() {
        return musica;
    }

    @Override
    public String toString() {
        return "playlist{" +
                "nome='" + nome + '\'' +
                ", dono=" + dono +
                ", musica=" + musica +
                '}';
    }
}
