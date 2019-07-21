package Final;

import Final.Estrategia.OrdenacaoPorIdade;
import Final.Estrategia.OrdenacaoPorPeso;

import java.util.*;

public class ControleAnimal {
    private Map<Integer, Animal> mapaAnimais;
    private int id;
    private Comparator<Animal> comparadorAnimal;

    public ControleAnimal() {
        this.mapaAnimais = new HashMap<>();
        this.id = 0;
        this.comparadorAnimal = new OrdenacaoPorPeso();
    }

    public int cadastrarCachorroFilhote(){
        this.id++;
        this.mapaAnimais.put(this.id, new Cachorro(this.id));
        return this.mapaAnimais.get(id).getId();
    }
    public int cadastrarElefanteFilhote(){
        this.id++;
        this.mapaAnimais.put(this.id, new Elefante(this.id));
        return this.mapaAnimais.get(id).getId();
    }
    public int cadastrarMorcegoFilhote(){
        this.id++;
        this.mapaAnimais.put(this.id, new Morcego(this.id));
        return this.mapaAnimais.get(id).getId();
    }

    public String exibirAnimal(int id) {
        String saida = "";
        if(!this.mapaAnimais.containsKey(id)) {
            throw new IllegalArgumentException("deu ruim");
        }else{
            saida = this.mapaAnimais.get(id).toString();
        }
        return saida;
    }
    public void crescer(int id) {
        this.mapaAnimais.get(id).crescer();
    }

    public void configurarRemocao(String estrategia) {
        switch (estrategia) {
            case "PESO":
                this.comparadorAnimal = new OrdenacaoPorPeso();
                break;
            case "IDADE":
                this.comparadorAnimal = new OrdenacaoPorIdade();
                break;
            default:
                throw new IllegalArgumentException("Estratégia inexistente!");
        }
    }

    public int remover() {
        List<Animal> animais = new ArrayList<>(this.mapaAnimais.values());
        Animal animal = Collections.max(animais, this.comparadorAnimal);

        this.mapaAnimais.remove(animal.getId());
        return animal.getId();
    }
}