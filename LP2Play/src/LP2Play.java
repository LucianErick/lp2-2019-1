public class LP2Play {

    private Cliente cliente;

    public void comprar(double gasto) {
        this.cliente.comprar(gasto);
    }

    public void mudarCategoria(String novaCategoria) {
        this.cliente.mudaCategoria(novaCategoria);
    }
}
