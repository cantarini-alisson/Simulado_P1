public class Produto {
    private String descricao;
    private double precoUnitario;
    private int estoque;
    private Categoria categoria;

    public Produto(String descricao, double precoUnitario, int estoque, Categoria categoria) {
        if (descricao == null || descricao.trim().isEmpty() || precoUnitario <= 0 || estoque < 0 || categoria == null) {
            throw new IllegalArgumentException("Dados inválidos para o produto.");
        }
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > estoque) {
            throw new IllegalArgumentException("Quantidade inválida ou estoque insuficiente.");
        }
        this.estoque -= quantidade;
    }
}
