package Final.Sistema;

import Final.Categoria.Categoria;
import Final.Entidades.Despesa;
import Final.Entidades.Pontual;
import Final.Entidades.Servico;

import java.util.*;

import static Final.Util.Validador.*;

public class FinAL {
    private Map<String, Categoria> mapaCategorias;
    private Map<Integer, Despesa> mapaDespesas;
    private int id;
    private Comparator ordenacaoDespesaMaisCara;

    public FinAL() {
        this.mapaDespesas = new HashMap<>();
        this.mapaCategorias = new HashMap<>();
        this.id = 0;
    }

    public Map<Integer, Despesa> getMapaDespesas() {
        return mapaDespesas;
    }

    public Map<String, Categoria> getMapaCategorias() {
        return mapaCategorias;
    }

    public int getId() {
        return id;
    }

    public int cadastrarServico(String nome, int prioridade, int valorPorHora, int horas) {
        validadaString(nome, "Nome nao pode ser vazio ou nulo");
        this.mapaDespesas.put(this.id, new Servico(this.id, nome, prioridade, valorPorHora, horas));
        this.id++;
        return getId();
    }

    public int cadastrarPontual(String nome, int prioridade, int valorOriginal, int desconto) {
        validadaString(nome, "Nome nao pode ser vazio ou nulo");
        this.mapaDespesas.put(this.id, new Pontual(this.id, nome, prioridade, valorOriginal, desconto));
        this.id++;
        return getId();
    }

    public int getValorFinal(int id) {
        int valor = 0;
        if (!this.mapaDespesas.containsKey(id)) {
            throw new IllegalArgumentException("Despesa nao cadastrada.");
        }
        else if (this.mapaDespesas.containsKey(id)) {
            valor = this.mapaDespesas.get(id).getValorFinal();
        }
        return valor;
    }

    public String exibirDespesa(int id) {
        String saida = "";
        if (!this.mapaDespesas.containsKey(id)) {
            throw new IllegalArgumentException("Despesa nao cadastrada.");
        }
        else if (this.mapaDespesas.containsKey(id)) {
            saida = this.mapaDespesas.get(id).toString();
        }
        return saida;
    }

    public void cadastrarCategoria(String nome, String descricao) {
        validadaString(nome, "nome nao pode ser vazio ou nulo");
        validadaString(descricao, "descricao nao pode ser vazia ou nula");

        if (this.mapaCategorias.containsKey(nome)) {
            throw new IllegalArgumentException("categoria ja cadastrada");
        }
        else {
            this.mapaCategorias.put(nome, new Categoria(nome, descricao));
        }
    }

    public void associarDespesaACategoria(String nome, int id) {
        if(!this.mapaCategorias.containsKey(nome)) {
            throw new IllegalArgumentException("categoria nao existe");
        }
        if (!this.mapaDespesas.containsKey(id)) {
            throw new IllegalArgumentException("despesa nao existe");
        }
        else {
            this.mapaCategorias.get(nome).adicionaDespesa(this.mapaDespesas.get(id));
        }
    }

    public String exibirDespesasEmCategoria(String nome) {
        validadaString(nome, "nome nao pode ser vazio ou nulo");
        if(!this.mapaCategorias.containsKey(nome)) {
            throw new IllegalArgumentException("categoria nao existe");
        }
        return this.mapaCategorias.get(nome).exibirDespesas();
    }

    public int despesaMaisCara(String nome) {
        Despesa despesa = Collections.max(this.mapaCategorias.get(nome).getDespesas(), ordenacaoDespesaMaisCara);
        return despesa.getId();
    }
}


