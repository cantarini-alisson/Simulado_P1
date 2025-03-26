import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Compra> historicoCompras;

    public Cliente(String cpf, String nome) {
        if (cpf == null || cpf.trim().isEmpty() || nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para o clientes.");
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

    public void exibirHistoricoCompras(LocalDate dataInicial, LocalDate dataFinal) {
        System.out.println();
        System.out.println("Histórico de compras de " + nome + " (CPF: " + cpf + ") entre " + dataInicial + " e " + dataFinal);
        System.out.println();
        System.out.println("===================================================");

        boolean encontrouCompras = false;
        for (Compra compra : historicoCompras) {
            if (!compra.getDataCompra().isBefore(dataInicial) && !compra.getDataCompra().isAfter(dataFinal)) {
                compra.exibirDetalhesCompra();
                encontrouCompras = true;
            }
        }

        if (!encontrouCompras) {
            System.out.println("Nenhuma compra encontrada nesse período.");
        }
    }
}
