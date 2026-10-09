package ex01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ex01.provider.CalcularValorTotalProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import util.EncapsulationUtil;

@DisplayName("Pedido")
public class PedidoTest {

    @Nested
    @DisplayName("Pedido 01. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<Pedido> clazz = Pedido.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("codigo")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("produto")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("quantidade")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("valorUnitario")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("valorTotalComDesconto")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("itemPromocional")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("cancelado")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("pendente"))
            );
        }
    }

    @Nested
    @DisplayName("Pedido 02. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<Pedido> clazz = Pedido.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Atributos devem possuir getters e setters")
        void cenario2() {
            Class<Pedido> clazz = Pedido.class;
            EncapsulationUtil.validarGettersSetters(clazz);
        }
    }

    @Nested
    @DisplayName("Pedido 03. Deve possuir um construtor cheio")
    class ConstrutorTests {

        @Test
        @DisplayName("Construtor com os oito atributos, na ordem definida no enunciado")
        void cenario1() {
            Class<Pedido> clazz = Pedido.class;

            Assertions.assertDoesNotThrow(() -> clazz.getDeclaredConstructor(
                  String.class, String.class, Integer.class, Double.class, Double.class,
                  Boolean.class, Boolean.class, Boolean.class));
        }
    }

    @Nested
    @DisplayName("Pedido 04. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar Métodos")
        void cenario1() {
            Class<Pedido> clazz = Pedido.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularValorTotal"))
            );
        }
    }

    @Nested
    @DisplayName("Pedido 05. Calcular valor total")
    class CalcularValorTotalTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularValorTotalProvider.class)
        @DisplayName("Deve calcular valorUnitario * quantidade")
        void test1(Pedido pedido, Double esperado) throws ReflectiveOperationException {
            Method calcularValorTotal = Pedido.class.getDeclaredMethod("calcularValorTotal");

            assertEquals(esperado, calcularValorTotal.invoke(pedido));
        }
    }
}
