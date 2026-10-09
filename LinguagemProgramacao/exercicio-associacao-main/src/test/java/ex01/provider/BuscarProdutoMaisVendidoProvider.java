package ex01.provider;

import ex01.Pedido;
import ex01.factory.PedidoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class BuscarProdutoMaisVendidoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(List.of(
                    pedido("Notebook", 2, false),
                    pedido("Mouse", 3, false),
                    pedido("Notebook", 3, false)
              ), "Notebook"),

              Arguments.of(List.of(
                    pedido("Teclado", 3, false),
                    pedido("Mouse", 5, false),
                    pedido("teclado", 4, false)
              ), "Teclado"),

              Arguments.of(List.of(
                    pedido("Monitor", 5, false),
                    pedido("Cadeira", 5, false)
              ), "Monitor"),

              Arguments.of(List.of(
                    pedido("Notebook", 5, true)
              ), null),

              Arguments.of(List.of(), null)
        );
    }

    private static Pedido pedido(String produto, Integer quantidade, boolean naoConcluido)
          throws ReflectiveOperationException {
        boolean cancelado = naoConcluido;
        boolean pendente = !naoConcluido ? false : true;
        return PedidoFactory.getInstance("P", produto, quantidade, 10.0, 0.0, false, cancelado,
              pendente);
    }
}
