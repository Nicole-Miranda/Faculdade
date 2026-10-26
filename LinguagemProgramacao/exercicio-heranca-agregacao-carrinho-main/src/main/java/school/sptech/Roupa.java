package school.sptech;

public class Roupa extends Produto {

    private String cor;
    private Double tamanho;
    private String material;

    @Override
    public Double calcularPrecoFinal(){
        Double precoFinal = super.calcularPrecoFinal();

        if(material != null && material.equalsIgnoreCase("couro")){
            return precoFinal * 0.85;
        }

        return precoFinal;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
