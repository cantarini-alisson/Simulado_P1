import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Compra> historicoCompras;

    public Cliente(String nome) {
        this.nome = nome;
        this.historicoCompras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void realizarCompra(Compra compra) {
        historicoCompras.add(compra);
    }

    public void exibirHistoricoCompras() {
        System.out.println("\nHistórico de compras de " + nome + ":");
        for (Compra compra : historicoCompras) {
            System.out.println("Compra ID " + compra.getId() + " - Valor: R$" + compra.getValorPagar());
        }
    }
}
