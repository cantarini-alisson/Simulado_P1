import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try {
            Categoria cozinha = new Categoria("Cozinha");
            Categoria eletrodomesticos = new Categoria("Eletrodomésticos");

            Produto panela = new Produto("Panela", 50.00, 10, cozinha);
            Produto jogoDeCama = new Produto("Jogo de cama", 150.00, 5, cozinha);
            Produto geladeira = new Produto("Geladeira (110v)", 3000.00, 2, eletrodomesticos);

            Cliente maria = new Cliente("Maria");
            Vendedor joao = new Vendedor("João");
            Compra compra = new Compra(maria, joao);

            compra.adicionarItem(panela, 2);
            compra.adicionarItem(jogoDeCama, 1);
            compra.adicionarItem(geladeira, 1);
            maria.realizarCompra(compra);

            maria.exibirHistoricoCompras();

            LocalDateTime dataCompra = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("Data da compra: " + dataCompra.format(formatter));
            System.out.println("Cliente: " + maria.getNome());
            System.out.println("Vendedor: " + joao.getNome());

            System.out.println("\nItens Comprados:");
            compra.listarItens();
            System.out.println("\nTotal da compra: R$" + compra.getValorTotalCompra());
            System.out.println("Desconto aplicado: R$" + compra.getValorDesconto());
            System.out.println("Valor final a pagar: R$" + compra.getValorPagar());

            System.out.println("\nEstoque atualizado após a compra:");
            System.out.println(panela.getNome() + " - Estoque: " + panela.getEstoque());
            System.out.println(jogoDeCama.getNome() + " - Estoque: " + jogoDeCama.getEstoque());
            System.out.println(geladeira.getNome() + " - Estoque: " + geladeira.getEstoque());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}