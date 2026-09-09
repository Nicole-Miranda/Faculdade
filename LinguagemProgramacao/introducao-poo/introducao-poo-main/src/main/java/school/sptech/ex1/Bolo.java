package school.sptech.ex1;

public class Bolo {

    String sabor;
    Double valor;
    Integer quantidadeVendida;
    Integer quantidadeEmEstoque;


    void venderBolo(Integer quantidade){
        if(quantidade < 0){
            return;
        }
        if(quantidade > quantidadeEmEstoque){
            return;
        }
        quantidadeVendida += quantidade;
        quantidadeEmEstoque -= quantidade;
    }

    void aumentarEstoque(Integer quantidadeEstoque){
        if(quantidadeEstoque > 0){
            quantidadeEmEstoque += quantidadeEstoque;
        }else{
            return;
        }
    }

    int quantidadeDisponivel(){
        return  quantidadeEmEstoque;
    }

    Double totalVendido(){

        return quantidadeVendida * valor;
    }
}
