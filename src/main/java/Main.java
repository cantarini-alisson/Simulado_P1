import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Categoria eletrodomestico = new Categoria("Eletrodoméstico");
            Categoria utensilio = new Categoria("Utensílio Doméstico");

            Produto panela = new Produto("Panela", 50.00, 10, utensilio);
            Produto jogoDeCama = new Produto("Jogo de cama", 150.00, 5, utensilio);
            Produto geladeira = new Produto("Geladeira", 3000.00, 2, eletrodomestico);

            Cliente maria = new Cliente("12345678900", "Maria");
            Vendedor joao = new Vendedor("V001", "João");

            Compra compra = new Compra("COMP123", LocalDate.now(), maria, joao);

            compra.incluirItemCompra(new ItemCompra(panela, 2));
            compra.incluirItemCompra(new ItemCompra(jogoDeCama, 1));
            compra.incluirItemCompra(new ItemCompra(geladeira, 1));

            maria.incluirCompra(compra);

            System.out.println("Total a pagar: " + compra.getValorPagar());
            System.out.println("\nHistórico de Compras do Cliente:");
            maria.exibirHistoricoCompras(LocalDate.of(2024, 1, 1), LocalDate.now());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
