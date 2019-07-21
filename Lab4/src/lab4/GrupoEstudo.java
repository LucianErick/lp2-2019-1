package lab4;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representação de um grupo de estudos, contendo as devidas informações.
 * @author Luciano Erick Sousa Figueiredo Filho - Matrícula: 118110400
 */

public class GrupoEstudo {
    /**
     * O tema (ou nome) de um determinado grupo, do tipo String.
     */
    private String tema;
    /**
     * Um conjunto do tipo aluno, representando um grupo de alunos.
     */
    private HashSet<Aluno> grupoAlunos;

    /**
     * Constrói um grupo de estudos, passando um tema, caso seja válido, como referência.
     * @param tema o tema, ou nome, de um grupo.
     */
    public GrupoEstudo(String tema) {
        if (tema == null || "".equals(tema.trim())) {
            throw new IllegalArgumentException("Tema inválido!");
        }
        this.tema = tema;
        this.grupoAlunos = new HashSet<>();
    }

    /**
     * Pega o tema que identifica o grupo.
     * @return o tema do grupo.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Aloca um determinado aluno no grupo de tema x.
     * @param aluno o aluno a ser adicionado ao grupo.
     * @return uma String avisando que o aluno foi alocado.
     */
    public String alocarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno inválido!");
        }
        this.grupoAlunos.add(aluno);
        return "ALUNO ALOCADO!";
    }

    /**
     * Imprime os alunos de um determinado grupo.
     * @return o alunos de um grupo.
     */
    public String imprimeAlunos(){
        String saida = "";
        for (Aluno aluno : this.grupoAlunos) {
            saida += "* " + aluno.toString() + Utilidades.quebralinha(1);
        }
        return saida;
    }

    /**
     * Verifica se dois grupos são iguais a partir do tema.
     * @param o
     * @return um valor booleano dizendo se dois objetos são iguais.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrupoEstudo)) return false;
        GrupoEstudo that = (GrupoEstudo) o;
        return Objects.equals(getTema(), that.getTema());
    }

    /**
     * Mostra o hashcode de um determinado objeto.
     * @return o hashcode do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTema());
    }
}
