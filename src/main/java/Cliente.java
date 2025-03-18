import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Compra> historicoCompras;

    public Cliente(String nome) {
        this.nome = nome;
        this.historicoCompras = new ArrayList<>();
    }

    public void realizarCompra(Compra compra) {
        historicoCompras.add(compra);
    }

    public void exibirHistoricoCompras() {
        for (Compra compra : historicoCompras) {
            System.out.println("Compra realizada por " + nome + " com valor total: " + compra.getValorPagar());
        }
    }
}