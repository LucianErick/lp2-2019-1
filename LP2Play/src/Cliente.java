public class Cliente {

    private double dinheiro;
    private Categoria categoria;

    public Cliente(double dinheiro) {
        this.dinheiro = dinheiro;
        this.categoria = new Comum();
    }

    public void comprar(double preco) {
        double aPagar = 0;
        if (this.categoria.getClass() == Vip.class) {
            aPagar = categoria.aplicaDesconto(preco);
            this.categoria.acumulaPontos(10);
        }
        else if (this.categoria.getClass() == Comum.class) {
            aPagar = categoria.aplicaDesconto(preco);
            this.categoria.acumulaPontos(5);
        }
        this.dinheiro -= aPagar;
    }

    public void mudaCategoria(String novaCategoria) {

        switch (novaCategoria.toUpperCase()) {
            case "VIP":
                this.categoria = new Vip();
                break;
            case "COMUM":
                this.categoria = new Comum();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!!");
        }
    }
}
