package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private String titular;
    private String agencia;
    private String numero;
    private List<Operacao> operacoes = new ArrayList<>();

    public ContaCorrente(String titular, String agencia, String numero) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;

    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void adicionarOperacao(String categoria, String descricao, Double valor) {
        if (categoria == null || descricao == null || categoria.isBlank() || descricao.isBlank()) {
            return;
        }
        if (valor == null || valor == 0) {
            return;
        }
        Operacao novaOperacao = new Operacao(categoria, descricao, valor);
        this.operacoes.add(novaOperacao);
    }

    public double obterSaldo() {
        Double contador = 0.0;

        for (int i = 0; i < operacoes.size(); i++){
            Operacao o = operacoes.get(i);
            contador += o.getValor();
        }
        return contador;
    }

    public List<Operacao> buscarOperacoesPorCategoria(String categoria){
        Integer contador = 0;

        List<Operacao> resultado = new ArrayList<>();

        for (int i = 0; i < operacoes.size(); i++) {
            Operacao o = operacoes.get(i);

            if (o.getCategoria() != null && o.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(o);
            }
        }

        return resultado;
    }

    public List<Operacao> buscarOperacoesPorValor(Double valor){

        List<Operacao> resultado = new ArrayList<>();

        int contador = 0;

        for (int i = 0; i < operacoes.size(); i++) {
            Operacao o = operacoes.get(i);

            if (o.getValor() != null && o.getValor().equals(valor)) {
                resultado.add(o);
            }
        }

        return resultado;
    }

    public List<Operacao> buscarOperacoesSaida(){

        List<Operacao> resultado = new ArrayList<>();
        int contador = 0;

        for (int i = 0; i < operacoes.size(); i++) {
            Operacao o = operacoes.get(i);

            if (o.getValor() != null && o.getValor() < 0) {
                resultado.add(o);
            }
        }
        return resultado;
    }

    public List<Operacao> buscarOperacoesPorDescricao(String descricao){

        Integer contador = 0;

        List<Operacao> resultado = new ArrayList<>();
        List<Operacao> nulo = new ArrayList<>();

        for (int i = 0; i < operacoes.size(); i++) {
            Operacao o = operacoes.get(i);

            if(o.getDescricao() == null){
                return null;
            }
            if (o.getDescricao() != null && o.getDescricao().toLowerCase().contains(descricao.toLowerCase())) {
                resultado.add(o);
            }
        }
        return resultado;
    }


    public Double buscarMenorValor(){
        if (operacoes.isEmpty()) {
            return null;
        }

        Double total = 0.0;
        Double menor = operacoes.get(0).getValor();

        for (int i = 1; i < operacoes.size(); i++) {
            Operacao a = operacoes.get(i);
            if (a.getValor() < menor) {
                menor = a.getValor();
            }
        }

        return menor;
    }

    public Double obterSaldoPorCategoria(String categoria){
        List<Operacao> o = new ArrayList<>();

    }
}
