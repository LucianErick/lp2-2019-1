package Final.Entidades;

public class Camera extends Dispositivo{
    private int resolucao;
    private String tipoSensor;

    public Camera(String nome, String modelo, int anoFabricacao, int amperagem, String tipoTela, int resolucao, String tipoSensor) {
        super(nome, modelo, anoFabricacao, amperagem, tipoTela);
        this.resolucao = resolucao;
        this.tipoSensor = tipoSensor;
    }
    public double calcularPreco() {
        double preco = 0.0;
        if (getTipoSensor().equals("CCD")) {
            preco = (10 * (getAnoFabricacao() - 2000)) * getResolucao();
        }else if(getTipoSensor().equals("CMOS")) {
            preco = ((10 * (getAnoFabricacao() - 2000)) * getResolucao()) / 2;
        } else {
            throw new IllegalArgumentException("Tipo inválido");
        }
        return preco;
    }

    public int getResolucao() {
        return resolucao;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s (%s)", getNome(), getModelo(), getTipoSensor(), getResolucao());
    }
}
