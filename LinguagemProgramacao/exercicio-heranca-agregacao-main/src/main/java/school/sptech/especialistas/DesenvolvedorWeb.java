package school.sptech.especialistas;

import school.sptech.Consultoria;
import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {

    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public Double calcularSalario(){
        Double salarioDesenvolvedorWeb = super.calcularSalario() + horasMentoria * 300;
        return salarioDesenvolvedorWeb;
    }

    public Boolean isFullstack(){
        if(backend != null && frontend != null && sgbd != null && horasMentoria != null){
            return true;
        }
        return false;
    }



    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }
}
