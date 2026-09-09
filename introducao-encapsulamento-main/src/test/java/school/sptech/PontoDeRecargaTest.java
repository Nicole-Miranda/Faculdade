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

@DisplayName("Ponto de Recarga")
public class PontoDeRecargaTest {

    @Nested
    @DisplayName("1. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("qtdConsultasRealizadas")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("qtdRecargasRealizadas"))
            );
        }
    }

    @Nested
    @DisplayName("2. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar métodos")
        void validarMetodos() {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(() ->
                        clazz.getDeclaredMethod("consultarSaldo", BilheteUnico.class)),
                  () -> Assertions.assertDoesNotThrow(() ->
                        clazz.getDeclaredMethod("recarregar", BilheteUnico.class, Double.class)),
                  () -> Assertions.assertDoesNotThrow(() ->
                        clazz.getDeclaredMethod("bloquear", BilheteUnico.class))
            );
        }
    }

    @Nested
    @DisplayName("3. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Métodos públicos")
        void cenario2() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method consultarSaldo = clazz.getDeclaredMethod("consultarSaldo", BilheteUnico.class);
            Method recarregar = clazz.getDeclaredMethod("recarregar", BilheteUnico.class,
                  Double.class);
            Method bloquear = clazz.getDeclaredMethod("bloquear", BilheteUnico.class);

            Assertions.assertAll(
                  () -> Assertions.assertTrue(Modifier.isPublic(consultarSaldo.getModifiers())),
                  () -> Assertions.assertTrue(Modifier.isPublic(recarregar.getModifiers())),
                  () -> Assertions.assertTrue(Modifier.isPublic(bloquear.getModifiers()))
            );
        }

        @Test
        @DisplayName("Atributos devem possuir getters e não possuir setters")
        void cenario3() {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
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
    @DisplayName("4. Método - consultarSaldo")
    class MetodoConsultarSaldoTests {

        Map<String, Field> campos() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;

            Field qtdConsultasRealizadas = clazz.getDeclaredField("qtdConsultasRealizadas");
            qtdConsultasRealizadas.trySetAccessible();

            Field qtdRecargasRealizadas = clazz.getDeclaredField("qtdRecargasRealizadas");
            qtdRecargasRealizadas.trySetAccessible();

            return Map.of("qtdConsultasRealizadas", qtdConsultasRealizadas, "qtdRecargasRealizadas",
                  qtdRecargasRealizadas);
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
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("consultarSaldo", BilheteUnico.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 0)
                  .with("qtdRecargasRealizadas", 0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Paulo Muniz")
                  .with("ano", 2019)
                  .with("estudante", false)
                  .with("saldo", 200.0)
                  .with("bloqueado", false)
                  .build();

            // When
            Object resposta = metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(200.0, resposta),
                  () -> Assertions.assertEquals(1, campos().get("qtdConsultasRealizadas").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 2")
        void cenario2() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("consultarSaldo", BilheteUnico.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 92)
                  .with("qtdRecargasRealizadas", 83)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "William Marques")
                  .with("ano", 2020)
                  .with("estudante", false)
                  .with("saldo", 8.0)
                  .with("bloqueado", false)
                  .build();

            // When
            Object resposta = metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(8.0, resposta),
                  () -> Assertions.assertEquals(93, campos().get("qtdConsultasRealizadas").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 3 - Bilhete bloqueado")
        void cenario3() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("consultarSaldo", BilheteUnico.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 34)
                  .with("qtdRecargasRealizadas", 20)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2008)
                  .with("estudante", true)
                  .with("saldo", 50.0)
                  .with("bloqueado", true)
                  .build();

            // When
            Object resposta = metodo.invoke(obj, bilheteUnico);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(0.0, resposta),
                  () -> Assertions.assertEquals(34, campos().get("qtdConsultasRealizadas").get(obj))
            );
        }
    }

    @Nested
    @DisplayName("5. Método - recarregar")
    class MetodoRecarregarTests {

        Map<String, Field> campos() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;

            Field qtdConsultasRealizadas = clazz.getDeclaredField("qtdConsultasRealizadas");
            qtdConsultasRealizadas.trySetAccessible();

            Field qtdRecargasRealizadas = clazz.getDeclaredField("qtdRecargasRealizadas");
            qtdRecargasRealizadas.trySetAccessible();

            return Map.of("qtdConsultasRealizadas", qtdConsultasRealizadas, "qtdRecargasRealizadas",
                  qtdRecargasRealizadas);
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

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("recarregar", BilheteUnico.class, Double.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 0)
                  .with("qtdRecargasRealizadas", 0)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Paulo Muniz")
                  .with("ano", 2019)
                  .with("estudante", false)
                  .with("saldo", 200.0)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico, 150.0);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(350.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico)),
                  () -> Assertions.assertEquals(1, campos().get("qtdRecargasRealizadas").get(obj))
            );
        }

        @ParameterizedTest
        @ValueSource(doubles = {50.0, 5.0, 10.0})
        @DisplayName("Cenário 2")
        void cenario2(double value) throws ReflectiveOperationException {

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("recarregar", BilheteUnico.class, Double.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 34)
                  .with("qtdRecargasRealizadas", 20)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "William Marques")
                  .with("ano", 2020)
                  .with("estudante", false)
                  .with("saldo", 8.0)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico, value);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(value + 8,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico)),
                  () -> Assertions.assertEquals(21, campos().get("qtdRecargasRealizadas").get(obj))
            );
        }

        @Test
        @DisplayName("Cenário 4 - bilhete bloqueado")
        void cenario4() throws ReflectiveOperationException {

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("recarregar", BilheteUnico.class, Double.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 92)
                  .with("qtdRecargasRealizadas", 83)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2008)
                  .with("estudante", true)
                  .with("saldo", 50.0)
                  .with("bloqueado", true)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico, 100.0);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(50.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico)),
                  () -> Assertions.assertEquals(83, campos().get("qtdRecargasRealizadas").get(obj))
            );
        }

        @ParameterizedTest
        @ValueSource(doubles = {2.0, 4.9})
        @DisplayName("Cenário 3 - valor mínimo não atingido")
        void cenario3(double value) throws ReflectiveOperationException {

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("recarregar", BilheteUnico.class, Double.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 92)
                  .with("qtdRecargasRealizadas", 83)
                  .build();
            BilheteUnico bilheteUnico = new ObjectFieldBuilder<>(BilheteUnico.class)
                  .with("titular", "Manoel Almeida")
                  .with("ano", 2008)
                  .with("estudante", true)
                  .with("saldo", 50.0)
                  .with("bloqueado", false)
                  .build();

            // When
            metodo.invoke(obj, bilheteUnico, value);

            // Then
            Assertions.assertAll(
                  () -> Assertions.assertEquals(50.0,
                        (Double) camposBilhete().get("saldo").get(bilheteUnico)),
                  () -> Assertions.assertEquals(83, campos().get("qtdRecargasRealizadas").get(obj))
            );
        }
    }

    @Nested
    @DisplayName("6. Método - bloquear")
    class MetodoBloquearTests {

        Map<String, Field> campos() throws ReflectiveOperationException {
            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;

            Field qtdConsultasRealizadas = clazz.getDeclaredField("qtdConsultasRealizadas");
            qtdConsultasRealizadas.trySetAccessible();

            Field qtdRecargasRealizadas = clazz.getDeclaredField("qtdRecargasRealizadas");
            qtdRecargasRealizadas.trySetAccessible();

            return Map.of("qtdConsultasRealizadas", qtdConsultasRealizadas, "qtdRecargasRealizadas",
                  qtdRecargasRealizadas);
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

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("bloquear", BilheteUnico.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 0)
                  .with("qtdRecargasRealizadas", 0)
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
                  () -> Assertions.assertTrue(
                        (Boolean) camposBilhete().get("bloqueado").get(bilheteUnico))
            );
        }

        @Test
        @DisplayName("Cenário 2")
        void cenario2() throws ReflectiveOperationException {

            Class<PontoDeRecarga> clazz = PontoDeRecarga.class;
            Method metodo = clazz.getDeclaredMethod("bloquear", BilheteUnico.class);

            PontoDeRecarga obj = new ObjectFieldBuilder<>(PontoDeRecarga.class)
                  .with("qtdConsultasRealizadas", 0)
                  .with("qtdRecargasRealizadas", 0)
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
                  () -> Assertions.assertTrue(
                        (Boolean) camposBilhete().get("bloqueado").get(bilheteUnico))
            );
        }
    }
}
