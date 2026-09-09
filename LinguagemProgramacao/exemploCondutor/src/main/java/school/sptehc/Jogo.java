package school.sptehc;

import java.util.List;

public class Jogo {
    /*
    private -> -
    protected -> #
    default -> ~
    public -> +
     */
    private String nome;
    private String genero;
    private String desenvolvedora;
    private Boolean temMidiaFisica;
    private Double preco;
    private List<String> plataformas;

    Jogo() {}

    public Jogo(String nome) {
        this.nome = nome;
    }

    public Jogo(String nome, String genero, String desenvolvedora, Boolean temMidiaFisica, List<String> plataformas){
        this.nome = nome;
        this.genero = genero;
        this.desenvolvedora = desenvolvedora;
        this.temMidiaFisica = temMidiaFisica;
        this.plataformas = plataformas;
    }

    public Jogo(String nome, String genero, String desenvolvedora, Boolean temMidiaFisica){

    }

    // chamado de setter
    public void setPreco(Double preco){
        if (preco <= 0.0){
            System.out.println("Preco invalido");
            return;
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", desenvolvedora='" + desenvolvedora + '\'' +
                ", temMidiaFisica=" + temMidiaFisica +
                ", preco=" + preco +
                ", plataformas=" + plataformas +
                '}';
    }

    // chamado de getter
    public Double getPreco(){
        return this.preco;
    }


}