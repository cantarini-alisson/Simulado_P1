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
            Vendedor vendedor1 = new Vendedor("12345", "Carlos Silva");
            Vendedor vendedor2 = new Vendedor("67890", "Mariana Costa");

            // Criando clientes
            Cliente cliente1 = new Cliente("111.222.333-44", "Ana Souza");
            Cliente cliente2 = new Cliente("555.666.777-88", "Lucas Oliveira");

            // Criando compras
            Compra compra1 = new Compra("0001", cliente1, vendedor1);
            compra1.incluirItemCompra(new ItemCompra(celular, 1));
            compra1.incluirItemCompra(new ItemCompra(camiseta, 2));

            Compra compra2 = new Compra("0002", cliente2, vendedor2);
            compra2.incluirItemCompra(new ItemCompra(laptop, 1));
            compra2.incluirItemCompra(new ItemCompra(celular, 1));

            // Associando compras aos clientes
            cliente1.incluirCompra(compra1);
            cliente2.incluirCompra(compra2);

            // Exibindo histórico de compras com detalhes
            cliente1.exibirHistoricoCompras();
            cliente2.exibirHistoricoCompras();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
