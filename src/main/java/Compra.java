import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<ItemCompra> itens;

    public Compra() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemCompra item = new ItemCompra(produto, quantidade);
        itens.add(item);
    }

    public double getValorTotal() {
        double total = 0;
        for (ItemCompra item : itens) {
            total += item.getValorTotal();
        }
        return total;
    }

    public void exibirItens() {
        System.out.println("Itens da compra:");
        for (ItemCompra item : itens) {
            System.out.println("- " + item);
        }
        System.out.println("Total da compra: R$ " + getValorTotal());
    }
}