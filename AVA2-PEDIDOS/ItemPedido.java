public class ItemPedido {
    private String codigoItemProduto;
    private String descricaoProduto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String codigoItemProduto, String descricaoProduto, int quantidade, double precoUnitario) {
        this.codigoItemProduto = codigoItemProduto;
        this.descricaoProduto = descricaoProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getCodigoItemProduto() {
        return codigoItemProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
