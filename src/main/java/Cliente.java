import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Compra> compras;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.compras = new ArrayList<>();
    }

    public void incluirCompra(Compra compra) {
        compras.add(compra);
    }

    public void removerCompra(Compra compra) {
        compras.remove(compra);
    }

    public void exibirHistoricoCompras(LocalDate dataInicial, LocalDate dataFinal) {
        Iterator<Compra> iterator = compras.iterator();
        while (iterator.hasNext()) {
            Compra compra = iterator.next();
            LocalDate data = compra.getDataCompra();
            if (!data.isBefore(dataInicial) && !data.isAfter(dataFinal)) {
                System.out.println("Compra: " + compra.getNumeroCompra() + " - Valor: " + compra.getValorPagar());
            }
        }
    }
}
