package Final;

import Final.Entidades.Camera;
import Final.Entidades.Celular;
import Final.Entidades.Desconto.Promocao;
import Final.Entidades.Dispositivo;

import java.util.HashMap;
import java.util.Map;

import static Final.Util.*;

public class NativoTecnologia {

    private Map<String, Dispositivo> mapaDispositivos;
    private Promocao promocao;

    public NativoTecnologia() {
        this.mapaDispositivos = new HashMap<>();
        promocao = null;
    }

    public void cadastrarCelular(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int memoriaGb, int versaoAndroid) {
        validaString(nome, "nome inválido!");
        validaString(modelo, "modelo inválido!");
        validaString(tipoDeTela, "tipo tela inválida!");
        if (ano <= 2000) {
            throw new IllegalArgumentException("Ano inválido!");
        }

        String chave = nome + modelo;
        if (!this.mapaDispositivos.containsKey(chave)) {
            this.mapaDispositivos.put(chave, new Celular(nome,modelo,ano,amperagem,tipoDeTela,memoriaGb,versaoAndroid));
        } else {
            throw new IllegalArgumentException("Dispositivo já cadastrado!");
        }
    }

    public void cadastrarJogo(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int numeroDeJogos, int numeroDeJoysticks) {
        validaString(nome, "nome inválido!");
        validaString(modelo, "modelo inválido!");
        validaString(tipoDeTela, "tipo tela inválida!");
        if (ano <= 2000) {
            throw new IllegalArgumentException("Ano inválido!");
        }

        String chave = nome + modelo;
        if (!this.mapaDispositivos.containsKey(chave)) {
            this.mapaDispositivos.put(chave, new Celular(nome,modelo,ano,amperagem,tipoDeTela, numeroDeJogos, numeroDeJoysticks));
        } else {
            throw new IllegalArgumentException("Dispositivo já cadastrado!");
        }
    }
    public void cadastrarCamera(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int resolucaoMP, String tipoDeSensor) {
        validaString(nome, "nome inválido!");
        validaString(modelo, "modelo inválido!");
        validaString(tipoDeTela, "tipo tela inválida!");
        if (ano <= 2000) {
            throw new IllegalArgumentException("Ano inválido!");
        }

        String chave = nome + modelo;
        if (!this.mapaDispositivos.containsKey(chave)) {
            this.mapaDispositivos.put(chave, new Camera(nome,modelo,ano,amperagem,tipoDeTela,resolucaoMP,tipoDeSensor));
        } else {
            throw new IllegalArgumentException("Dispositivo já cadastrado!");
        }
    }
    public void cadastrarPromocaoPorIdade(int ano, double fator) {

    }

    public String exibirDispositivo(String nome, String modelo) {
        validaString(nome, "nome inválido!");
        validaString(modelo, "modelo inválido!");

        String chave = nome + modelo;
        String saida = "";

        if (this.mapaDispositivos.containsKey(chave)) {
            saida = this.mapaDispositivos.get(chave).toString();
        }else {
            throw new IllegalArgumentException("Dispositivo inválido");
        }
        return saida;
    }


    public double calcularPreco(String nome, String modelo) {
        String chave = nome + modelo;
        return this.mapaDispositivos.get(chave).calcularPreco();
    }
}
