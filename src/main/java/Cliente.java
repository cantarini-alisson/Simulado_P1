import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Compra> historicoCompras;

    public Cliente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        this.nome = nome;
        this.historicoCompras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void realizarCompra(Compra compra) {
        historicoCompras.add(compra);
    }

    public List<Compra> getHistoricoCompras() {
        return new ArrayList<>(historicoCompras);
    }

    public void exibirHistoricoCompras() {
        for (Compra compra : historicoCompras) {
            System.out.println(compra);
        }
    }

    public Iterator<Compra> getComprasIterator() {
        return historicoCompras.iterator();
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " - Compras: " + historicoCompras.size();
    }
}