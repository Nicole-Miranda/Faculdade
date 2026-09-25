package school.sptech.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private String cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Integer getQuantidade() {
        return produtos.size();
    }

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }

    public Boolean existsPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            if (p.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public Integer getQuantidadePorCategoria(String nome) {
        int contador = 0;

        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);

            if (p.getCategoria() != null && p.getCategoria().equalsIgnoreCase(nome)) {
                contador++;
            }
        }

        return contador;
    }

    public void limpar() {
        produtos.clear();
    }

    public void removerPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            if (p.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                return;
            }
        }
    }

    public Produto getPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public Double getValorTotal() {
        double total = 0.0;

        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            total += p.getPreco();
        }

        return total;
    }
}