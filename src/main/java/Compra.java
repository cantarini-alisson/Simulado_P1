import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Compra {
    private Set<ItemCompra> itens;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;
    private Cliente cliente;
    private Vendedor vendedor;
    private static Map<Produto, Integer> estoque = new HashMap<>();

    public Compra(Cliente cliente, Vendedor vendedor) {
        this.itens = new HashSet<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getEstoque() < quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
        }
        ItemCompra item = new ItemCompra(produto, quantidade);
        itens.add(item);
        calcularValorTotalCompra();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }

    private void calcularValorTotalCompra() {
        valorTotalCompra = itens.stream().mapToDouble(ItemCompra::getValorTotal).sum();
        valorDesconto = (valorTotalCompra > 1000) ? valorTotalCompra * 0.05 : 0;
        valorPagar = valorTotalCompra - valorDesconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void listarItens() {
        for (ItemCompra item : itens) {
            System.out.println(item.getProduto().getNome() + " - Categoria: " +
                    item.getProduto().getCategoria().getNome() +
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
