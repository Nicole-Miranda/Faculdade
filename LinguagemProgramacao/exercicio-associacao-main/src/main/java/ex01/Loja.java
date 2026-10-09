package ex01;

import java.util.List;

public class Loja {

   private Integer totalPedidosRealizados;
   private Integer totalDescontosAplicados;
   private Integer totalPedidosCancelados;


   public void aplicarPromocao(Pedido pedido){
       pedido.setItemPromocional(true);
   }

   public void cancelarPedido(Pedido pedido){
       pedido.setCancelado(true);
       totalPedidosCancelados++;
   }

   public Boolean aplicarDesconto(Pedido pedido, Double porcentagem){
      if(pedido.getItemPromocional() && !pedido.getCancelado()){
          Double valorFinal = pedido.calcularValorTotal() - (pedido.calcularValorTotal() * porcentagem / 100);
          pedido.setValorTotalComDesconto(valorFinal);
          totalDescontosAplicados++;
          return true;
      }

      return false;
   }

    public boolean concluirPedido (Pedido pedido, Double pagamento) {
        if(pagamento != null && pagamento > 0.0 && !pedido.getCancelado() && pedido.getPendente()) {
            if(pedido.getItemPromocional()) {
                if(pagamento >= pedido.getValorTotalComDesconto()) {
                    pedido.setPendente(false);
                    totalPedidosRealizados++;
                    return true;
                } else {
                    return false;
                }
            } else {
                if(pagamento >= pedido.calcularValorTotal()) {
                    pedido.setPendente(false);
                    totalPedidosRealizados++;
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

  public Double calcularFaturamentoTotal(List<Pedido> pedidos){
       Double somaValorPagoPedidos = 0.0;
      for (Pedido pedido : pedidos) {
          if(!pedido.getCancelado() && !pedido.getPendente()){
              if(pedido.getItemPromocional()){
                  somaValorPagoPedidos += pedido.getValorTotalComDesconto();

              }else{
                  somaValorPagoPedidos += pedido.calcularValorTotal();
              }

          }
      }
      return somaValorPagoPedidos;
  }

  public Double calcularTicketMedio(List<Pedido> pedidos){
       Double valorTotal = 0.0;
       Integer quantidadePedidos =  0;
       Double valor = 0.0;

       if(pedidos.isEmpty()){
           return valor;
       }

      for (Pedido pedido : pedidos) {
          if(!pedido.getCancelado() && !pedido.getPendente()){
              if(pedido.getItemPromocional()){
                  valorTotal += pedido.getValorTotalComDesconto();

              }else{
                  valorTotal += pedido.calcularValorTotal();

              }

              quantidadePedidos ++;
          }
      }

      if(quantidadePedidos == 0){
          return valor;
      }else{
          return valorTotal/quantidadePedidos;

      }


  }

    public String buscarProdutoMaisVendido(List<Pedido> pedidos){
       String produtoMaisVendido = "";
       Double quantidadeTotalVendida = 0.0;

        for (Pedido pedido : pedidos) {
            if(!pedido.getCancelado() && !pedido.getPendente()){
                if(pedido.getProduto().equals(pedido)){
                    produtoMaisVendido += pedido;
                    quantidadeTotalVendida ++;

                }
            }
        }
       return produtoMaisVendido;
    }


    public String buscarPeodutosMaisVendidos(List<Pedido> pedidos){

    }
}
