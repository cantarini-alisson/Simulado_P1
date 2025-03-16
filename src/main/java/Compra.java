import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Compra implements Iterable<ItemCompra> {
    private List<ItemCompra> itens;
    private double valorTotalCompra;
    private double valorDesconto;
    private double valorPagar;
    private Cliente cliente;

    public Compra(Cliente cliente) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemCompra item = new ItemCompra(produto, quantidade);
        itens.add(item);
        calcularValores();
    }

    private void calcularValores() {
        valorTotalCompra = itens.stream().mapToDouble(ItemCompra::getValorTotal).sum();
        valorDesconto = (valorTotalCompra > 1000) ? valorTotalCompra * 0.05 : 0;
        valorPagar = valorTotalCompra - valorDesconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCompra> getItens() {
        return new ArrayList<>(itens);
    }

    @Override
    public Iterator<ItemCompra> iterator() {
        return itens.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Compra de " + cliente.getNome() + "\n");
        for (ItemCompra item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Total a pagar: R$ ").append(valorPagar);
        return sb.toString();
    }
}