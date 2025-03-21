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

            System.out.println("Total a pagar: " + compra.getValorPagar());
            maria.exibirHistoricoCompras();
            compra.listarItens();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}