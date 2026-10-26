package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;

public class ItemBiblioteca {

   private String titulo;
   private Usuario emprestadoPara;

    public ItemBiblioteca(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new DadoInvalidoException("Dado do titulo inválido");
        }
        this.titulo = titulo;
    }

    public void emprestar(Usuario usuario) throws ItemIndisponivelException {
       if(usuario == null){
           throw new DadoInvalidoException("Dado inválido");
       }if(emprestadoPara != null){
           throw new ItemIndisponivelException("Esse item já esta emprestado");
       }
       emprestadoPara = usuario;
    }

    public void devolver(){
        emprestadoPara = null;
    }

    public Integer getPrazoEmprestimoDias(){

        return 7;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    public void setEmprestadoPara(Usuario emprestadoPara) {
        this.emprestadoPara = emprestadoPara;
    }
}