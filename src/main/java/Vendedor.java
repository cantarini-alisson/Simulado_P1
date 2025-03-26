public class Vendedor {
    private String matricula;
    private String nome;

    public Vendedor(String matricula, String nome) {
        if (matricula == null || matricula.trim().isEmpty() || nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para o vendedor.");
        }
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
