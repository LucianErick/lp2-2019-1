package Final.Entidades;

public class Servico extends Despesa {

    private int valorHora;
    private int totalHoras;

    public Servico(int id, String nome, int prioridade, int valorHora, int totalHoras) {
        super(id, nome, prioridade);
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
    }

    public int getValorHora() {
        return valorHora;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    @Override
    public int getValorFinal() {
        return this.valorHora * this.totalHoras;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %sh - R$%s/h - R$%s", getId(), getNome(), getPrioridade(), getTotalHoras(), getValorHora(), getValorFinal());
    }
}
