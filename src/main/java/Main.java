import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Map<String, Produto> produtos = new HashMap<>();
            produtos.put("Panela", new Produto("Panela", 50.00, 10));
            produtos.put("Jogo de cama", new Produto("Jogo de cama", 150.00, 5));
            produtos.put("Geladeira", new Produto("Geladeira (110v)", 3000.00, 2));

            Cliente maria = new Cliente("Maria");
            Compra compra = new Compra(maria);

            compra.adicionarItem(produtos.get("Panela"), 2);
            compra.adicionarItem(produtos.get("Jogo de cama"), 1);
            compra.adicionarItem(produtos.get("Geladeira"), 1);

            maria.realizarCompra(compra);

            System.out.println("Total a pagar: R$ " + compra.getValorPagar());
            maria.exibirHistoricoCompras();

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}