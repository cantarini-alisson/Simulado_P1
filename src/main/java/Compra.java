import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Compra {
    private List<ItemCompra> itens;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;
    private Cliente cliente;
    private Vendedor vendedor;

    public Compra(Cliente cliente, Vendedor vendedor) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        try {
            ItemCompra item = new ItemCompra(produto, quantidade);
            itens.add(item);
            calcularValorTotalCompra();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    private void calcularValorTotalCompra() {
        valorTotalCompra = 0;
        for (ItemCompra item : itens) {
            valorTotalCompra += item.getValorTotal();
        }
        valorDesconto = (valorTotalCompra > 1000) ? valorTotalCompra * 0.05 : 0;
        valorPagar = valorTotalCompra - valorDesconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void listarItens() {
        Iterator<ItemCompra> iterator = itens.iterator();
        while (iterator.hasNext()) {
            ItemCompra item = iterator.next();
            System.out.println(item.getProduto().getNome() + " - Quantidade: " + item.getProduto().getEstoque());
        }
    }
}