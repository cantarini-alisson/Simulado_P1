import java.util.HashSet;
import java.util.Set;

class Compra {
    private Set<ItemCompra> itens;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;

    public Compra(Vendedor vendedor) {
        this.itens = new HashSet<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getEstoque() < quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
        }
        ItemCompra item = new ItemCompra(produto, quantidade);
        itens.add(item);
        calcularValorTotalCompra();
    }

    private void calcularValorTotalCompra() {
        valorTotalCompra = 0;
        for (ItemCompra item : itens) {
            valorTotalCompra += item.getValorTotal();
        }

        if (valorTotalCompra > 1000) {
            valorDesconto = valorTotalCompra * 0.05;
        } else {
            valorDesconto = 0;
        }

        valorPagar = valorTotalCompra - valorDesconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void listarItens() {
        for (ItemCompra item : itens) {
            System.out.println(item.getProduto().getNome() +
                    " - Categoria: " +  item.getProduto().getCategoria().getNome() +
                    " - Quantidade: " + item.getProduto().getEstoque());
        }
    }

    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }
}
