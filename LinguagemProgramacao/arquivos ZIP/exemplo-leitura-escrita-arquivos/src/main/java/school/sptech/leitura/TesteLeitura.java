package school.sptech.leitura;

import java.util.List;

public class TesteLeitura {

    public static void main(String[] args) {
        Leitor leitor = new Leitor();
        leitor.ler("teste.txt");
        System.out.println("Arquivo lido");

        List<Livro> livrosLidos =
              leitor.importarLivros("base-dados-livro.csv");

        for (Livro livrosLido : livrosLidos) {
            System.out.println(livrosLido);
        }
    }
}
