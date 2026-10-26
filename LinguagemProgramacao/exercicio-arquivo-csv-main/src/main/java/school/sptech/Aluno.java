package school.sptech;

public class Aluno {
private String ra;
private Double nota1;
private Double nota2;
private Integer frequencia;

    public Aluno(String ra, Double nota1, Double nota2, Integer frequencia) {
        this.ra = ra;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.frequencia = frequencia;
    }

    public Double calcularMedia(){
        Double somaNota1 = 0.0;
        Double somaNota2 = 0.0;


    }


    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }
}
