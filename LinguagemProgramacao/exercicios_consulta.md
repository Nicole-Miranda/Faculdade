# Exercícios de Java - Consulta


---

# Exercício 1 - Herança e Agregação (Carrinho)

## Enunciado (README)

# Exercício - Carrinho de Compras 🛒

## Orientações Gerais 🚨

1. Utilize **apenas** tipos **wrapper** para criar atributos e métodos.
2. **Respeite** os nomes de atributos e métodos definidos no exercício.
3. Tome **cuidado** com os **argumentos** especificados no exercício.
4. **Não adicione** argumentos não solicitados e mantenha a ordem definida no enunciado.
5. Verifique se **não há erros de compilação** no projeto antes de enviar.
6. As classes devem seguir as regras de **encapsulamento**.

---

## Diagrama de classe
![diagrama.png](diagrama.png)

## Classe: `Produto` 🪴

- Deve conter **todos** os métodos getters e setters para os atributos `preco`, `nome` e `peso`.
- Deve conter o método `toString()`.

### Métodos Públicos

- `public Double calcularFrete()`
  - Retorna o valor do frete do produto, que é R$2,00 por kg (considere que kg é a medida usada no atributo `peso`).

- `public Double calcularPrecoFinal()`
  - Retorna o preço final do produto, que é o preço do produto com frete aplicado.


## Classe: `Roupa` 👚

- Deve conter **todos** os métodos getters e setters para os atributos `tamanho`, `cor` e `material`.
- Deve conter o método `toString()`.

### Métodos Públicos

- `public Double calcularPrecoFinal()`
  - Calcula o preço final da roupa, aplicando um desconto de 15% para roupas de material "**couro**" (ignorando 
  maiúsculas ou minúsculas) ao preço final.


## Classe: `Celular` 📱

- Deve conter **todos** os métodos getters e setters para os atributos `garantiaMeses` e `marca`.
- Deve conter o método `toString()`.

### Métodos Públicos

- `public Double calcularPrecoFinal()`
  - Calcula o preço final do celular, somando 50 reais para cada mês de garantia ao preço final.

---

## Classe: `Carrinho` 🛒

- Deve conter **todos** os métodos getters e setters para os atributos da classe.

### Métodos Públicos

- `public void adicionarProduto(Produto produto)`
  - Adiciona um produto válido ao carrinho. Caso o produto seja inválido (preço nulo, igual ou menor que zero, nome 
  nulo ou com espaços vazios, peso nulo, igual ou menor que zero), não faz nada.


- `public void removerProduto(String nome)`
  - Remove todos os produtos encontrados do carrinho pesquisando por um nome (ignorando maiúsculas ou minúsculas). 
  Caso o produto não esteja presente, não faz nada.
  - Certifique-se de remover mesmo com dois produtos com mesmo nome na sequência. (Utilize o main para testar)


- `public Produto buscarProdutoPorNome(String nome)`
  - Retorna o primeiro produto com o nome especificado (ignorando maiúsculas ou minúsculas). Se o produto não for 
  encontrado, retorna `null`.


- `public Double calcularValorTotal()`
  - Calcula o valor total de todos os produtos no carrinho. Retorna a soma do preço finais de todos os produtos. Caso 
  não haja nenhum produto na lista, retorna **0.0**.


- `public Double calcularTotalFrete()`
  - Calcula o valor total de frete de todos os produtos no carrinho. Retorna a soma do frete incluso em todos os 
  produtos. Caso não haja nenhum produto na lista, retorna **0.0**.


- `public List<Celular> buscarCelularesPorMarca(String marca)`
  - Retorna uma lista de celulares do carrinho com a marca especificada (ignorando maiúsculas ou minúsculas). Filtra os 
  produtos do tipo `Celular` e compara a marca do celular com a marca passada como parâmetro, caso a lista de produtos 
  esteja vazia ou não haja nenhum celular de determinada marca, retorna uma lista vazia.


- `public List<Celular> buscarCelularesForaDaGarantia(Integer mesesDeUso)`
  - Retorna os celulares do carrinho que estão fora da garantia, onde o tempo de uso é maior que a garantia. Caso a
  lista de produtos esteja vazia ou não possua nenhum celular fora da garantia, retorna uma lista vazia. 


- `public Produto buscarProdutoMaisBarato()`
  - Retorna o produto mais barato do carrinho (considere o preço final). Caso o carrinho esteja vazio, retorna `null`.


- `public Produto buscarProdutoMaisCaro()`
  - Retorna o produto mais caro do carrinho (considere o preço final). Caso o carrinho esteja vazio, retorna `null`.

---

### Desafio ⚡

- `public String buscarTipoProdutoMaisPresente()`
  - Retorna o tipo do produto ("**normal**", "**roupa**" ou "**celular**") que mais se repete no carrinho. Caso o 
  carrinho esteja vazio retorne `null` e em caso de empate, retorne o tipo que aparece primeiro na lista.


- `public List<Produto> buscarTopCincoProdutosMaisBaratos()`
  - Retorna os 5 produtos mais baratos do carrinho, ordenados de acordo com o preço final. Caso o carrinho esteja vazio, 
  retorne `null`, em caso de empate, matenha na ordem de aparição na lista e caso o carrinho tenha menos de 5 itens, 
  retorne a lista ordenada pelo mais barato da mesma forma.
  - **Restrição**: Não é permitido usar métodos ou estruturas prontas de ordenação do Java, como Collections.sort, 
  List.sort, Arrays.sort, stream().sorted(), Comparator, Comparable etc. A ordenação e a seleção dos elementos devem 
  ser implementadas manualmente (por exemplo, com laços e comparações).

---

## Observações

- **Crie um método main dentro da classe Main para testar o funcionamento dos métodos**


## Código


### school/sptech/Carrinho.java

```java
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
```


### school/sptech/Celular.java

```java
package school.sptech;

public class Celular extends Produto {

    private Integer garantiaMeses;
    private String marca;

    @Override
    public Double calcularPrecoFinal(){
        return super.calcularPrecoFinal() + (50.0 * garantiaMeses);
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(Integer garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "garantiaMeses=" + garantiaMeses +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
```


### school/sptech/Main.java

```java
package school.sptech;

public class Main {

  public static void main(String[] args) {
    // Teste as classes aqui
  }
}
```


### school/sptech/Produto.java

```java
package school.sptech;

public class Produto {

    protected Double peso;
    protected Double preco;
    protected String nome;

    public Double calcularFrete(){
        return peso * 2.0;
    }

    public Double calcularPrecoFinal(){
        return preco + calcularFrete();
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
```


### school/sptech/Roupa.java

```java
package school.sptech;

public class Roupa extends Produto {

    private String cor;
    private Double tamanho;
    private String material;

    @Override
    public Double calcularPrecoFinal(){
        Double precoFinal = super.calcularPrecoFinal();

        if(material != null && material.equalsIgnoreCase("couro")){
            return precoFinal * 0.85;
        }

        return precoFinal;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
```


---

# Exercício 2 - Herança e Exception (Biblioteca)

## Enunciado (README)

# Exercício - Herança com Exceptions 📚

## Orientações Gerais 🚨

1. Utilize **apenas** tipos **wrapper** para criar atributos e métodos.
2. **Respeite** os nomes de atributos, classes e métodos definidos no exercício.
3. Tome **cuidado** com os **argumentos** e tipos exigidos no enunciado.
4. **Não adicione** argumentos não solicitados e mantenha a assinatura definida.
5. Verifique se **não há erros de compilação** no projeto antes de enviar.
6. As classes devem seguir as regras de **encapsulamento**.

---

## Objetivo 🎯

Implementar um sistema simples de biblioteca para praticar:

- **Herança**
- **Sobrescrita de método** (`@Override`)
- **Exceptions checked e unchecked**
- **Tratamento com `try/catch` e propagação com `throws`**

---

## Diagrama de classe
![diagrama.png](diagrama.png)


## Exceptions do Sistema ⚠️

### `DadoInvalidoException` (unchecked)

- Deve ser usada para entradas inválidas (nulas, em branco, valores não permitidos).

### `ItemNaoEncontradoException` (unchecked)

- Deve ser usada quando um item não for encontrado em busca/devolução.

### `ItemIndisponivelException` (checked)

- Deve ser usada quando tentarem emprestar um item já indisponível.

---

## Classe: `Usuario` 🙋

### Construtor

**`Usuario(String nome)`**

- Deve lançar `DadoInvalidoException` se `nome` for `null` ou em branco.

### Métodos Públicos

**Deve conter todos os Getters e Setters**

---

## Classe: `ItemBiblioteca` 📦

### Construtor

**`ItemBiblioteca(String titulo)`**

- Deve lançar `DadoInvalidoException` se `titulo` for `null` ou em branco.

### Métodos

**`void emprestar(Usuario usuario)`**

- se usuario for `null`, deve lançar `DadoInvalidoException`.
- Se o item não estiver disponível, ou seja, já emprestado para outro usuário, deve lançar `ItemIndisponivelException`.
- Caso contrário, marca o item como indisponível e registra o usuário que pegou emprestado.

**`void devolver()`**

- Marca o item como disponível, ou seja, emprestadoPara deve ser `null`.

**`Integer getPrazoEmprestimoDias()`**

- Retorna o prazo padrão de empréstimo: **7** dias.

**Deve conter todos os Getters e Setters**

---

## Classe: `Livro` 📖

### Construtor

**`Livro(String titulo, String autor)`**

- Deve lançar `DadoInvalidoException` se `autor` for `null` ou em branco.
- Deve inicializar o atributo titulo corretamente.

### Métodos

**`Integer getPrazoEmprestimoDias()`**

- Deve retornar **14** dias.

**Deve conter todos os Getters e Setters**

---

## Classe: `DVD` 💿

### Construtor

**`DVD(String titulo, Integer duracao)`**

- Deve lançar `DadoInvalidoException` se `duracao` for `null` ou menor/igual a zero.
- Deve inicializar o atributo titulo corretamente.

### Métodos Públicos

**`Integer getPrazoEmprestimoDias()`**

- Deve retornar **3** dias.

**Deve conter todos os Getters e Setters**

---

## Classe: `Biblioteca` 🏫

### Construtor

**`Biblioteca(String nome)`**

- Deve lançar `DadoInvalidoException` se `nome` for `null` ou em branco.
- Deve inicializar a lista de itens.

### Métodos Públicos

**`void adicionarItem(ItemBiblioteca item)`**

- Deve lançar `DadoInvalidoException` se `item` for `null`.
- Caso válido, adiciona na lista da biblioteca.

**`ItemBiblioteca buscarPorTitulo(String titulo)`**

- Busca item pelo título (ignorando maiúsculas/minúsculas).
- Se não encontrar, deve lançar `ItemNaoEncontradoException`.

**`void emprestarItem(String titulo, Usuario usuario)`**

- Deve lançar `DadoInvalidoException` se `titulo` ou `usuario` for `null`.
- Deve buscar o item pelo título. Se não encontrar, deve lançar `ItemNaoEncontradoException`.
- Se o item for encontrado, deve chamar o método `emprestar` do item. 
- Caso o item esteja indisponível, não deve lançar `ItemIndisponivelException`, mas sim, exibir a mensagem: "Esse item já está emprestado para outro usuário."

**`void devolverItem(String titulo)`**

- Deve lançar `DadoInvalidoException` se `titulo` for `null`.
- Deve buscar o item pelo título. Se não encontrar, deve lançar `ItemNaoEncontradoException`.
- Se o item for encontrado, deve chamar o método `devolver` do item.

**`Boolean possuiItemDisponivel(String titulo)`**

- Deve lançar `DadoInvalidoException` se `titulo` for `null` ou em branco.
- Deve buscar o item pelo título. Se não encontrar, deve lançar `ItemNaoEncontradoException`.
- Se o item for encontrado, retorna `true` caso esteja disponível e `false` caso esteja emprestado.

**`List<ItemBiblioteca> listarDisponiveis()`**

- Retorna uma **nova** lista com os itens disponíveis, ou seja, que não estão emprestados (`emprestadoPara` igual a
  `null`), mantendo a ordem de cadastro.
- Se não houver itens disponíveis, retorna uma lista vazia.

**`Integer contarPorTipo(String tipo)`**

- Deve lançar `DadoInvalidoException` se `tipo` for `null`, em branco ou diferente dos valores permitidos.
- Os valores permitidos para `tipo` são `"DVD"` ou `"Livro"`, ignorando maiúsculas/minúsculas.
- Retorna a quantidade de itens do tipo informado, independentemente de estarem disponíveis ou emprestados.
- Se não houver itens do tipo informado, retorna `0`.

**`Integer calcularPrazoMedioEmprestimo()`**

- Se não houver itens cadastrados, retorna `0`.
- Caso contrário, retorna a média dos prazos de empréstimo dos itens.

**`Integer calcularPrazoMedioPorTipo(String tipo)`**

- Deve lançar `DadoInvalidoException` se `tipo` for `null`, em branco ou diferente dos valores permitidos.
- Os valores permitidos para `tipo` são `"DVD"` ou `"Livro"`, ignorando maiúsculas/minúsculas.
- Considera **apenas** os itens do tipo informado.
- Se não houver itens cadastrados do tipo informado, retorna `0`.
- Caso contrário, retorna a média dos prazos de empréstimo dos itens do tipo informado.

**`List<ItemBiblioteca> listarEmprestadosPara(Usuario usuario)`**

- Deve lançar `DadoInvalidoException` se `usuario` for `null`.
- Retorna uma **nova** lista com os itens que estão emprestados para o usuário informado, mantendo a ordem de cadastro.
- Para saber se o item está emprestado para o mesmo usuário, deve **comparar o atributo `nome`** do `Usuario` (e não a 
referência do objeto).
- Se o usuário não tiver nenhum item emprestado, retorna uma lista vazia.

**`void devolverTodosDoUsuario(Usuario usuario)`**

- Deve lançar `DadoInvalidoException` se `usuario` for `null`.
- Deve chamar o método `devolver` de **todos** os itens que estão emprestados para o usuário informado.
- Para saber se o item está emprestado para o mesmo usuário, deve **comparar o atributo `nome`** do `Usuario` (e não a 
referência do objeto).
- Itens disponíveis ou emprestados para outros usuários **não** podem ser alterados.
- Se o usuário não tiver nenhum item emprestado, não faz nada e não lança exceção.

---

### Desafio ⚡

**`void emprestarVarios(List<String> titulos, Usuario usuario)`**

- Deve lançar `DadoInvalidoException` se:
  - `titulos` ou `usuario` for `null`, ou se `titulos` estiver vazia.
  - **qualquer** título dentro de `titulos` for `null` ou em branco.
  - `titulos` contiver títulos **duplicados**, ignorando maiúsculas/minúsculas.
- Todas as validações de `DadoInvalidoException` devem ocorrer **antes** de qualquer busca ou empréstimo, ou seja, 
nenhum item pode ser emprestado caso algum desses dados seja inválido.
- Deve buscar cada item pelo título. Se **qualquer** título não for encontrado, deve lançar `ItemNaoEncontradoException` 
e **nenhum** item pode ser emprestado.
- O empréstimo é **tudo ou nada**: se **algum** dos itens já estiver emprestado, **nenhum** item do lote pode ser 
emprestado.
- Nesse caso, não deve lançar `ItemIndisponivelException`, mas sim, exibir a mensagem: "Não foi possível emprestar o 
lote: o item '<titulo>' está indisponível.", onde `<titulo>` é o título do **primeiro** item indisponível, seguindo a 
ordem da lista `titulos`.
- Se todos os itens estiverem disponíveis, deve chamar o método `emprestar` de cada um deles com o `usuario`.

---

**Deve conter todos os Getters e Setters**


## Código


### school/sptech/Biblioteca.java

```java
package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;
import school.sptech.exceptions.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<ItemBiblioteca> itens;

    public Biblioteca(String nome) {

        if(nome == null || nome.isBlank()){
            throw new DadoInvalidoException("Nome inválido");
        }
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item){
        if(item == null){
            throw new DadoInvalidoException("dado item inválido");

        }else{
            itens.add(item);
        }
    }

    public ItemBiblioteca buscarPorTitulo(String titulo){
        if(titulo == null){
            throw new ItemNaoEncontradoException("Titulo não encontrado");
        }else{
            for (ItemBiblioteca item : itens){
                if(item.getTitulo().equalsIgnoreCase(titulo)){
                    return item;
                }
            }

            throw new ItemNaoEncontradoException("Titulo não encontrado");
        }
    }

    public void emprestarItem(String titulo, Usuario usuario) {
        if (titulo == null || usuario == null) {
            throw new DadoInvalidoException("Título ou usuário inválido.");
        }
        ItemBiblioteca item = buscarPorTitulo(titulo);
        try {
            item.emprestar(usuario);
        } catch (ItemIndisponivelException e) {
            System.out.println("Esse item já está emprestado para outro usuário.");
        }
    }

    public void devolverItem(String titulo){
        if(titulo == null){
            throw new DadoInvalidoException("titulo esta nulo");
        }
        buscarPorTitulo(titulo).devolver();
    }

    public Boolean possuiItemDisponivel(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new DadoInvalidoException("Titulo está nulo");
        }else if(buscarPorTitulo(titulo).getEmprestadoPara() == null){
            return true;
        }else{
            return false;
        }
    }

    public List<ItemBiblioteca> listarDisponiveis(){
      List<ItemBiblioteca> novaLista = new ArrayList<>();
      for(ItemBiblioteca item : itens){
          if(item.getEmprestadoPara() == null){
              novaLista.add(item);
          }
      }

      return novaLista;
    }

    public Integer contarPorTipo(String tipo){
        if(tipo == null || tipo.isBlank() || !(tipo.equalsIgnoreCase("DVD")
        || tipo.equalsIgnoreCase("LIVRO"))){
            throw new DadoInvalidoException("Titulo esta nulo ou em branco");
        }

        Integer contador = 0;

        for(ItemBiblioteca item : itens){
            if(tipo.equalsIgnoreCase("DVD") && item instanceof Dvd){
                contador ++;
            }else if(tipo.equalsIgnoreCase("Livro") && item instanceof Livro){
                contador ++;
            }
        }

        return contador;
    }

    public Integer calcularPrazoMedioEmprestimo(){
        if(itens.isEmpty()){
            return 0;
        }

        Integer contador = 0;

        for(ItemBiblioteca item : itens){
            contador += item.getPrazoEmprestimoDias();
        }

        return contador / itens.size();
    }


    public Integer calcularPrazoMedioPorTipo(String tipo){
        if(tipo == null || tipo.isBlank() || !(tipo.equalsIgnoreCase("DVD")
                || tipo.equalsIgnoreCase("Livro"))){
            throw new DadoInvalidoException("Dado inválido");
        }

        Integer contadorDVD = 0;
        Integer qtdDVD = 0;
        Integer contadoLivro = 0;
        Integer qtdLivro = 0;

        for(ItemBiblioteca item : itens){
            if(tipo.equalsIgnoreCase("DVD") && item instanceof Dvd){
                contadorDVD += item.getPrazoEmprestimoDias();
                qtdDVD ++;
            } else if(tipo.equalsIgnoreCase("Livro") && item instanceof Livro){
                contadoLivro += item.getPrazoEmprestimoDias();
                qtdLivro ++;
            }
        }

        if(tipo.equalsIgnoreCase("DVD")){
            if(qtdDVD == 0){
                return 0;
            }
            return contadorDVD/qtdDVD;
        }

            if(qtdLivro == 0){
                return 0;
            }

            return contadoLivro/qtdLivro;

    }

    public List<ItemBiblioteca> listarEmprestadosPara(Usuario usuario){
        List<ItemBiblioteca> novaLista = new ArrayList<>();
        if(usuario == null){
            throw new DadoInvalidoException("Dado inválido");
        }

        for(ItemBiblioteca item : itens){
            if(item.getEmprestadoPara() != null
                    && item.getEmprestadoPara().getNome().equals(usuario.getNome())){
                novaLista.add(item);
            }
        }
            return novaLista;
    }


    public void devolverTodosDoUsuario(Usuario usuario){
        if(usuario == null){
            throw new DadoInvalidoException("Usuário inválido");
        }

        for(ItemBiblioteca item : itens){
            if(item.getEmprestadoPara() != null
                    && item.getEmprestadoPara().getNome().equals(usuario.getNome())){
                item.devolver();
            }
        }
    }


    public void emprestarVarios(List<String> titulos, Usuario usuario){
        if(titulos == null || usuario == null || titulos.isEmpty()){
            throw new DadoInvalidoException("Dado inválido");
        }

        List<String> titulosVistos = new ArrayList<>();

        for(String titulo : titulos){
            if(titulo == null || titulo.isBlank()){
                throw new DadoInvalidoException("Título inválido");
            }
            if(titulosVistos.contains(titulo.toLowerCase())){
                throw new DadoInvalidoException("Título duplicado");
            }
            titulosVistos.add(titulo.toLowerCase());
        }

        List<ItemBiblioteca> lote = new ArrayList<>();

        for(String titulo : titulos){
            lote.add(buscarPorTitulo(titulo));
        }

        for(ItemBiblioteca item : lote){
            if(item.getEmprestadoPara() != null){
                System.out.println("Não foi possível emprestar o lote: o item '"
                        + item.getTitulo() + "' está indisponível.");
                return;
            }
        }

        for(ItemBiblioteca item : lote){
            try {
                item.emprestar(usuario);
            } catch (ItemIndisponivelException e) {
                System.out.println("Esse item já está emprestado para outro usuário");
            }
        }
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemBiblioteca> getItens() {
        return itens;
    }

    public void setItens(List<ItemBiblioteca> itens) {
        this.itens = itens;
    }
}
```


### school/sptech/Dvd.java

```java
package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;

public class Dvd extends ItemBiblioteca{

    private Integer duracao;

    public Dvd(String titulo, Integer duracao) {
        super(titulo);
        if(duracao == null || duracao <= 0){
            throw new DadoInvalidoException("Dado duracao esta inválido!");
        }
        this.duracao = duracao;
    }

    public Integer getPrazoEmprestimoDias(){
        return 3;
    }


    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
```


### school/sptech/ItemBiblioteca.java

```java
package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;

public class ItemBiblioteca {

    private String titulo;
    private Usuario emprestadoPara;

    public ItemBiblioteca(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new DadoInvalidoException("O dado do Titulo está inválido!");
        }
        this.titulo = titulo;
    }


    public void emprestar(Usuario usuario) throws ItemIndisponivelException{
        if (usuario == null) {
            throw new DadoInvalidoException("O dado do usuário está inválido!");
        }if (emprestadoPara != null ) {
            throw new ItemIndisponivelException("O item está emprestado para outra pessoa");
        }

        emprestadoPara = usuario;
    }

    public void devolver(){

        emprestadoPara = null;
    }

    public Integer getPrazoEmprestimoDias(){
       return 7;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    public void setEmprestadoPara(Usuario emprestadoPara) {
        this.emprestadoPara = emprestadoPara;
    }
}
```


### school/sptech/Livro.java

```java
package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;

public class Livro extends ItemBiblioteca{

    private String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        if(autor == null || autor.isBlank()){
            throw new DadoInvalidoException("O dado do autor está inválido");
        }

        this.autor = autor;
    }

    public Integer getPrazoEmprestimoDias(){
        return 14;
    }



    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
```


### school/sptech/Main.java

```java
package school.sptech;

public class Main {

  public static void main(String[] args) {

  }
}
```


### school/sptech/Usuario.java

```java
package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;

public class Usuario {

    private String nome;

    public Usuario(String nome) {
        if(nome == null || nome.isBlank()){
            throw new DadoInvalidoException("O dado do nome está nulo");
        }
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```


### school/sptech/exceptions/DadoInvalidoException.java

```java
package school.sptech.exceptions;

public class DadoInvalidoException extends RuntimeException {

    public DadoInvalidoException(String message) {
        super(message);
    }
}
```


### school/sptech/exceptions/ItemIndisponivelException.java

```java
package school.sptech.exceptions;

public class ItemIndisponivelException extends Exception {

    public ItemIndisponivelException(String message) {
        super(message);
    }
}
```


### school/sptech/exceptions/ItemNaoEncontradoException.java

```java
package school.sptech.exceptions;

public class ItemNaoEncontradoException extends RuntimeException{

    public ItemNaoEncontradoException(String message) {
        super(message);
    }

}
```
