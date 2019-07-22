package Final.Categoria;

import Final.Entidades.Despesa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Categoria {

    private String nome;
    private String descricao;
    private Set<Despesa> despesas;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.despesas = new HashSet<>();
    }

    public void adicionaDespesa(Despesa despesa) {
        this.despesas.add(despesa);
    }

    public String exibirDespesas() {
        String saida = String.format("%s - %s", getNome(), getDescricao());
        for (Despesa despesa : despesas) {
            saida += despesa.toString() + "\n";
        }
        return saida;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Despesa> getDespesas() {
        return despesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(getNome(), categoria.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

}
