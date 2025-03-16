public class Produto {
    private String nome;
    private double precoUnitario;
    private int estoque;

    public Produto(String nome, double precoUnitario, int estoque) {
        if (precoUnitario <= 0) {
            throw new IllegalArgumentException("O preço deve ser positivo.");
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (quantidade > estoque) {
            throw new IllegalStateException("Quantidade insuficiente em estoque.");
        }
        this.estoque -= quantidade;
    }

    @Override
    public String toString() {
        return nome + " - Preço: R$ " + precoUnitario + " - Estoque: " + estoque;
    }
}