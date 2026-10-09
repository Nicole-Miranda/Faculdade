package ex02.factory;

import ex02.Secretaria;
import util.ObjectFieldBuilder;

public class SecretariaFactory {

    public static Secretaria getInstance(
          Object totalInadimplentes,
          Object totalCancelamentos,
          Object totalPagamentos
    ) throws ReflectiveOperationException {
        return new ObjectFieldBuilder<>(Secretaria.class)
              .with("totalInadimplentes", totalInadimplentes)
              .with("totalCancelamentos", totalCancelamentos)
              .with("totalPagamentos", totalPagamentos)
              .build();
    }
}
