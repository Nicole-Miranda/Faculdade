package ex01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ex01.factory.LojaFactory;
import ex01.factory.PedidoFactory;
import ex01.provider.AplicarDescontoProvider;
import ex01.provider.BuscarProdutoMaisVendidoProvider;
import ex01.provider.CalcularFaturamentoTotalProvider;
import ex01.provider.CalcularTicketMedioProvider;
import ex01.provider.ConcluirPedidoProvider;
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

@DisplayName("Loja")
public class LojaTest {

    private static Object campo(Object instancia, String nomeCampo)
          throws ReflectiveOperationException {
        Field field = instancia.getClass().getDeclaredField(nomeCampo);
        field.trySetAccessible();
        return field.get(instancia);
    }

    @Nested
    @DisplayName("Loja 01. Atributos")
    class AtributosTests {

        @Test
        @DisplayName("Validar Atributos")
        void cenario1() {
            Class<Loja> clazz = Loja.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalPedidosRealizados")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalDescontosAplicados")),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredField("totalPedidosCancelados"))
            );
        }
    }

    @Nested
    @DisplayName("Loja 02. Encapsulamento")
    class EncapsulamentoTests {

        @Test
        @DisplayName("Atributos Privados")
        void cenario1() {
            Class<Loja> clazz = Loja.class;
            Field[] campos = clazz.getDeclaredFields();

            Stream<Executable> validacoes = Arrays.stream(campos)
                  .map((campo) -> () -> Assertions.assertTrue(
                        Modifier.isPrivate(campo.getModifiers())));

            Assertions.assertAll(validacoes);
        }

        @Test
        @DisplayName("Atributos devem possuir getters (somente getters)")
        void cenario2() {
            Class<Loja> clazz = Loja.class;
            EncapsulationUtil.validarGettersSettersExcetoSetters(clazz,
                  "totalPedidosRealizados", "totalDescontosAplicados", "totalPedidosCancelados");
        }

        @Test
        @DisplayName("Nenhum dos contadores deve conter setter")
        void cenario3() {
            Class<Loja> clazz = Loja.class;
            List<String> camposSemSetter = List.of("totalPedidosRealizados",
                  "totalDescontosAplicados", "totalPedidosCancelados");

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
    @DisplayName("Loja 03. O construtor vazio deve zerar os contadores")
    class ConstrutorTests {

        @Test
        @DisplayName("Único Cenário")
        void cenario1() throws ReflectiveOperationException {
            Class<Loja> clazz = Loja.class;

            Constructor<Loja> constructor = clazz.getDeclaredConstructor();
            Loja loja = constructor.newInstance();

            Assertions.assertAll(
                  () -> assertEquals(0, campo(loja, "totalPedidosRealizados")),
                  () -> assertEquals(0, campo(loja, "totalDescontosAplicados")),
                  () -> assertEquals(0, campo(loja, "totalPedidosCancelados"))
            );
        }
    }

    @Nested
    @DisplayName("Loja 04. Métodos")
    class MetodosTests {

        @Test
        @DisplayName("Validar Métodos")
        void cenario1() {
            Class<Loja> clazz = Loja.class;

            Assertions.assertAll(
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("aplicarPromocao", Pedido.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("cancelarPedido", Pedido.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("aplicarDesconto", Pedido.class,
                              Double.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("concluirPedido", Pedido.class,
                              Double.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularFaturamentoTotal", List.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("calcularTicketMedio", List.class)),
                  () -> Assertions.assertDoesNotThrow(
                        () -> clazz.getDeclaredMethod("buscarProdutoMaisVendido", List.class))
            );
        }
    }

    @Nested
    @DisplayName("Loja 05. Aplicar promoção")
    class AplicarPromocaoTests {

        @Test
        @DisplayName("Deve marcar o pedido como itemPromocional")
        void test1() throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);
            Pedido pedido = PedidoFactory.getInstance("P1", "Produto", 1, 10.0, 0.0, false,
                  false, true);

            Method aplicarPromocao = Loja.class.getDeclaredMethod("aplicarPromocao",
                  Pedido.class);
            aplicarPromocao.invoke(loja, pedido);

            assertEquals(true, campo(pedido, "itemPromocional"));
        }
    }

    @Nested
    @DisplayName("Loja 06. Cancelar pedido")
    class CancelarPedidoTests {

        @Test
        @DisplayName("Deve marcar o pedido como cancelado e incrementar totalPedidosCancelados")
        void test1() throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);
            Pedido pedido = PedidoFactory.getInstance("P1", "Produto", 1, 10.0, 0.0, false,
                  false, true);

            Method cancelarPedido = Loja.class.getDeclaredMethod("cancelarPedido", Pedido.class);
            cancelarPedido.invoke(loja, pedido);

            Assertions.assertAll(
                  () -> assertEquals(true, campo(pedido, "cancelado")),
                  () -> assertEquals(1, campo(loja, "totalPedidosCancelados"))
            );
        }
    }

    @Nested
    @DisplayName("Loja 07. Aplicar desconto")
    class AplicarDescontoTests {

        @ParameterizedTest(name = "{index} - porcentagem={1}, esperado={2}")
        @ArgumentsSource(AplicarDescontoProvider.class)
        @DisplayName("Deve aplicar o desconto somente quando o pedido for promocional e não estiver cancelado")
        void test1(Pedido pedido, Double porcentagem, Boolean resultadoEsperado,
              Double valorComDescontoEsperado) throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);

            Method aplicarDesconto = Loja.class.getDeclaredMethod("aplicarDesconto",
                  Pedido.class, Double.class);

            Object resultado = aplicarDesconto.invoke(loja, pedido, porcentagem);

            Assertions.assertAll(
                  () -> assertEquals(resultadoEsperado, resultado),
                  () -> assertEquals(valorComDescontoEsperado,
                        campo(pedido, "valorTotalComDesconto")),
                  () -> assertEquals(resultadoEsperado ? 1 : 0,
                        campo(loja, "totalDescontosAplicados"))
            );
        }
    }

    @Nested
    @DisplayName("Loja 08. Concluir pedido")
    class ConcluirPedidoTests {

        @ParameterizedTest(name = "{index} - pagamento={1}, esperado={2}")
        @ArgumentsSource(ConcluirPedidoProvider.class)
        @DisplayName("Deve validar pagamento, situação do pedido e, se concluir, atualizar pendente e totalPedidosRealizados")
        void test1(Pedido pedido, Double pagamento, Boolean resultadoEsperado)
              throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);
            Boolean pendenteAntes = (Boolean) campo(pedido, "pendente");

            Method concluirPedido = Loja.class.getDeclaredMethod("concluirPedido", Pedido.class,
                  Double.class);

            Object resultado = concluirPedido.invoke(loja, pedido, pagamento);

            Boolean pendenteEsperadoDepois = resultadoEsperado ? false : pendenteAntes;

            Assertions.assertAll(
                  () -> assertEquals(resultadoEsperado, resultado),
                  () -> assertEquals(pendenteEsperadoDepois, campo(pedido, "pendente")),
                  () -> assertEquals(resultadoEsperado ? 1 : 0,
                        campo(loja, "totalPedidosRealizados"))
            );
        }
    }

    @Nested
    @DisplayName("Loja 09. Calcular faturamento total")
    class CalcularFaturamentoTotalTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularFaturamentoTotalProvider.class)
        @DisplayName("Deve somar o valor pago somente dos pedidos concluídos")
        void test1(List<Pedido> pedidos, Double esperado) throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);

            Method calcularFaturamentoTotal = Loja.class.getDeclaredMethod(
                  "calcularFaturamentoTotal", List.class);

            assertEquals(esperado, calcularFaturamentoTotal.invoke(loja, pedidos));
        }
    }

    @Nested
    @DisplayName("Loja 10. Calcular ticket médio")
    class CalcularTicketMedioTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(CalcularTicketMedioProvider.class)
        @DisplayName("Deve calcular o valor médio somente dos pedidos concluídos")
        void test1(List<Pedido> pedidos, Double esperado) throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);

            Method calcularTicketMedio = Loja.class.getDeclaredMethod("calcularTicketMedio",
                  List.class);

            assertEquals(esperado, calcularTicketMedio.invoke(loja, pedidos));
        }
    }

    @Nested
    @DisplayName("Loja 11. 🏆 Desafio: Buscar produto mais vendido")
    class BuscarProdutoMaisVendidoTests {

        @ParameterizedTest(name = "{index} - esperado={1}")
        @ArgumentsSource(BuscarProdutoMaisVendidoProvider.class)
        @DisplayName("Deve retornar o produto com maior quantidade somada entre os pedidos concluídos")
        void test1(List<Pedido> pedidos, String esperado) throws ReflectiveOperationException {
            Loja loja = LojaFactory.getInstance(0, 0, 0);

            Method buscarProdutoMaisVendido = Loja.class.getDeclaredMethod(
                  "buscarProdutoMaisVendido", List.class);

            Object resultado = buscarProdutoMaisVendido.invoke(loja, pedidos);

            if (esperado == null) {
                Assertions.assertNull(resultado);
            } else {
                assertTrue(esperado.equalsIgnoreCase((String) resultado),
                      "Esperado (ignorando maiúsculas/minúsculas): " + esperado + ", obtido: "
                            + resultado);
            }
        }
    }
}
