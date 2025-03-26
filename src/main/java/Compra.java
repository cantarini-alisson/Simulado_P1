import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String numeroCompra;
    private LocalDate dataCompra;
    private double valorTotalCompra;
    private List<ItemCompra> itens;
    private Cliente cliente;
    private Vendedor vendedor;

    public Compra(String numeroCompra, Cliente cliente, Vendedor vendedor) {
        if (numeroCompra == null || cliente == null || vendedor == null) {
            throw new IllegalArgumentException("Dados inválidos para a compra.");
        }
        this.numeroCompra = numeroCompra;
        this.dataCompra = LocalDate.now();
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public void incluirItemCompra(ItemCompra itemCompra) {
        if (itemCompra == null) {
            throw new IllegalArgumentException("O item da compra não pode ser nulo.");
        }
        itens.add(itemCompra);
        calcularValorTotalCompra();
    }

    private void calcularValorTotalCompra() {
        valorTotalCompra = itens.stream().mapToDouble(ItemCompra::getValorTotal).sum();
    }

    public String getNumeroCompra() {
        return numeroCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public double getValorPagar() {
        return valorTotalCompra;
    }

    public void exibirDetalhesCompra() {
        System.out.println("Compra nº " + numeroCompra + " | Data: " + dataCompra);
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Itens da compra:");
        for (ItemCompra item : itens) {
            System.out.println(" - " + item.getQuantidadeComprada() +
                    " " + item.getProduto().getDescricao() +
                    " (R$ " + item.getProduto().getPrecoUnitario() +
                    " cada) -> Total: R$ " + item.getValorTotal());
        }
        System.out.println("Total a pagar: R$ " + valorTotalCompra);
        System.out.println("---------------------------------------------------");
    }
}
