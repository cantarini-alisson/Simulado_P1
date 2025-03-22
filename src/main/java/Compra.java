import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private static int contadorId = 1;
    private int id;
    private List<ItemCompra> itens;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;
    private Cliente cliente;
    private Vendedor vendedor;
    private LocalDate data;

    public Compra(Cliente cliente, Vendedor vendedor, LocalDate data) {
        this.id = contadorId++;
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.data = data;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade > produto.getEstoque()) {
            throw new IllegalArgumentException("Estoque insuficiente para " + produto.getNome());
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
        valorDesconto = (valorTotalCompra > 1000) ? valorTotalCompra * 0.05 : 0;
        valorPagar = valorTotalCompra - valorDesconto;
    }

    public void listarItens() {
        System.out.println("\nItens da Compra:");
        for (ItemCompra item : itens) {
            System.out.println("- Produto: " + item.getProduto().getNome());
            System.out.println("  Categoria: " + item.getProduto().getCategoria().getNome());
            System.out.println("  Quantidade: " + item.getQuantidade());
            System.out.println("  Valor Total do Item: R$" + item.getValorTotal());
        }
    }

    public int getId() {
        return id;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public LocalDate getData() {
        return data;
    }
}
