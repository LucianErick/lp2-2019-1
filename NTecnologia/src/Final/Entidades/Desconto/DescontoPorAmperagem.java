package Final.Entidades.Desconto;

public class DescontoPorAmperagem implements Promocao{
    private int amperagem;
    private double fator;

    public DescontoPorAmperagem(int amperagem, double fator) {
        this.amperagem = amperagem;
        this.fator = fator;
    }

    @Override
    public void acabarPromocao() {
        this.fator = 1;
    }
}
