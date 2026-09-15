package school.sptech;

public class PontoDeRecarga {

    private Integer qtdConsultasRealizadas;
    private Integer qtdRecargasRealizadas;

    public PontoDeRecarga() {
    }

    public Integer getQtdConsultasRealizadas() {
        return qtdConsultasRealizadas;
    }

    public Integer getQtdRecargasRealizadas() {
        return qtdRecargasRealizadas;
    }

    public Double consultarSaldo(BilheteUnico bilhete) {
        if (Boolean.TRUE.equals(bilhete.getBloqueado())) {
            System.out.println("bilhete único bloqueado");
            return 0.0;
        }

        qtdConsultasRealizadas = (qtdConsultasRealizadas == null ? 0 : qtdConsultasRealizadas) + 1;
        return bilhete.getSaldo();
    }

    public void recarregar(BilheteUnico bilhete, Double valor) {
        if (valor < 5.00) {
            System.out.println("Valor mínimo de recarga não atingido");
            return;
        }

        if (Boolean.TRUE.equals(bilhete.getBloqueado())) {
            System.out.println("bilhete único bloqueado");
            return;
        }

        bilhete.setSaldo(bilhete.getSaldo() + valor);
        qtdRecargasRealizadas = (qtdRecargasRealizadas == null ? 0 : qtdRecargasRealizadas) + 1;
    }

    public void bloquear(BilheteUnico bilhete) {
        bilhete.setBloqueado(true);
    }
}