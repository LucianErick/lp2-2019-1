package Final;

import java.util.HashMap;
import java.util.Map;

public class GrupoEstudo {
    private String tema;
    private Map<String, Aluno> grupoEstudo;

    public GrupoEstudo(String tema) {
        this.tema = tema;
        this.grupoEstudo = new HashMap<>();
    }

    public String getTema() {
        return tema;
    }

    public Map<String, Aluno> getGrupoEstudo() {
        return grupoEstudo;
    }

    public String exibirGrupo() {
        String saida = "";
        for (Aluno aluno : this.grupoEstudo.values()) {
            saida += "*" + aluno.toString() + "\n";
        }
        if (saida.length() > 0) {
            saida = saida.substring(saida.length() - 1);
        }
        return saida;
    }

    public void adicionarAluno(String matricula, Aluno aluno) {
        this.grupoEstudo.put(matricula, aluno);
    }
}
