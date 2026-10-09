package ex02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ex02.factory.AlunoFactory;
import ex02.factory.SecretariaFactory;
import ex02.provider.CalcularDesvioPadraoTurmaProvider;
import ex02.provider.CalcularMediaGeralTurmaProvider;
import ex02.provider.CalcularPercentualInadimplenciaProvider;
import ex02.provider.RegistraCancelamentoProvider;
import ex02.provider.VerificaAprovacaoAlunoProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import util.EncapsulationUtil;

@DisplayName("Secretaria")
public class SecretariaTest {

    private static Object campo(Object instancia, String nomeCampo)
          throws ReflectiveOperationException {
        Field field = instancia.getClass().getDeclaredField(nomeCampo);
        field.trySetAccessible();
        return field.get(instancia);
    }

    @Nested
    @DisplayName("Secretaria 01. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<Secretaria> clazz = Secretaria.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalInadimplentes")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalCancelamentos")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalPagamentos"))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 02. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<Secretaria> clazz = Secretaria.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Atributos devem possuir getters (somente getters)")
        void cenario2() {
            Class<Secretaria> clazz = Secretaria.class;
            EncapsulationUtil.validarGettersSettersExcetoSetters(clazz,
                  "totalInadimplentes", "totalCancelamentos", "totalPagamentos");
        }

        @Test
        @DisplayName("Nenhum dos contadores deve conter setter")
        void cenario3() {
            Class<Secretaria> clazz = Secretaria.class;
            List<String> camposSemSetter = List.of("totalInadimplentes", "totalCancelamentos",
                  "totalPagamentos");

            Stream<Executable> validacoes = camposSemSetter.stream()
                  .map((nomeCampo) -> () -> {
                      Field field = clazz.getDeclaredField(nomeCampo);
                      String setName = String.format("set%s",
                            StringUtils.capitalize(field.getName()));

                      Assertions.assertThrows(NoSuchMethodException.class, () -> {
                          clazz.getDeclaredMethod(setName, field.getType());
                      });
                  });

            Assertions.assertAll(validacoes);
        }
    }

    @Nested
    @DisplayName("Secretaria 03. O construtor vazio deve zerar os contadores")
    class ConstrutorTests {

        @Test
        @DisplayName("Único Cenário")
        void cenario1() throws ReflectiveOperationException {
            Class<Secretaria> clazz = Secretaria.class;

            Constructor<Secretaria> constructor = clazz.getDeclaredConstructor();
            Secretaria secretaria = constructor.newInstance();

            Assertions.assertAll(
                  () -> assertEquals(0, campo(secretaria, "totalInadimplentes")),
                  () -> assertEquals(0, campo(secretaria, "totalCancelamentos")),
                  () -> assertEquals(0, campo(secretaria, "totalPagamentos"))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 04. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar Métodos")
        void cenario1() {
            Class<Secretaria> clazz = Secretaria.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("registraPagamento", Aluno.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("registraInadimplencia", Aluno.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("registraCancelamento", Aluno.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("verificaAprovacaoAluno", Aluno.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularMediaGeralTurma", List.class)),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredMethod(
                        "calcularPercentualInadimplencia", List.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularDesvioPadraoTurma", List.class))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 05. Registrar pagamento")
    class RegistraPagamentoTests {

        @Test
        @DisplayName("Deve zerar qtdMesesInadimplente e incrementar totalPagamentos")
        void test1() throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);
            Aluno aluno = AlunoFactory.getInstance("1", "Aluno Teste", true, 3, List.of(8.0));

            Method registraPagamento = Secretaria.class.getDeclaredMethod("registraPagamento",
                  Aluno.class);
            registraPagamento.invoke(secretaria, aluno);

            Assertions.assertAll(
                  () -> assertEquals(0, campo(aluno, "qtdMesesInadimplente")),
                  () -> assertEquals(1, campo(secretaria, "totalPagamentos"))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 06. Registrar inadimplência")
    class RegistraInadimplenciaTests {

        @Test
        @DisplayName("Deve somar um mês a qtdMesesInadimplente e incrementar totalInadimplentes")
        void test1() throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);
            Aluno aluno = AlunoFactory.getInstance("1", "Aluno Teste", true, 2, List.of(8.0));

            Method registraInadimplencia = Secretaria.class.getDeclaredMethod(
                  "registraInadimplencia", Aluno.class);
            registraInadimplencia.invoke(secretaria, aluno);

            Assertions.assertAll(
                  () -> assertEquals(3, campo(aluno, "qtdMesesInadimplente")),
                  () -> assertEquals(1, campo(secretaria, "totalInadimplentes"))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 07. Registrar cancelamento")
    class RegistraCancelamentoTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(RegistraCancelamentoProvider.class)
        @DisplayName("Só cancela quando qtdMesesInadimplente for pelo menos 3")
        void test1(Aluno aluno, Boolean resultadoEsperado, Boolean ativoEsperadoDepois)
              throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);

            Method registraCancelamento = Secretaria.class.getDeclaredMethod(
                  "registraCancelamento", Aluno.class);

            Object resultado = registraCancelamento.invoke(secretaria, aluno);

            Assertions.assertAll(
                  () -> assertEquals(resultadoEsperado, resultado),
                  () -> assertEquals(ativoEsperadoDepois, campo(aluno, "ativo")),
                  () -> assertEquals(resultadoEsperado ? 1 : 0,
                        campo(secretaria, "totalCancelamentos"))
            );
        }
    }

    @Nested
    @DisplayName("Secretaria 08. Verificar aprovação do aluno")
    class VerificaAprovacaoAlunoTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(VerificaAprovacaoAlunoProvider.class)
        @DisplayName("Aprovado somente se ativo, adimplente e com média maior ou igual a 6")
        void test1(Aluno aluno, Boolean esperado) throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);

            Method verificaAprovacaoAluno = Secretaria.class.getDeclaredMethod(
                  "verificaAprovacaoAluno", Aluno.class);

            assertEquals(esperado, verificaAprovacaoAluno.invoke(secretaria, aluno));
        }
    }

    @Nested
    @DisplayName("Secretaria 09. Calcular média geral da turma")
    class CalcularMediaGeralTurmaTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularMediaGeralTurmaProvider.class)
        @DisplayName("Deve calcular a média das médias somente dos alunos ativos")
        void test1(List<Aluno> alunos, Double esperado) throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);

            Method calcularMediaGeralTurma = Secretaria.class.getDeclaredMethod(
                  "calcularMediaGeralTurma", List.class);

            assertEquals(esperado, calcularMediaGeralTurma.invoke(secretaria, alunos));
        }
    }

    @Nested
    @DisplayName("Secretaria 10. Calcular percentual de inadimplência")
    class CalcularPercentualInadimplenciaTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularPercentualInadimplenciaProvider.class)
        @DisplayName("Deve calcular o percentual de alunos com qtdMesesInadimplente maior que 0")
        void test1(List<Aluno> alunos, Double esperado) throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);

            Method calcularPercentualInadimplencia = Secretaria.class.getDeclaredMethod(
                  "calcularPercentualInadimplencia", List.class);

            assertEquals(esperado, calcularPercentualInadimplencia.invoke(secretaria, alunos));
        }
    }

    @Nested
    @DisplayName("Secretaria 11. 🏆 Desafio: Calcular desvio padrão da turma")
    class CalcularDesvioPadraoTurmaTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularDesvioPadraoTurmaProvider.class)
        @DisplayName("Deve calcular o desvio padrão das médias dos alunos ativos")
        void test1(List<Aluno> alunos, Double esperado) throws ReflectiveOperationException {
            Secretaria secretaria = SecretariaFactory.getInstance(0, 0, 0);

            Method calcularDesvioPadraoTurma = Secretaria.class.getDeclaredMethod(
                  "calcularDesvioPadraoTurma", List.class);

            assertEquals(esperado, calcularDesvioPadraoTurma.invoke(secretaria, alunos));
        }
    }
}
