public class ItemCompra {
    private Produto produto;
    private int quantidadeComprada;
    private double valorTotal;

    public ItemCompra(Produto produto, int quantidadeComprada) {
        if (produto == null || quantidadeComprada <= 0) {
            throw new IllegalArgumentException("Produto inválido ou quantidade insuficientes.");
        }
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        calcularValorTotal();
        produto.reduzirEstoque(quantidadeComprada);
    }

    private void calcularValorTotal() {
        this.valorTotal = produto.getPrecoUnitario() * quantidadeComprada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public Produto getProduto() {
        return produto;
    }
}
