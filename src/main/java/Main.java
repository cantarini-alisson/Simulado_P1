public class Main {
    public static void main(String[] args) {
        Produto panela = new Produto("Panela", 50.0, 10);
        Produto jogoDeCama = new Produto("Jogo de Cama", 150.0, 5);
        Produto geladeira = new Produto("Geladeira", 3000.0, 2);

        Cliente maria = new Cliente("Maria");

        Compra compra1 = new Compra();
        compra1.adicionarItem(panela, 2);
        compra1.adicionarItem(jogoDeCama, 1);

        maria.adicionarCompra(compra1);

        Compra compra2 = new Compra();
        compra2.adicionarItem(geladeira, 1);

        maria.adicionarCompra(compra2);

        maria.exibirHistorico();

        System.out.println("\nEstoque atual:");
        System.out.println(panela);
        System.out.println(jogoDeCama);
        System.out.println(geladeira);
    }
}