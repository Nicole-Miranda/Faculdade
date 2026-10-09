package ex01.provider;

import ex01.Pedido;
import ex01.factory.PedidoFactory;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class AplicarDescontoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(
                    pedido(100.0, 2, true, false),
                    10.0, true, 180.0),

              Arguments.of(
                    pedido(50.0, 10, true, false),
                    50.0, true, 250.0),

              Arguments.of(
                    pedido(30.0, 10, true, false),
                    100.0, true, 0.0),

              Arguments.of(
                    pedido(100.0, 2, false, false),
                    20.0, false, 0.0),

              Arguments.of(
                    pedido(100.0, 2, true, true),
                    20.0, false, 0.0)
        );
    }

    private static Pedido pedido(Double valorUnitario, Integer quantidade, Boolean itemPromocional,
          Boolean cancelado) throws ReflectiveOperationException {
        return PedidoFactory.getInstance("P1", "Produto Teste", quantidade, valorUnitario,
              0.0, itemPromocional, cancelado, true);
    }
}
