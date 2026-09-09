package school.sptech;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import school.sptech.util.ObjectFieldBuilder;

@DisplayName("Ônibus")
public class OnibusTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<Onibus> clazz = Onibus.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("qtdPassageiros")),
                  () -> Assertions.assertDoesNotThrow(() -> clazz.getDeclaredField("valorPassagem"))
            );
        }
    }

    @Nested
    @DisplayName("2. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar métodos")
        void validarMetodos() {
            Class<Onibus> clazz = Onibus.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(() ->
                        clazz.getDeclaredMethod("cobrarPassagem", BilheteUnico.class)),
                  () -> Assertions.assertDoesNotThrow(() ->
                        clazz.getDeclaredMethod("cobrarPassagem", Double.class))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<Onibus> clazz = Onibus.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Métodos públicos")
        void cenario2() throws ReflectiveOperationException {
            Class<Onibus> clazz = Onibus.class;
            Method cobrarPassagem = clazz.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);
            Method cobrarPassagem2 = clazz.getDeclaredMethod("cobrarPassagem", Double.class);

            Assertions.assertAll(
                  () -> Assertions.assertTrue(Modifier.isPublic(cobrarPassagem.getModifiers())),
                  () -> Assertions.assertTrue(Modifier.isPublic(cobrarPassagem2.getModifiers()))
            );
        }

        @Test
        @DisplayName("Atributos devem possuir getters e não possuir setters")
        void cenario3() {
            Class<Onibus> clazz = Onibus.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoesGetter = Arrays.stream(campos)
                  .map((campo) -> () -> {
                      String getName = String.format("get%s",
                            StringUtils.capitalize(campo.getName()));
                      Method getter = clazz.getDeclaredMethod(getName);
                      int getModifier = getter.getModifiers();
                      Assertions.assertTrue(Modifier.isPublic(getModifier));
                  });

            Stream<Executable> validacoesSetter = Arrays.stream(campos)
                  .map((campo) -> () -> {
                      String setName = String.format("set%s",
                            StringUtils.capitalize(campo.getName()));
                      Assertions.assertThrows(NoSuchMethodException.class,
                            () -> clazz.getDeclaredMethod(setName, campo.getType()));
                  });

            Assertions.assertAll(Stream.concat(validacoesGetter, validacoesSetter));
        }
    }

    @Nested
    @DisplayName("4. Método - cobrarPassagem - bilhete")
    class MetodoCobrarPassagemBilheteTests {

        Map<String, Field> campos() throws ReflectiveOperationException {
            Class<Onibus> clazz = Onibus.class;

            Field qtdPassageiros = clazz.getDeclaredField("qtdPassageiros");
            qtdPassageiros.trySetAccessible();

            Field valorPassagem = clazz.getDeclaredField("valorPassagem");
            valorPassagem.trySetAccessible();

            return Map.of("qtdPassageiros", qtdPassageiros, "valorPassagem", valorPassagem);
        }

        Map<String, Field> camposBilhete() throws ReflectiveOperationException {
            Class<BilheteUnico> clazz = BilheteUnico.class;

            Field titular = clazz.getDeclaredField("titular");
            titular.trySetAccessible();

            Field ano = clazz.getDeclaredField("ano");
            ano.trySetAccessible();

            Field estudante = clazz.getDeclaredField("estudante");
            estudante.trySetAccessible();

            Field saldo = clazz.getDeclaredField("saldo");
            saldo.trySetAccessible();

            Field bloqueado = clazz.getDeclaredField("bloqueado");
            bloqueado.trySetAccessible();

            return Map.of(
                  "titular", titular,
                  "ano", ano,
                  "estudante", estudante,
                  "saldo", saldo,
                  "bloqueado", bloqueado);
        }

        @Test
        @DisplayName("Cenário 1")
        void cenario1() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 0)
                  .with("valorPassagem", 5.0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Paulo Muniz")
                  .with("ano", 2019)
                  .with("estudante", false)
                  .with("saldo", 200.0)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(195.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico), 0.01),
                  () -> Assertions.assertEquals(1, campos().get("qtdPassageiros").get(obj))
            );
        }

        @ParameterizedTest
        @ValueSource(doubles = {10.0, 8.0, 4.40, 4.41})
        @DisplayName("Cenário 2")
        void cenario2(double saldo) throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 55)
                  .with("valorPassagem", 4.40)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "William Marques")
                  .with("ano", 2020)
                  .with("estudante", false)
                  .with("saldo", saldo)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(saldo - 4.40,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico), 0.01),
                  () -> Assertions.assertEquals(56, campos().get("qtdPassageiros").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 3 - estudante")
        void cenario3() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 29)
                  .with("valorPassagem", 10.0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2008)
                  .with("estudante", true)
                  .with("saldo", 50.0)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(45.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico), 0.01),
                  () -> Assertions.assertEquals(30, campos().get("qtdPassageiros").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 4 - bilhete bloqueado")
        void cenario4() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 29)
                  .with("valorPassagem", 10.0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2008)
                  .with("estudante", true)
                  .with("saldo", 50.0)
                  .with("bloqueado", true)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(50.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico), 0.01),
                  () -> Assertions.assertEquals(29, campos().get("qtdPassageiros").get(obj))
            );
        }

        @ParameterizedTest
        @ValueSource(doubles = {9.99, 9.0, 5.0})
        @DisplayName("Cenário 5 - bilhete sem saldo")
        void cenario5(double saldo) throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", BilheteUnico.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 99)
                  .with("valorPassagem", 10.0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2010)
                  .with("estudante", false)
                  .with("saldo", saldo)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(saldo,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico), 0.01),
                  () -> Assertions.assertEquals(99, campos().get("qtdPassageiros").get(obj))
            );
        }
    }

    @Nested
    @DisplayName("5. Método - cobrarPassagem - dinheiro")
    class MetodoCobrarPassagemDinheiroTests {

        Map<String, Field> campos() throws ReflectiveOperationException {
            Class<Onibus> clazz = Onibus.class;

            Field qtdPassageiros = clazz.getDeclaredField("qtdPassageiros");
            qtdPassageiros.trySetAccessible();

            Field valorPassagem = clazz.getDeclaredField("valorPassagem");
            valorPassagem.trySetAccessible();

            return Map.of("qtdPassageiros", qtdPassageiros, "valorPassagem", valorPassagem);
        }

        @Test
        @DisplayName("Cenário 1")
        void cenario1() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", Double.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 0)
                  .with("valorPassagem", 5.0)
                  .build();

            // When
            metodo.invoke(obj, 10.0);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(1, campos().get("qtdPassageiros").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 2")
        void cenario2() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", Double.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 36)
                  .with("valorPassagem", 4.40)
                  .build();

            // When
            metodo.invoke(obj, 4.40);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(37, campos().get("qtdPassageiros").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 3 - Saldo insuficiente")
        void cenario3() throws ReflectiveOperationException {
            Class<Onibus> clazzOnibus = Onibus.class;
            Method metodo = clazzOnibus.getDeclaredMethod("cobrarPassagem", Double.class);

            Onibus obj = new ObjectFieldBuilder<>(Onibus.class)
                  .with("qtdPassageiros", 36)
                  .with("valorPassagem", 5.50)
                  .build();

            // When
            metodo.invoke(obj, 5.00);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(36, campos().get("qtdPassageiros").get(obj))
            );
        }
    }
}
