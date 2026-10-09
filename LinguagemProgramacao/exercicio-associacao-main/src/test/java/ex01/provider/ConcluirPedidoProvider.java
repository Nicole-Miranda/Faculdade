package ex01.provider;

import ex01.Pedido;
import ex01.factory.PedidoFactory;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class ConcluirPedidoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(pedidoPromocional(180.0), null, false),

              Arguments.of(pedidoPromocional(180.0), 0.0, false),

              Arguments.of(pedidoPromocional(180.0), -50.0, false),

              Arguments.of(
                    PedidoFactory.getInstance("P1", "Produto Teste", 2, 100.0, 180.0, true, true, true),
                    180.0, false),

              Arguments.of(
                    PedidoFactory.getInstance("P1", "Produto Teste", 2, 100.0, 180.0, true, false, false),
                    180.0, false),

              Arguments.of(pedidoPromocional(180.0), 180.0, true),

              Arguments.of(pedidoPromocional(180.0), 200.0, true),

              Arguments.of(pedidoPromocional(180.0), 100.0, false),

              Arguments.of(pedidoSemPromocao(50.0, 2), 100.0, true),

              Arguments.of(pedidoSemPromocao(50.0, 2), 50.0, false)
        );
    }

    private static Pedido pedidoPromocional(Double valorTotalComDesconto) throws ReflectiveOperationException {
        return PedidoFactory.getInstance("P1", "Produto Teste", 2, 100.0, valorTotalComDesconto,
              true, false, true);
    }

    private static Pedido pedidoSemPromocao(Double valorUnitario, Integer quantidade)
          throws ReflectiveOperationException {
        return PedidoFactory.getInstance("P1", "Produto Teste", quantidade, valorUnitario, 0.0,
              false, false, true);
    }
}
