package ex01;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private Integer totalPedidosRealizados;
    private Integer totalDescontosAplicados;
    private Integer totalPedidosCancelados;


    public Loja() {
        this.totalPedidosRealizados = 0;
        this.totalDescontosAplicados = 0;
        this.totalPedidosCancelados = 0;
    }

    public Integer getTotalPedidosRealizados() {
        return totalPedidosRealizados;
    }

    public Integer getTotalDescontosAplicados() {
        return totalDescontosAplicados;
    }

    public Integer getTotalPedidosCancelados() {
        return totalPedidosCancelados;
    }

    public void aplicarPromocao(Pedido pedido) {
        pedido.setItemPromocional(true);
    }

    public void cancelarPedido(Pedido pedido) {
        pedido.setCancelado(true);
        totalPedidosCancelados++;
    }

    public boolean aplicarDesconto(Pedido pedido, Double porcentagem) {
        if(pedido.getItemPromocional() && !pedido.getCancelado()) {
            Double resultado = pedido.calcularValorTotal() - pedido.calcularValorTotal() * (porcentagem / 100);
            pedido.setValorTotalComDesconto(resultado);
            totalDescontosAplicados++;
            return true;
        } else {
            return false;
        }
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

    public Double calcularFaturamentoTotal(List<Pedido> pedidos) {
        Double somaValores = 0.0;
        for (Pedido pedido : pedidos) {
            if(!pedido.getCancelado() && !pedido.getPendente()) {
                if(pedido.getItemPromocional()) {
                    somaValores += pedido.getValorTotalComDesconto();
                } else {
                    somaValores += pedido.calcularValorTotal();
                }
            }
        }
        return somaValores;
    }

    public Double calcularTicketMedio(List<Pedido> pedidos) {
        Double ValorTotal = 0.0;
        Double qtdPedidoConcluido = 0.0;
        if (pedidos.isEmpty()) {
            return ValorTotal;
        }
        for (Pedido pedido : pedidos) {
            if(!pedido.getCancelado() && !pedido.getPendente()) {
                if(pedido.getItemPromocional()) {
                    ValorTotal += pedido.getValorTotalComDesconto();
                } else {
                    ValorTotal += pedido.calcularValorTotal();
                }
                qtdPedidoConcluido++;
            }
        }

        if (qtdPedidoConcluido == 0) {
            return ValorTotal;
        } else {
            return ValorTotal / qtdPedidoConcluido;
        }
    }

    public String buscarProdutoMaisVendido(List<Pedido> pedidos) {
        Double SomaValor = 0.0;
        String nome = "";

        for (Pedido pedido : pedidos) {
            List<Pedido> pedidoEsp = new ArrayList<>();
            for (Pedido item : pedidos) {
                if (item.getProduto().equalsIgnoreCase(pedido.getProduto())) {
                    pedidoEsp.add(item);
                }
            }
            if (calcularFaturamentoTotal(pedidoEsp) > SomaValor) {
                nome = pedido.getProduto();
                SomaValor = calcularFaturamentoTotal(pedidoEsp);
            }
        }

        if(pedidos.isEmpty() || SomaValor <= 0.0) {
            return null;
        }
        return nome;
    }

}
