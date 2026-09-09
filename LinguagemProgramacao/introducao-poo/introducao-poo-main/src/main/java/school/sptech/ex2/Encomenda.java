package school.sptech.ex2;

// |

public class Encomenda {

    String tamanho;
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorProduto;

    Double calcularFrete(){
        Double valorFinal = 0.0;
      if(tamanho.equals("P")){
          valorFinal += valorProduto  * 0.01;
      } else if (tamanho.equals("M")) {
          valorFinal += valorProduto * 0.03;
      } else if (tamanho.equals("G")) {
          valorFinal += valorProduto * 0.05;
      }
        Double frete = 0.0;
      if(distancia <= 50){
          frete += valorFinal + 3;
      } else if (distancia <= 200) {
          frete += valorFinal + 5;

      } else if (distancia > 200) {
          frete += valorFinal + 7;

      }

     return frete;
    }

    void aplicarCupomDeDesconto(Integer desconto){

        Double valorDesconto = 0.0;
        //Double valorFinal = 0.0;
        valorDesconto = (valorProduto * desconto)/100;

        valorProduto -= valorDesconto;

        return;

    }

    Double valorTotalDaEncomenda(){
        Double frete = calcularFrete();
        return valorProduto += frete;
    }




}
