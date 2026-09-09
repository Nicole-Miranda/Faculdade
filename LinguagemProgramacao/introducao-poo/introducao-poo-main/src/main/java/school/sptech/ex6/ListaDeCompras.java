package school.sptech.ex6;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
    String nomeLista;
    int capacidadeMaxima;
    List<String> itens = new ArrayList<>();

    public ListaDeCompras(String n, int cap) {
        nomeLista = n;
        capacidadeMaxima = cap;
    }

    void adicionarItem(String item) {
        if (itens.size() < capacidadeMaxima) {
            if (!itens.contains(item)) {
                itens.add(item);
            }
        }
    }

    boolean removerItem(String item) {
        return itens.remove(item);
    }

    String obterItem(int posicao) {
        if (posicao < 0 || posicao >= itens.size()) {
            return null;
        }
        return itens.get(posicao);
    }

    boolean substituirItem(int posicao, String novoItem) {
        if (posicao < 0 || posicao >= itens.size()) {
            return false;
        }
        if (itens.contains(novoItem)) {
            return false;
        }
        itens.set(posicao, novoItem);
        return true;
    }

    int calcularVagasRestantes() {
        return capacidadeMaxima - itens.size();
    }

    String removerItemNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= itens.size()) {
            return null;
        }
        return itens.remove(posicao);
    }

    int removerItensDuplicados() {
        List<String> listaSemRepetidos = new ArrayList<>();
        int removidos = 0;

        for (int i = 0; i < itens.size(); i++) {
            String itemAtual = itens.get(i);
            if (!listaSemRepetidos.contains(itemAtual)) {
                listaSemRepetidos.add(itemAtual);
            } else {
                removidos = removidos + 1;
            }
        }

        itens = listaSemRepetidos;
        return removidos;
    }
}
