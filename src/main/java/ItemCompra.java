public class ItemCompra {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ItemCompra(Produto produto, int quantidade) {
        if (quantidade > produto.getEstoque()) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: \n" + produto.getNome());
        }
        this.produto = produto;
        this.quantidade = quantidade;
        calcularValorTotal();
        produto.reduzirEstoque(quantidade);
    }


    private void calcularValorTotal() {
        this.valorTotal = produto.getPrecoUnitario() * quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }
}
