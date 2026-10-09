package ex02.provider;

import ex02.Aluno;
import ex02.factory.AlunoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class RegistraCancelamentoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(aluno(0), false, true),

              Arguments.of(aluno(1), false, true),

              Arguments.of(aluno(2), false, true),

              Arguments.of(aluno(3), true, false),

              Arguments.of(aluno(4), true, false),

              Arguments.of(aluno(10), true, false)
        );
    }

    private static Aluno aluno(Integer qtdMesesInadimplente) throws ReflectiveOperationException {
        return AlunoFactory.getInstance("1", "Aluno Teste", true, qtdMesesInadimplente,
              List.of(8.0));
    }
}
