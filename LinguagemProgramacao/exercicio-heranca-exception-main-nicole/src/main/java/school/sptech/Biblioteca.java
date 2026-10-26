package school.sptech;

import org.w3c.dom.CDATASection;
import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;
import school.sptech.exceptions.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<ItemBiblioteca> itens = new ArrayList<>();

    public Biblioteca(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new DadoInvalidoException("Dado inválido");
        }
        this.nome = nome;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (item == null) {
            throw new DadoInvalidoException("Dado de item inválido");
        } else {
            itens.add(item);
        }
    }

    public ItemBiblioteca buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ItemNaoEncontradoException("Item não encontrado");
        }

        for (ItemBiblioteca item : itens) {
            if (item.getTitulo() != null && item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }

        throw new ItemNaoEncontradoException("Item não encontrado");
    }


    public void emprestarItem(String titulo, Usuario usuario) {
        if (titulo == null || usuario == null) {
            throw new DadoInvalidoException("Dado de titulo e usuario inválido");
        }

        ItemBiblioteca item = buscarPorTitulo(titulo);

        try {
            item.emprestar(usuario);
        } catch (ItemIndisponivelException e) {
            System.out.println("Esse item já está emprestado para outro usuário.");        }


    }


    public void devolverItem(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new DadoInvalidoException("Dado de titulo inválido");
        }

        buscarPorTitulo(titulo).devolver();
    }

    public  Boolean possuiItemDisponivel(String titulo){

        if(titulo == null || titulo.isBlank()){
           throw new DadoInvalidoException("Titulo inválido");
        }

        ItemBiblioteca item = buscarPorTitulo(titulo);

        if(item.getEmprestadoPara() == null){
            return true;
        }
        return false;
    }

    public List<ItemBiblioteca> listarDisponiveis(){
        List<ItemBiblioteca> lista = new ArrayList<>();
        for (ItemBiblioteca item : itens){
            if(item.getEmprestadoPara() == null){
                lista.add(item);

            }
        }
        return lista;
    }

    public Integer contarPorTipo(String tipo){
        if (tipo == null || tipo.isBlank()
                || !(tipo.equalsIgnoreCase("DVD") || tipo.equalsIgnoreCase("Livro"))) {
            throw new DadoInvalidoException("Dados inválidos");
        }

        Integer contador = 0;
        for(ItemBiblioteca item : itens){
            if(tipo.equalsIgnoreCase("DVD") && item instanceof Dvd){
                contador ++;
            } else if (tipo.equalsIgnoreCase("Livro") && item instanceof Livro) {
                contador ++;
            }
        }

        return contador;
    }



    public void emprestarVarios(List<String> titulos, Usuario usuario){
        if(titulos == null || usuario == null || titulos.isEmpty()){
            throw new DadoInvalidoException("Dado inválido");
        }

        List<String> titulosVistos = new ArrayList<>();

        for(String titulo : titulos){
            if(titulo == null || titulo.isBlank()){
                throw new DadoInvalidoException("Título inválido");
            }
            if(titulosVistos.contains(titulo.toLowerCase())){
                throw new DadoInvalidoException("Título duplicado");
            }
            titulosVistos.add(titulo.toLowerCase());
        }

        List<ItemBiblioteca> lote = new ArrayList<>();

        for(String titulo : titulos){
            lote.add(buscarPorTitulo(titulo));
        }

        for(ItemBiblioteca item : lote){
            if(item.getEmprestadoPara() != null){
                System.out.println("Não foi possível emprestar o lote: o item '"
                        + item.getTitulo() + "' está indisponível.");
                return;
            }
        }

        for(ItemBiblioteca item : lote){
            try {
                item.emprestar(usuario);
            } catch (ItemIndisponivelException e) {
                System.out.println("Esse item já está emprestado para outro usuário");
            }
        }
    }


    public Integer calcularPrazoMedioEmprestimo(){
        if(itens.isEmpty()){
            return 0;
        }

        Integer contador = 0;

        for(ItemBiblioteca item : itens){
            contador += item.getPrazoEmprestimoDias();
        }

        return contador/ itens.size();
    }


    public Integer calcularPrazoMedioPorTipo(String tipo) {
        if (tipo == null || tipo.isBlank()
                || !(tipo.equalsIgnoreCase("DVD") || tipo.equalsIgnoreCase("Livro"))) {
            throw new DadoInvalidoException("Dado inválido");
        }

        Integer soma = 0;
        Integer quantidade = 0;

        for (ItemBiblioteca item : itens) {
            if (tipo.equalsIgnoreCase("DVD") && item instanceof Dvd) {
                soma += item.getPrazoEmprestimoDias();
                quantidade++;
            } else if (tipo.equalsIgnoreCase("Livro") && item instanceof Livro) {
                soma += item.getPrazoEmprestimoDias();
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0;
        }

        return soma / quantidade;
    }


    public List<ItemBiblioteca> listarEmprestadosPara(Usuario usuario){
        if(usuario == null){
            throw new DadoInvalidoException("Dado inválido");
        }
        List<ItemBiblioteca> lista = new ArrayList<>();

        for(ItemBiblioteca item : itens){
            if(item.getEmprestadoPara() != null && item.getEmprestadoPara().getNome().equals(usuario.getNome())){
                lista.add(item);
            }
        }

        return lista;
    }


    public void devolverTodosDoUsuario(Usuario usuario){
        if(usuario == null){
            throw new DadoInvalidoException("Dado inválido");
        }

        for(ItemBiblioteca item : itens){
            if(item.getEmprestadoPara() !=null &&
            item.getEmprestadoPara().getNome().equals(usuario.getNome())){
                item.devolver();
            }
        }
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemBiblioteca> getItens() {
        return itens;
    }

    public void setItens(List<ItemBiblioteca> itens) {
        this.itens = itens;
    }
}
