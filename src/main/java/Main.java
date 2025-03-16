public class Main {
    public static void main(String[] args) {
        try {
            Produto panela = new Produto("Panela", 50.00, 10);
            Produto jogoDeCama = new Produto("Jogo de cama", 150.00, 5);
            Produto geladeira = new Produto("Geladeira (110v)", 3000.00, 2);

            Cliente maria = new Cliente("Maria");
            Compra compra = new Compra(maria);
            compra.adicionarItem(panela, 2);
            compra.adicionarItem(jogoDeCama, 1);
            compra.adicionarItem(geladeira, 1);
            maria.realizarCompra(compra);

            System.out.println("Total a pagar: R$ " + compra.getValorPagar());
            maria.exibirHistoricoCompras();

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}