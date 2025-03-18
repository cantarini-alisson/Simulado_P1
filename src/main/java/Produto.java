public class Produto {
    private String descricao;
    private double precoUnitario;
    private int estoque;
    private Categoria categoria;

    public Produto(String descricao, double precoUnitario, int estoque, Categoria categoria) {
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

    public void reduzirEstoque(int quantidade) {
        if (quantidade > estoque) {
            throw new IllegalArgumentException("Estoque insuficiente para " + descricao);
        }
        estoque -= quantidade;
    }

    public void aumentarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
