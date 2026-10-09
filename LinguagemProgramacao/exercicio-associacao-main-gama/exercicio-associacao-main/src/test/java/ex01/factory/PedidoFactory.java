package ex01.factory;

import ex01.Pedido;
import util.ObjectFieldBuilder;

public class PedidoFactory {

    public static Pedido getInstance(
          Object codigo,
          Object produto,
          Object quantidade,
          Object valorUnitario,
          Object valorTotalComDesconto,
          Object itemPromocional,
          Object cancelado,
          Object pendente
    ) throws ReflectiveOperationException {
        return new ObjectFieldBuilder<>(Pedido.class)
              .with("codigo", codigo)
              .with("produto", produto)
              .with("quantidade", quantidade)
              .with("valorUnitario", valorUnitario)
              .with("valorTotalComDesconto", valorTotalComDesconto)
              .with("itemPromocional", itemPromocional)
              .with("cancelado", cancelado)
              .with("pendente", pendente)
              .build();
    }
}
