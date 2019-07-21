public class Vip implements Categoria{
    private int pontos;

    public Vip() {
        this.pontos = 0;
    }

    @Override
    public void acumulaPontos(int numeroPontos) {
        this.pontos += numeroPontos;
    }

    @Override
    public double aplicaDesconto(double gasto) {
       return gasto = gasto * 0.9;
    }
}
