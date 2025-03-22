import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Categoria cozinha = new Categoria("Cozinha");
            Categoria eletrodomesticos = new Categoria("Eletrodomésticos");

            Produto panela = new Produto("Panela", 50.00, 10, cozinha);
            Produto jogoDeCama = new Produto("Jogo de Cama", 150.00, 5, cozinha);
            Produto geladeira = new Produto("Geladeira (110v)", 3000.00, 2, eletrodomesticos);

            Cliente maria = new Cliente("Maria");
            Vendedor joao = new Vendedor("João");

            Compra compra = new Compra(maria, joao, LocalDate.now());
            compra.adicionarItem(panela, 2);
            compra.adicionarItem(jogoDeCama, 1);
            compra.adicionarItem(geladeira, 5);
            maria.realizarCompra(compra);

            System.out.println("\n===== Detalhes da Compra =====");
            System.out.println("Número da Compra: " + compra.getId());
            System.out.println("Data da Compra: " + compra.getData());
            System.out.println("Cliente: " + maria.getNome());
            System.out.println("Vendedor: " + joao.getNome());
            compra.listarItens();
            System.out.println("Valor Total da Compra: R$" + compra.getValorPagar());

            System.out.println("\n===== Estoque Atualizado =====");
            panela.exibirEstoque();
            jogoDeCama.exibirEstoque();
            geladeira.exibirEstoque();

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
