package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria extends Desenvolvedor{

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }


    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }


    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
    if(desenvolvedor.isFullstack()){
        contratar(desenvolvedor);
    }

    }

    public Double getTotalSalarios(){
        Double contador = 0.0;

        for(Desenvolvedor desenvolvedor : desenvolvedores){

            contador += desenvolvedor.calcularSalario();
        }

        return contador;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer quantidade = 0;

        for (Desenvolvedor densenvolvedor : desenvolvedores){
            if(densenvolvedor instanceof DesenvolvedorMobile){
                quantidade ++;
            }
        }
            return quantidade;
    }


    public List<DesenvolvedorWeb> getDesenvolvedoresWeb(){
        List<DesenvolvedorWeb> dev = new ArrayList<>();

        for(Desenvolvedor desenvolvedor : desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorWeb){
                dev.add( (DesenvolvedorWeb) desenvolvedor);
            }
        }

        return dev;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
            List<Desenvolvedor> salarioDesenvolvedor = new ArrayList<>();

            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor.calcularSalario() >= salario) {
                    salarioDesenvolvedor.add(desenvolvedor);
                }
            }

            return salarioDesenvolvedor;

    }


    public Desenvolvedor buscarMenorSalario() {
        if(!desenvolvedores.isEmpty()) {
            Desenvolvedor menorSalario = desenvolvedores.getFirst();
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor.calcularSalario() < menorSalario.calcularSalario()) {
                    menorSalario = desenvolvedor;
                }
            }
            return menorSalario;
        }

        return null;
    }

    public Double calcularMediaSalarial(){
        if(!desenvolvedores.isEmpty()){
           return  getTotalSalarios() / desenvolvedores.size();
        }else{
            return 0.0;
        }
    }

    public List<Desenvolvedor> buscarPorNome(String nome) {
        List<Desenvolvedor> lista = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor.getNome().toLowerCase().contains(nome.toLowerCase().trim())) {
                lista.add(desenvolvedor);
            }
        }

        return lista;
    }


    public Double calcularMediaSalarialPorTipo(String tipo) {
        Integer qtd = 0;
        Double somaSalario = 0.0;
        if(tipo.equals("web")) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor instanceof DesenvolvedorWeb) {
                    somaSalario += desenvolvedor.calcularSalario();
                    qtd++;
                }
            }
        } else if(tipo.equals("mobile")) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor instanceof DesenvolvedorMobile) {
                    somaSalario += desenvolvedor.calcularSalario();
                    qtd++;
                }
            }
        } else if(tipo.equals("comum")) {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(!(desenvolvedor instanceof DesenvolvedorWeb) && !(desenvolvedor instanceof DesenvolvedorMobile)) {
                    somaSalario += desenvolvedor.calcularSalario();
                    qtd++;
                }
            }
        } else if (!(tipo.contains("comum")) || !tipo.contains("mobile") || !tipo.contains("web")) {
            return null;
        }

        if(qtd <= 0) {
            return 0.0;
        } else {
            return somaSalario / qtd;
        }
    }


    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> Lista = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile) {
                if(desenvolvedorMobile.getLinguagem().contains(tecnologia)) {
                    Lista.add(desenvolvedor);
                } else if (desenvolvedorMobile.getPlataforma().contains(tecnologia)) {
                    Lista.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb) {
                if(desenvolvedorWeb.getFrontend().contains(tecnologia)) {
                    Lista.add(desenvolvedor);
                } else if (desenvolvedorWeb.getBackend().contains(tecnologia)) {
                    Lista.add(desenvolvedor);
                } else if (desenvolvedorWeb.getSgbd().contains(tecnologia)) {
                    Lista.add(desenvolvedor);
                }
            }
        }

        return Lista;
    }









    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
