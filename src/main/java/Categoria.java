public class Categoria {
    private String descricao;

    public Categoria(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da categoria não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}