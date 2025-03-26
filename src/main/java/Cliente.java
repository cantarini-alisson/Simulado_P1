import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Compra> historicoCompras;

    public Cliente(String cpf, String nome) {
        if (cpf == null || cpf.trim().isEmpty() || nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para o cliente.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.historicoCompras = new ArrayList<>();
    }

    public void incluirCompra(Compra compra) {
        if (compra == null) {
            throw new IllegalArgumentException("A compra não pode ser nula.");
        }
        historicoCompras.add(compra);
    }

    public void exibirHistoricoCompras() {
        System.out.println("Histórico de compras de " + nome + " (CPF: " + cpf + ")");
        System.out.println("===================================================");
        for (Compra compra : historicoCompras) {
            compra.exibirDetalhesCompra();
        }
    }
}
