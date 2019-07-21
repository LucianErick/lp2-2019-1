import java.util.ArrayList;
import java.util.List;

public class BibliotecaCriptografia {

    private List<String> textosOriginais;
    private Criptografia algoritmo;

    public BibliotecaCriptografia() {
        this.textosOriginais = new ArrayList<>();
        algoritmo = new ROT13();
    }

    public String criptografar(String texto) {
        this.textosOriginais.add(texto);
        return algoritmo.criptografar(texto);
    }

    public void configurarAlgoritmo(String algoritmo) {
        switch (algoritmo.toUpperCase()) {
            case "EXP":
                this.algoritmo = new EXP();
                break;
            case "L33T":
                this.algoritmo = new L33T();
                break;
            case "ROT13":
                this.algoritmo = new ROT13();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }
    public String listarTextosOriginais() {
        String saida = "";
        for (int i = 0; i < this.textosOriginais.size(); i++) {
        saida += (i < this.textosOriginais.size() - 1) ? this.textosOriginais.get(i) + "\n" : this.textosOriginais.get(i);
        }
        return saida;
    }


}
