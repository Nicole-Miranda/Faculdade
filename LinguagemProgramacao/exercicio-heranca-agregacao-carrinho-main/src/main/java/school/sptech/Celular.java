package school.sptech;

public class Celular extends Produto {

    private Integer garantiaMeses;
    private String marca;

    @Override
    public Double calcularPrecoFinal(){
        return super.calcularPrecoFinal() + (50.0 * garantiaMeses);
    }

    public Integer getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(Integer garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "garantiaMeses=" + garantiaMeses +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
