import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando categorias
            Categoria eletronico = new Categoria("Eletrônico");
            Categoria vestuario = new Categoria("Vestuário");

            // Criando produtos
            Produto celular = new Produto("Smartphone", 1500.00, 10, eletronico);
            Produto laptop = new Produto("Notebook", 3000.00, 5, eletronico);
            Produto camiseta = new Produto("Camiseta Polo", 50.00, 20, vestuario);

            // Criando vendedores
            Vendedor vendedor1 = new Vendedor("12346", "Carlos Silva");
            Vendedor vendedor2 = new Vendedor("67890", "Mariana Costa");

            // Criando clientes
            Cliente cliente1 = new Cliente("111.222.333-44", "Ana Souza");
            Cliente cliente2 = new Cliente("555.666.777-88", "Lucas Oliveira");

            // Criando compras
            Compra compra1 = new Compra("0001", cliente1, vendedor1, LocalDate.of(2024, 3, 10));
            ItemCompra item1 = new ItemCompra(celular, 1);
            ItemCompra item2 = new ItemCompra(camiseta, 2);
            compra1.incluirItemCompra(item1);
            compra1.incluirItemCompra(item2);

            Compra compra2 = new Compra("0002", cliente2, vendedor2, LocalDate.of(2024, 3, 12));
            ItemCompra item3 = new ItemCompra(laptop, 1);
            ItemCompra item4 = new ItemCompra(celular, 1);
            compra2.incluirItemCompra(item3);
            compra2.incluirItemCompra(item4);

            // Associando compras aos clientes
            cliente1.incluirCompra(compra1);
            cliente2.incluirCompra(compra2);

            // Exibindo histórico de compras
            System.out.println("\n=== Histórico de Compras ===");
            compra1.exibirDetalhesCompra();
            compra2.exibirDetalhesCompra();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
