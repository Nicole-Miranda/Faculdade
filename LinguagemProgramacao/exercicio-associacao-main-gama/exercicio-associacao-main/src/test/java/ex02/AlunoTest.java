package ex02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ex02.provider.CalcularMediaProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import util.EncapsulationUtil;

@DisplayName("Aluno")
public class AlunoTest {

    @Nested
    @DisplayName("Aluno 01. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<Aluno> clazz = Aluno.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("ra")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("nome")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("ativo")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("qtdMesesInadimplente")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("notas"))
            );
        }
    }

    @Nested
    @DisplayName("Aluno 02. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<Aluno> clazz = Aluno.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Atributos devem possuir getters e setters")
        void cenario2() {
            Class<Aluno> clazz = Aluno.class;
            EncapsulationUtil.validarGettersSetters(clazz);
        }
    }

    @Nested
    @DisplayName("Aluno 03. Deve possuir um construtor cheio")
    class ConstrutorTests {

        @Test
        @DisplayName("Construtor com os cinco atributos, na ordem definida no enunciado")
        void cenario1() {
            Class<Aluno> clazz = Aluno.class;

            Assertions.assertDoesNotThrow(() -> clazz.getDeclaredConstructor(
                  String.class, String.class, Boolean.class, Integer.class, List.class));
        }
    }

    @Nested
    @DisplayName("Aluno 04. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar Métodos")
        void cenario1() {
            Class<Aluno> clazz = Aluno.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularMedia"))
            );
        }
    }

    @Nested
    @DisplayName("Aluno 05. Calcular média")
    class CalcularMediaTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularMediaProvider.class)
        @DisplayName("Deve calcular a média de todas as notas (0 quando a lista estiver vazia)")
        void test1(Aluno aluno, Double esperado) throws ReflectiveOperationException {
            Method calcularMedia = Aluno.class.getDeclaredMethod("calcularMedia");

            assertEquals(esperado, calcularMedia.invoke(aluno));
        }
    }
}
