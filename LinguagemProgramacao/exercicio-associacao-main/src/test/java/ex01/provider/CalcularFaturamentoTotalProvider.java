package ex01.provider;

import ex01.Pedido;
import ex01.factory.PedidoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalcularFaturamentoTotalProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Pedido concluidoComDesconto = pedido("P1", 2, 100.0, 180.0, true, false, false);
        Pedido concluidoSemDesconto = pedido("P2", 2, 50.0, 0.0, false, false, false);
        Pedido cancelado = pedido("P3", 1, 500.0, 0.0, false, true, false);
        Pedido pendente = pedido("P4", 1, 300.0, 0.0, false, false, true);

        return Stream.of(
              Arguments.of(
                    List.of(concluidoComDesconto, concluidoSemDesconto, cancelado, pendente),
                    280.0),

              Arguments.of(List.of(), 0.0),

              Arguments.of(List.of(cancelado, pendente), 0.0),

              Arguments.of(List.of(concluidoComDesconto), 180.0)
        );
    }

    private static Pedido pedido(String codigo, Integer quantidade, Double valorUnitario,
          Double valorTotalComDesconto, Boolean itemPromocional, Boolean cancelado, Boolean pendente)
          throws ReflectiveOperationException {
        return PedidoFactory.getInstance(codigo, "Produto Teste", quantidade, valorUnitario,
              valorTotalComDesconto, itemPromocional, cancelado, pendente);
    }
}
