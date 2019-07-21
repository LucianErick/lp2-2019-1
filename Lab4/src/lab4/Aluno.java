package lab4;

import java.util.Objects;
    /**
     Representacao de um Aluno, contendo as devidas informacoes necessarias para identificacao.

     @author Luciano Erick Sousa Figueiredo Filho - Matricula: 118110400
     */
public class Aluno {

    /**
     * Matricula do aluno, do tipo String.
     */

    private String matricula;

    /**
     * Nome do aluno, do tipo String.
     */

    private String nome;

    /**
     * Curso do aluno, do tipo String.
     */

    private String curso;

    /**
     * Constroi um aluno, obrigando-o a fornecer, de forma valida, a matricula, o nome e o curso do mesmo.
     * @param matricula a matricula do aluno.
     * @param nome o nome do aluno.
     * @param curso o curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {
        if (matricula == null || "".equals(matricula.trim())) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        if (curso == null || "".equals(curso.trim())) {
            throw new IllegalArgumentException("Curso inválido!");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Pega a String que representa a matrícula do aluno.
     * @return a matricula do aluno.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
    * Pega a String que representa o nome do aluno.
    * @return o nome do aluno.
    */

        public String getNome() {
        return nome;
    }

    /**
     * Pega a String que representa o curso do aluno.
     * @return o curso do aluno.
     */

        public String getCurso() {
        return curso;
    }

    /**
     * Verifica se dois alunos são iguais a partir da matrícula
     * @return um valor booleano, checando se dois alunos são iguais.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getMatricula(), aluno.getMatricula());
    }

    /**
     * Verifica o hashcode de um objeto
     * @return o hashcode de um objeto.
     */

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    /**
     * Representação textual de um aluno, no formato 'matricula - nome - curso'.
     * @return uma String representando um aluno.
     */

    @Override
    public String toString() {
        return String.format("%s - %s - %s", getMatricula(), getNome(), getCurso());
    }
}
