package ex01.factory;

import ex01.Loja;
import util.ObjectFieldBuilder;

public class LojaFactory {

    public static Loja getInstance(
          Object totalPedidosRealizados,
          Object totalDescontosAplicados,
          Object totalPedidosCancelados
    ) throws ReflectiveOperationException {
        return new ObjectFieldBuilder<>(Loja.class)
              .with("totalPedidosRealizados", totalPedidosRealizados)
              .with("totalDescontosAplicados", totalDescontosAplicados)
              .with("totalPedidosCancelados", totalPedidosCancelados)
              .build();
    }
}
