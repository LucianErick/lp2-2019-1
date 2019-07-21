package Final.Entidades;

public class Celular extends Dispositivo{
    private int memoriaInterna;
    private int versaoAndroid;

    public Celular(String nome, String modelo, int anoFabricacao, int amperagem, String tipoTela, int memoriaInterna, int versaoAndroid) {
        super(nome, modelo, anoFabricacao, amperagem, tipoTela);
        this.memoriaInterna = memoriaInterna;
        this.versaoAndroid = versaoAndroid;
    }
    public double calcularPreco(){
        double preco = 10 * ((getAnoFabricacao() - 2000) * getMemoriaInterna()) / (32 *  getVersaoAndroid());
        return preco;
    }

    public int getMemoriaInterna() {
        return memoriaInterna;
    }

    public int getVersaoAndroid() {
        return versaoAndroid;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - %s (%s)", getNome(), getModelo(), getTipoTela(), getMemoriaInterna(), getVersaoAndroid());
    }
}
