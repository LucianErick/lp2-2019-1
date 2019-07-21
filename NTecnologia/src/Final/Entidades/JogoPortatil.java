package Final.Entidades;

public class JogoPortatil extends Dispositivo {
    private int numeroJogos;
    private int numeroJoysticks;

    public JogoPortatil(String nome, String modelo, int anoFabricacao, int amperagem, String tipoTela, int numeroJogos, int numeroJoysticks) {
        super(nome, modelo, anoFabricacao, amperagem, tipoTela);
        this.numeroJogos = numeroJogos;
        this.numeroJoysticks = numeroJoysticks;
    }

    public int getNumeroJogos() {
        return numeroJogos;
    }
    public double calcularPreco() {
        double preco = (10 * (getAnoFabricacao() - 2000) * getAmperagem()) / (1000 + (100 * (getNumeroJogos())));
        return preco;
    }


    public int getNumeroJoysticks() {
        return numeroJoysticks;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s / %s", getNome(), getModelo(), getNumeroJogos(), getNumeroJoysticks());
    }
}
