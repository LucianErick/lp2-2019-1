package Final;

public abstract class Animal {
    protected int idade;
    protected double peso;
    protected String tamanho;
    protected int id;

    public Animal(int id, double peso, String tamanho, int idade) {
        this.idade = 0;
        this.peso = peso;
        this.tamanho = tamanho;
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public int getId() {
        return id;
    }
    public abstract void crescer();

    @Override
    public abstract String toString();
}
