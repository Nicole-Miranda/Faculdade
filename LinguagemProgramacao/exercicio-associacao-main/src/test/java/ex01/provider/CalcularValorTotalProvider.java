package ex01.provider;

import ex01.Pedido;
import ex01.factory.PedidoFactory;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalcularValorTotalProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(pedido(10.0, 5), 50.0),

              Arguments.of(pedido(99.9, 1), 99.9),

              Arguments.of(pedido(19.99, 3), 59.97),

              Arguments.of(pedido(2.5, 1000), 2500.0)
        );
    }

    private static Pedido pedido(Double valorUnitario, Integer quantidade) throws ReflectiveOperationException {
        return PedidoFactory.getInstance("P1", "Produto Teste", quantidade, valorUnitario,
              0.0, false, false, true);
    }
}
