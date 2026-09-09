package school.sptech;

public class BilheteUnico {

    private String titular;
    Integer ano;
    Boolean estudante;
    Double saldo;
    Boolean bloqueado;

    public String getTitular() {
        return titular;
    }

    public Boolean getEstudante() {
        return estudante;
    }

    public Integer getAno() {
        return ano;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setEstudante(Boolean estudante) {
        this.estudante = estudante;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }


}
