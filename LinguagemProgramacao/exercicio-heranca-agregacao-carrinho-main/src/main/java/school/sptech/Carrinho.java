package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Integer id;
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        if(produto == null || produto.getPreco() == null || produto.getPreco() <= 0 || produto.getNome() == null || produto.getNome().isBlank()
                || produto.getPeso() == null || produto.getPeso() <= 0){
            return;
        }

        produtos.add(produto);
    }

    public void removerProduto(String nome){
        if(nome == null){
            return;
        }

        for(int i = produtos.size() - 1; i >= 0; i--){
            if(produtos.get(i).getNome().equalsIgnoreCase(nome)){
                produtos.remove(i);
            }
        }
    }

    public Produto buscarProdutoPorNome(String nome){
        if(nome == null){
            return null;
        }

        for(Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }

        return null;
    }

    public Double calcularValorTotal(){
        Double total = 0.0;

        for(Produto produto : produtos){
            total += produto.calcularPrecoFinal();
        }

        return total;
    }

    public Double calcularTotalFrete(){
        Double total = 0.0;

        for(Produto produto : produtos){
            total += produto.calcularFrete();
        }

        return total;
    }

    public List<Celular> buscarCelularesPorMarca(String marca){
        List<Celular> celulares = new ArrayList<>();

        if(marca == null){
            return celulares;
        }

        for(Produto produto : produtos){
            if(produto instanceof Celular){
                Celular celular = (Celular) produto;

                if(celular.getMarca() != null && celular.getMarca().equalsIgnoreCase(marca)){
                    celulares.add(celular);
                }
            }
        }

        return celulares;
    }

    public List<Celular> buscarCelularesForaDaGarantia(Integer mesesDeUso){
        List<Celular> celulares = new ArrayList<>();

        if(mesesDeUso == null){
            return celulares;
        }

        for(Produto produto : produtos){
            if(produto instanceof Celular){
                Celular celular = (Celular) produto;

                if(mesesDeUso > celular.getGarantiaMeses()){
                    celulares.add(celular);
                }
            }
        }

        return celulares;
    }

    public Produto buscarProdutoMaisBarato(){
        if(produtos.isEmpty()){
            return null;
        }

        Produto maisBarato = produtos.get(0);

        for(Produto produto : produtos){
            if(produto.calcularPrecoFinal() < maisBarato.calcularPrecoFinal()){
                maisBarato = produto;
            }
        }

        return maisBarato;
    }

    public Produto buscarProdutoMaisCaro(){
        if(produtos.isEmpty()){
            return null;
        }

        Produto maisCaro = produtos.get(0);

        for(Produto produto : produtos){
            if(produto.calcularPrecoFinal() > maisCaro.calcularPrecoFinal()){
                maisCaro = produto;
            }
        }

        return maisCaro;
    }

    public String buscarTipoProdutoMaisPresente(){
        if(produtos.isEmpty()){
            return null;
        }

        Integer qtdNormal = 0;
        Integer qtdRoupa = 0;
        Integer qtdCelular = 0;

        for(Produto produto : produtos){
            if(produto instanceof Roupa){
                qtdRoupa++;
            }else if(produto instanceof Celular){
                qtdCelular++;
            }else{
                qtdNormal++;
            }
        }

        String tipoMaisPresente = null;
        Integer maiorQuantidade = 0;

        for(Produto produto : produtos){
            if(produto instanceof Roupa){
                if(qtdRoupa > maiorQuantidade){
                    maiorQuantidade = qtdRoupa;
                    tipoMaisPresente = "roupa";
                }
            }else if(produto instanceof Celular){
                if(qtdCelular > maiorQuantidade){
                    maiorQuantidade = qtdCelular;
                    tipoMaisPresente = "celular";
                }
            }else{
                if(qtdNormal > maiorQuantidade){
                    maiorQuantidade = qtdNormal;
                    tipoMaisPresente = "normal";
                }
            }
        }

        return tipoMaisPresente;
    }

    public List<Produto> buscarTopCincoProdutosMaisBaratos(){
        if(produtos.isEmpty()){
            return null;
        }

        List<Produto> copia = new ArrayList<>(produtos);
        List<Produto> top = new ArrayList<>();

        while(top.size() < 5 && !copia.isEmpty()){
            Integer indiceMenor = 0;

            for(int i = 1; i < copia.size(); i++){
                if(copia.get(i).calcularPrecoFinal() < copia.get(indiceMenor).calcularPrecoFinal()){
                    indiceMenor = i;
                }
            }

            top.add(copia.get(indiceMenor));
            copia.remove(indiceMenor.intValue());
        }

        return top;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}