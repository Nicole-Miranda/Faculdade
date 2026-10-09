package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {

    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;


    public Double calcularSalario(){
        Double salarioDesenvolvedorMobile = super.calcularSalario() + horasPrototipacao * 200;

        return salarioDesenvolvedorMobile;
    }


    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasProtoripacao) {
        this.horasPrototipacao = horasPrototipacao;
    }
}
