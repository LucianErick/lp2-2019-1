package Final.Entidades;

import java.util.Objects;

public abstract class Despesa {

    protected String nome;
    protected int prioridade;
    protected int id;

    public Despesa(int id, String nome, int prioridade) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getId() {
        return id;
    }

    public abstract int getValorFinal();

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Despesa)) return false;
        Despesa despesa = (Despesa) o;
        return getId() == despesa.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
