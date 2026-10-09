package ex02.provider;

import ex02.Aluno;
import ex02.factory.AlunoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalcularPercentualInadimplenciaProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(List.of(aluno(0), aluno(0)), 0.0),

              Arguments.of(List.of(aluno(1), aluno(2)), 100.0),

              Arguments.of(List.of(aluno(0), aluno(1), aluno(0), aluno(3)), 50.0),

              Arguments.of(List.of(), 0.0)
        );
    }

    private static Aluno aluno(Integer qtdMesesInadimplente) throws ReflectiveOperationException {
        return AlunoFactory.getInstance("1", "Aluno Teste", true, qtdMesesInadimplente,
              List.of(8.0));
    }
}
