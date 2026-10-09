package org.example;

import java.util.Objects;



public class Produtos {
    private String nome;
    private Double preco;
    private Integer qtd;

    public Produtos(String nome, Double preco, Integer qtd) {
        this.nome = Objects.requireNonNull(nome,"Nome não pode ser nulo");
        this.preco = preco;
        this.qtd = qtd;
    }


}
