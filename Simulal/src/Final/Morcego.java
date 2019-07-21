package Final;

public class Morcego extends Animal{

    public Morcego(int id) {
        super(id, 0.002, "P", 0);
    }
    public void crescer() {
        this.idade ++;
        this.peso += 0.002;
    }
    @Override
    public String toString() {
        return String.format("BAT %i - %s kg - %i - %s",getId(),getPeso(),getIdade(),getTamanho());
    }
}
