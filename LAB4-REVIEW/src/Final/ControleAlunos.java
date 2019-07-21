package Final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Final.Util.*;

public class ControleAlunos {

    private Map<String, Aluno> mapaAlunos;
    private Map<String, GrupoEstudo> mapaGrupos;
    private List<Aluno> alunosResponderam;

    public ControleAlunos() {
        this.mapaAlunos = new HashMap<>();
        this.mapaGrupos = new HashMap<>();
        this.alunosResponderam = new ArrayList<>();
    }

    public String cadastrarAluno(String matricula, String nome, String curso) {
        String saida = "";
        validaString(matricula, "matricula inválida!");
        validaString(nome, "nome inválido!");
        validaString(curso, "curso inválido!");

        if (!this.mapaAlunos.containsKey(matricula)) {
            this.mapaAlunos.put(matricula, new Aluno(matricula, nome, curso));
            saida = "CADASTRO REALIZADO!";
        } else {
            saida = "MATRÍCULA JÁ CADASTRADA!";
        }
        return saida;
    }

    public String consultarAluno(String matricula) {
        String saida = "";
        validaString(matricula, "matricula inválida!");
        if (!this.mapaAlunos.containsKey(matricula)) {
            throw new IllegalArgumentException("aluno não cadastrado!");
        } else {
            saida = this.mapaAlunos.get(matricula).toString();
        }
        return saida;
    }

    public String cadastrarGrupo(String tema) {
        String saida = "";
        validaString(tema, "tema inválido!");
        if (this.mapaGrupos.containsKey(tema)) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
        } else {
            this.mapaGrupos.put(tema, new GrupoEstudo(tema));
            saida = "CADASTRO REALIZADO!";
        }
        return saida;
    }

    public String alocarAluno(String matricula, String tema) {
        String saida = "";
        validaString(matricula, "matrícula inválida!");
        validaString(tema, "tema inválido!");

        if (!this.mapaAlunos.containsKey(matricula)) {
            throw new IllegalArgumentException("aluno não cadastrado!");
        }
        if (!this.mapaGrupos.containsKey(tema)) {
            throw new IllegalArgumentException("grupo não cadastrado!");
        }
        else {
            this.mapaGrupos.get(tema).adicionarAluno(matricula, this.mapaAlunos.get(matricula));
            saida = "ALUNO ALOCADO!";
        }
        return saida;
    }

    public String imprimirGrupo(String tema) {
        return this.mapaGrupos.get(tema).exibirGrupo();
    }

    public String cadastrarAlunoQueRespondeu(String matricula) {
        String saida = "";
        validaString(matricula, "matrícula inválida!");
        if (!this.mapaGrupos.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não cadastrado!");
        } else {
            this.alunosResponderam.add(this.mapaAlunos.get(matricula));
            saida = "ALUNO REGISTRADO!";
        }
        return saida;
    }

    public String imprimirAlunosResponderam() {
        String saida = "Alunos:\n";
        for (int i = 0; i < this.alunosResponderam.size(); i++) {
            saida += String.format("%d. %s\n", (i + 1), this.alunosResponderam.get(i).toString());
        }
        if (saida.length() > 0 ) {
            saida = saida.substring(saida.length()- 1);
        }
        return saida;
    }
}

