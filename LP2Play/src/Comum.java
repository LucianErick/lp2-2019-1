public class Comum implements Categoria {
    private int pontos;

    public Comum() {
        this.pontos = 0;
    }

    @Override
    public void acumulaPontos(int numeroPontos) {
        this.pontos += numeroPontos;
    }

    @Override
    public double aplicaDesconto(double gasto) {
        return  gasto = 0.95;
    }
}
