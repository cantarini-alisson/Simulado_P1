public class ItemCompra {
    private Produto produto;
    private int quantidadeComprada;
    private double valorTotal;

    public ItemCompra(Produto produto, int quantidadeComprada) {
        if (quantidadeComprada <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        produto.reduzirEstoque(quantidadeComprada);
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        this.valorTotal = quantidadeComprada * produto.getPrecoUnitario();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }
}
