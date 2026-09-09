package school.sptech.ex3;

public class Funcionario {

    String nome;
    String cargo;
    Double salario;

    void reajustarSalario(Integer valorPercentual){

        Double salarioReajustado = 0.0;

        salarioReajustado = (salario * valorPercentual)/100;

        salario += salarioReajustado;

        return;
    }

   Double calcularValorHora(){
        Double valorHora = 0.0;

        valorHora = salario/220;

        return valorHora;
   }


    Double calcularHoraExtra(Integer horaExtra, Integer percentualNoturno){
        Double valorHora = calcularValorHora();
        Double valorHoraExtra = 0.0;
        Double valorFinal = 0.0;

        valorHoraExtra = valorHora + (valorHora * percentualNoturno / 100.0);
        valorFinal = valorHoraExtra * horaExtra;

        return valorFinal;
    }

    Double calcularBonificacaoAnual(){
        //Double salarioAnual = salario * 12;
        Double salarioBonificacao = 0.0;
        Double bonificacaoAnual = 0.0;

        if(salario <= 2500){
            bonificacaoAnual = salario * 0.15;
            //salarioBonificacao = salario + bonificacaoAnual;
        } else if (salario <= 6000) {
            bonificacaoAnual = salario * 0.1;
            //salarioBonificacao = salario + bonificacaoAnual;

        }else{
            bonificacaoAnual = salario * 0.05;
            //salarioBonificacao = salario + bonificacaoAnual;

        }

        return bonificacaoAnual;


    }






}
