package Final;

public class Cachorro extends Animal{

    public Cachorro(int id) {
        super(id, 0.4, "P", 0);
    }
    public void crescer(){
        this.idade ++;
        this.peso += 0.7;
    }

    @Override
    public String toString() {
        return String.format("CAO %i - %s kg - %i - %s",getId(), getPeso(),getIdade(),getTamanho());
    }
}
