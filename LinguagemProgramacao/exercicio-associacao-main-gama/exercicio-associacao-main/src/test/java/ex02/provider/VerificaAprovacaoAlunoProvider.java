package ex02.provider;

import ex02.Aluno;
import ex02.factory.AlunoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class VerificaAprovacaoAlunoProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(aluno(false, 0, List.of(8.0)), false),

              Arguments.of(aluno(true, 1, List.of(8.0)), false),

              Arguments.of(aluno(true, 0, List.of(4.0, 5.0)), false),

              Arguments.of(aluno(true, 0, List.of(6.0)), true),

              Arguments.of(aluno(true, 0, List.of(9.0, 10.0)), true)
        );
    }

    private static Aluno aluno(Boolean ativo, Integer qtdMesesInadimplente, List<Double> notas)
          throws ReflectiveOperationException {
        return AlunoFactory.getInstance("1", "Aluno Teste", ativo, qtdMesesInadimplente, notas);
    }
}
