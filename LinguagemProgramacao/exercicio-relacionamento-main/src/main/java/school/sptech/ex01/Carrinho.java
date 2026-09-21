package school.sptech.ex01;

import java.util.List;

public class Carrinho {

    private String cliente;
    private List<Produto> produtos;

    public Integer getQuantidade(){
    return produtos.size();
    }

    public void adicionar(Produto produtos){

        this.produtos.add(produtos);
    }

    public Boolean existsPorNome(String nome){

        for (int i = 0; i < produtos.size(); i++) {
          Produto p = produtos.get(i);
          if(p.getNome().toLowerCase().equals(nome.toLowerCase())){
              return true;
          }
        }

        return false;
    }

    public Integer getQuantidadePorCategoria(String nome){
        int contador = 0;

        for (int i = 0; i < produtos.size(); i++){
            Produto p = produtos.get(i);

            if (p.getCategoria() != null && p.getCategoria().getNome().equalsIgnoreCase(nome)){
                
            }
        }
    }

}
