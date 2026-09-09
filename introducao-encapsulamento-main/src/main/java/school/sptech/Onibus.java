package school.sptech;

public class Onibus {

    private Integer qtdPassageiros;
    private Double valorPassagem;

    public Onibus() {
    }

    public Integer getQtdPassageiros() {
        return qtdPassageiros;
    }

    public Double getValorPassagem() {
        return valorPassagem;
    }

    public void cobrarPassagem(BilheteUnico bilhete) {
        if (Boolean.TRUE.equals(bilhete.getBloqueado())) {
            System.out.println("bilhete único bloqueado");
            return;
        }

        Double valorCobrado = valorPassagem;
        if (Boolean.TRUE.equals(bilhete.getEstudante())) {
            valorCobrado = valorPassagem / 2;
        }

        if (bilhete.getSaldo() < valorCobrado) {
            System.out.println("Não há saldo suficiente para realizar a operação");
            return;
        }

        bilhete.setSaldo(bilhete.getSaldo() - valorCobrado);
        qtdPassageiros = (qtdPassageiros == null ? 0 : qtdPassageiros) + 1;
    }

    public void cobrarPassagem(Double dinheiro) {
        if (dinheiro < valorPassagem) {
            System.out.println("Dinheiro insuficiente para realizar operação");
            return;
        }

        qtdPassageiros = (qtdPassageiros == null ? 0 : qtdPassageiros) + 1;
    }
}