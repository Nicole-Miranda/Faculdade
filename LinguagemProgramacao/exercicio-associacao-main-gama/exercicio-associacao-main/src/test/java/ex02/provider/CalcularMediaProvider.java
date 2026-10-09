package ex02.provider;

import ex02.Aluno;
import ex02.factory.AlunoFactory;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CalcularMediaProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
              Arguments.of(aluno(List.of(6.0, 8.0, 10.0)), 8.0),

              Arguments.of(aluno(List.of(7.5)), 7.5),

              Arguments.of(aluno(List.of(6.5, 7.25)), 6.875),

              Arguments.of(aluno(List.of()), 0.0)
        );
    }

    private static Aluno aluno(List<Double> notas) throws ReflectiveOperationException {
        return AlunoFactory.getInstance("1", "Aluno Teste", true, 0, notas);
    }
}
