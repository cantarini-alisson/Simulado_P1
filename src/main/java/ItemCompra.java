
public class ItemCompra {
    private Produto produto;
    private int quantidade;

    public ItemCompra(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        produto.reduzirEstoque(quantidade);
    }

    public double getValorTotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Total: R$ " + getValorTotal();
    }
}