package Final;

public class Elefante extends Animal{

    public Elefante(int id) {
        super(id, 120.0, "G", 0);
    }

    public void crescer(){
        this.idade ++;

        if(this.idade <= 20) {
            this.peso += 250.0;
        }
    }

    @Override
    public String toString() {
        return String.format("FANTE %i - %s kg - %i - %s", getId(), getPeso(), getIdade(), getTamanho());
    }
}
