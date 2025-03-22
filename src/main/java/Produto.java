public class Produto {
    private String nome;
    private double precoUnitario;
    private int estoque;
    private Categoria categoria;

    public Produto(String nome, double precoUnitario, int estoque, Categoria categoria) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade > estoque) {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
        }
        this.estoque -= quantidade;
    }

    public void exibirEstoque() {
        System.out.println(nome + " - Estoque disponível: " + estoque);
    }
}
