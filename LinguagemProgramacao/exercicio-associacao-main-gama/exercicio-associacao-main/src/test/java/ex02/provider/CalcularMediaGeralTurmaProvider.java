package ex02.provider;

import ex02.Aluno;
import ex02.factory.AlunoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalcularMediaGeralTurmaProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(List.of(
                    aluno(true, List.of(8.0)),
                    aluno(true, List.of(6.0)),
                    aluno(true, List.of(10.0))
              ), 8.0),

              Arguments.of(List.of(
                    aluno(true, List.of(10.0)),
                    aluno(false, List.of(0.0))
              ), 10.0),

              Arguments.of(List.of(
                    aluno(false, List.of(10.0)),
                    aluno(false, List.of(8.0))
              ), 0.0),

              Arguments.of(List.of(), 0.0)
        );
    }

    private static Aluno aluno(Boolean ativo, List<Double> notas) throws ReflectiveOperationException {
        return AlunoFactory.getInstance("1", "Aluno Teste", ativo, 0, notas);
    }
}
