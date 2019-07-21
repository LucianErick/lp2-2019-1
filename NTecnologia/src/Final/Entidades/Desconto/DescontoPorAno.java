package Final.Entidades.Desconto;

public class DescontoPorAno implements Promocao{

    private int ano;
    private double fator;

    public DescontoPorAno(int ano, double fator) {
        this.ano = ano;
        this.fator = fator;
    }

    @Override
    public void acabarPromocao() {
        this.fator = 1;
    }
}

