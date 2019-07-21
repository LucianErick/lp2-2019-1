package Final.Entidades;

import Final.Entidades.Desconto.Promocao;

import java.util.Objects;

public abstract class Dispositivo {

    protected String nome;
    protected String modelo;
    protected int anoFabricacao;
    protected int amperagem;
    protected String tipoTela;

    public Dispositivo(String nome, String modelo, int anoFabricacao, int amperagem, String tipoTela) {
        this.nome = nome;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.amperagem = amperagem;
        this.tipoTela = tipoTela;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getAmperagem() {
        return amperagem;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public abstract double calcularPreco();

    public abstract void ()

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(modelo, that.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, modelo);
    }
}
