package org.example;

public class Aluno {
    private String nome;
    private String ra;
    private Double nota;
    private Double individual;


    public Aluno() {
    }

    public Aluno(
            String nome,
            String ra,
            Double nota,
            Double individual
    ) throws AlunoDadoInvalidoException {
        if(
                nome == null || ra == null || nota == null || individual == null
        ){
            throw new AlunoDadoInvalidoException ("Os dados recebidos está nulos");
        }

        this.nome = nome;
        this.ra = ra;
        this.nota = nota;
        this.individual = individual;
    }


    public Double calcularMediaFinal(){
        if(nota == null || individual == null){
            throw new AlunoNotaInvalida("Nota ou o individual está nulo");
        }
        return nota * 0.4 + individual * 0.6;
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

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getIndividual() {
        return individual;
    }

    public void setIndividual(Double individual) {
        this.individual = individual;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", ra='" + ra + '\'' +
                ", nota=" + nota +
                ", individual=" + individual +
                '}';
    }
}
