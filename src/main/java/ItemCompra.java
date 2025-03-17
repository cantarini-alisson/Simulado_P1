public class ItemCompra {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ItemCompra(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (quantidade > produto.getEstoque()) {
            throw new IllegalStateException("Quantidade insuficiente em estoque.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getPrecoUnitario() * quantidade;
        produto.reduzirEstoque(quantidade); // Reduz o estoque do produto
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Total: R$ " + valorTotal;
    }
}