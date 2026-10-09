package ex01;

public class Pedido {

   private String codigo;
   private String produto;
   private Integer quantidade;
   private Double valorUnitario;
   private Double valorTotalComDesconto;
   private Boolean itemPromocional;
   private Boolean cancelado;
   private Boolean pendente;


    public Pedido(String codigo, String produto, Integer quantidade, Double valorUnitario, Boolean itemPromocional, Boolean cancelado, Boolean pendente, Double valorTotalComDesconto){
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.itemPromocional = itemPromocional;
        this.cancelado = cancelado;
        this.pendente = pendente;
        this.valorTotalComDesconto = valorTotalComDesconto;
    }

    public Double calcularValorTotal(){

        Double valorTotalCompra = getValorUnitario() * getQuantidade();

        return valorTotalCompra;

    }

    public Double getValorTotalComDesconto() {
        return valorTotalComDesconto;
    }

    public void setValorTotalComDesconto(Double valorTotalComDesconto) {
        this.valorTotalComDesconto = valorTotalComDesconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Boolean getItemPromocional() {
        return itemPromocional;
    }

    public void setItemPromocional(Boolean itemPromocional) {
        this.itemPromocional = itemPromocional;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public Boolean getPendente() {
        return pendente;
    }

    public void setPendente(Boolean pendente) {
        this.pendente = pendente;
    }
}
