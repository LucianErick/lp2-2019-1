package Estrategia;

public class Pulinhos implements Estrategia{

    private String nome;
    private double metrosMinuto;
    private double energia;

    public Pulinhos(String nome, double metrosMinuto, double energia) {
        this.nome = nome;
        this.metrosMinuto = metrosMinuto;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public double getMetrosMinuto() {
        return metrosMinuto;
    }

    public double getEnergia() {
        return energia;
    }

    @Override
    public void correr(int minutos) {
        this.energia *= minutos;
        this.metrosMinuto *= minutos;
    }
}
