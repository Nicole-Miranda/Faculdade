package school.sptech;
//SUper classe
public class Aluno {
    //protected -> libra acesso para a própria classe, sua subclasse e para o mesmo pacote
    protected String nome;
    protected String ra;
    protected Double notaAc1;
    protected Double notaAc2;
    protected Double notaAc3;

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
        this.notaAc1 = 0.0;
        this.notaAc2 = 0.0;
        this.notaAc3 = 0.0;
    }

    public Double calcularNotaFinal(){
        Double notaFinalAc1 = this.notaAc1 * 0.3;
        Double notaFinalAc2 = this.notaAc2 * 0.3;
        Double notaFinalAc3 = this.notaAc3 * 0.4;

        return (notaFinalAc1 + notaFinalAc2 + notaFinalAc3);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public Double getNotaAc1() {
        return notaAc1;
    }

    public void setNotaAc1(Double notaAc1) {
        this.notaAc1 = notaAc1;
    }

    public Double getNotaAc2() {
        return notaAc2;
    }

    public void setNotaAc2(Double notaAc2) {
        this.notaAc2 = notaAc2;
    }

    public Double getNotaAc3() {
        return notaAc3;
    }

    public void setNotaAc3(Double notaAc3) {
        this.notaAc3 = notaAc3;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", ra='" + ra + '\'' +
                ", notaAc1=" + notaAc1 +
                ", notaAc2=" + notaAc2 +
                ", notaAc3=" + notaAc3 +
                '}';
    }
}
