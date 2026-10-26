package school.sptech.escrita;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Escritor {

    // OutputStream -> fluxo de saida de bytes
    // FileOutputStream -> para escrever arquivos
    // ByteArrayOutputStream -> escrever em memória
    // PrintStream (extra) -> escreve a saida formatada
    public void escrever(
            String nomeArquivo,
            List<Produto> produtos
    ) {
        // try-with-resourcers
        try (
              FileOutputStream outputStream = new FileOutputStream(nomeArquivo, false);
              OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
              BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            String cabecalho = "nome;preco;categoria;estoque";
            bufferedWriter.write(cabecalho);
            bufferedWriter.newLine();

            for (Produto produto : produtos) {
                String linha = "%s;%.2f;%s;%d"
                      .formatted(
                            produto.getNome(),
                            produto.getPreco(),
                            produto.getCategoria(),
                            produto.getEstoque()
                      );
                bufferedWriter.write(linha);
                bufferedWriter.newLine();

            }

            // outputStream.close(); // se não fechar é uma péssima prática
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    public void escrever(
            String nomeArquivo
    ) {
        // try-with-resourcers
        try (
                FileOutputStream outputStream = new FileOutputStream(nomeArquivo, false);
                OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("Hello World!");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
        }
    }
}