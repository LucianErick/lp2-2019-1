package Final.Estrategia;

import Final.Animal;

import java.util.Comparator;

public class OrdenacaoPorIdade implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getIdade() - o2.getIdade();
    }
}
