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

    public void adicionarCompra(Compra compra) {
        historicoCompras.add(compra);
    }

    public void exibirHistorico() {
        System.out.println("Histórico de compras de " + nome + ":");
        for (Compra compra : historicoCompras) {
            compra.exibirItens();
        }
    }
}