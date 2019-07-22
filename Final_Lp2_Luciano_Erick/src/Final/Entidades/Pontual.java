package Final.Entidades;

public class Pontual extends Despesa {

    private int valorOriginal;
    private int valorDesconto;

    public Pontual(int id, String nome, int prioridade, int valorOriginal, int valorDesconto) {
        super(id, nome, prioridade);
        this.valorOriginal = valorOriginal;
        this.valorDesconto = valorDesconto;
    }

    @Override
    public int getValorFinal() {
        return this.valorOriginal - this.valorDesconto;
    }

    public int getValorOriginal() {
        return valorOriginal;
    }

    public int getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - R$ %s - R$ %s - R$ %s", getId(), getNome(), getPrioridade(), getValorOriginal(), getValorDesconto(), getValorFinal());
    }
}
