import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String numeroCompra;
    private LocalDate dataCompra;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;
    private List<ItemCompra> itens;
    private Cliente cliente;
    private Vendedor vendedor;

    public Compra(String numeroCompra, LocalDate dataCompra, Cliente cliente, Vendedor vendedor) {
        this.numeroCompra = numeroCompra;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = new ArrayList<>();
    }

    public String getNumeroCompra() {
        return numeroCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void incluirItemCompra(ItemCompra item) {
        itens.add(item);
        calcularValorTotalCompra();
    }

    public void removerItemCompra(ItemCompra item) {
        itens.remove(item);
        item.getProduto().aumentarEstoque(item.getQuantidadeComprada());
        calcularValorTotalCompra();
    }

    public void calcularValorTotalCompra() {
        valorTotalCompra = 0;
        for (ItemCompra item : itens) {
            valorTotalCompra += item.getValorTotal();
        }
        aplicarDesconto();
    }

    private void aplicarDesconto() {
        valorDesconto = valorTotalCompra > 500 ? valorTotalCompra * 0.05 : 0;
        valorPagar = valorTotalCompra - valorDesconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }
}