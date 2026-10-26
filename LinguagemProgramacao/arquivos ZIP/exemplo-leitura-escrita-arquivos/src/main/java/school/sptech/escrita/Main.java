package school.sptech.escrita;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Produto produto1 = new Produto("TV",
              2000.0, "eletronico", 10);
        Produto produto2 = new Produto("Celular",
              3000.0, "eletronico", 10);
        Produto produto3 = new Produto("Melao",
              10.0, "alimento", 20);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        Escritor escritor = new Escritor();
        escritor.escrever("teste.csv", produtos);
        System.out.println("Arquivo escrito com sucesso!");

//        Escritor escritor = new Escritor();
//        escritor.escrever("teste.txt");
    }
}
