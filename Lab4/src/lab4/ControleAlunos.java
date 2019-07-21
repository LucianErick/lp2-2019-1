package lab4;

import java.util.ArrayList;
import java.util.HashMap;

import static lab4.Utilidades.quebralinha;

/**
 * Representação de um controller de alunos.

 * @author Luciano Erick Sousa Figueiredo Filho - Matrícula: 118110400
 */
public class ControleAlunos {

    /**
     * Um mapa de alunos, contendo uma chave do tipo String que identifica um valor do tipo Aluno.
     */
    private HashMap<String, Aluno> alunos;

    /**
     * Um mapa de grupos, contendo uma chave do tipo String que identifica um valor do tipo GrupoEstudo.
     */
    private HashMap<String, GrupoEstudo> grupos;

    /**
     * Uma lista que guarda as matrículas dos alunos que responderam.
     */
    private ArrayList<Aluno> alunosRespostas;

    /**
     * Constrói um Controle de Alunos(Controlador), que cria um mapa de alunos, um de grupos e um ArrayList
     * de resposta de alunos.
     */
    public ControleAlunos() {
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosRespostas = new ArrayList<>();
    }

    /**
     * Cadastra um aluno no sistema.
     * @param matricula a matricula de um aluno.
     * @param nome o nome de um aluno.
     * @param curso o curso de um aluno.
     * @return uma String dizendo se houve sucesso ou não no cadastro do aluno.
     */

    public String cadastroAluno(String matricula, String nome, String curso) {
        if (matricula == null || "".equals(matricula.trim())) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        if (curso == null || "".equals(curso.trim())) {
            throw new IllegalArgumentException("Curso inválido!");
        }

        String saida = "";
        if (!this.alunos.containsKey(matricula)) {
            this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            saida = "CADASTRO REALIZADO!";
        } else {
            saida = "MATRÍCULA JÁ CADASTRADA!";
        }
        return saida;
    }

    /**
     * Exibe um determinado aluno, a partir de sua matrícula.
     * @param matricula a matricula de um aluno.
     * @return se a matricula passada como parâmetro estiver cadastrada, retorna-se a representação textual
     * do aluno com essa matrícula.
     */

    public String consultaAluno(String matricula) {
        if (matricula == null || "".equals(matricula.trim())) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }

        String saida = "";
        if (this.alunos.containsKey(matricula)) {
            saida = "Aluno: " + this.alunos.get(matricula).toString();
        } else {
            saida = "Aluno não cadastrado.";
        }
        return saida;
    }

    /**
     * Cadastra um grupo no sistema.
     * @param tema o tema do grupo.
     * @return um String falando se houve ou não sucesso no cadastro.
     */
    public String cadastraGrupo(String tema) {
        if (tema == null || "".equals(tema.trim())) {
            throw new IllegalArgumentException("Tema inválido!");
        }

        String saida = "";
        if((!this.grupos.containsKey(tema)) && (!this.grupos.containsKey(tema.toUpperCase()))){
            this.grupos.put(tema.toUpperCase(), new GrupoEstudo(tema));
            saida = "CADASTRO REALIZADO!";
        } else {
            saida = "GRUPO JÁ CADASTRADO!";
        }
        return saida;
    }

    /**
     * Cadastra um aluno em um determinado grupo.
     * @param matricula a matricula do aluno
     * @param tema o tema do grupo
     * @return uma String falando se houve ou não sucesso no casastro.
     */
    public String alocaAluno(String matricula, String tema){
        if (matricula == null || "".equals(matricula.trim())) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }
        if (tema == null || "".equals(tema.trim())) {
            throw new IllegalArgumentException("Tema inválido!");
        }

        String saida = "";
        if (!this.alunos.containsKey(matricula) && (!this.grupos.containsKey(tema.toUpperCase()))) {
            saida = "Aluno e Grupo não cadastrados.";
        }
        else if (!this.alunos.containsKey(matricula)) {
            saida = "Aluno não cadastrado."; }
        else if (!this.grupos.containsKey(tema.toUpperCase())) {
            saida = "Grupo não cadastrado.";
        } else {
            saida = "ALUNO ALOCADO!";
            this.grupos.get(tema.toUpperCase()).alocarAluno(this.alunos.get(matricula));
        }

        return saida;
    }
    /**
     * Imprime os alunos pertencentes a um determinado grupo.
     * @param tema o tema do grupo.
     * @return uma lista de alunos que está cadastrada em um determinado grupo.
     */
    public String imprimeGrupo(String tema){
        if (tema == null || "".equals(tema.trim())) {
            throw new IllegalArgumentException("Tema inválido!");
        }

        String saida = quebralinha(1);
        if (this.grupos.containsKey(tema.toUpperCase())){
            saida += "Alunos do grupo "
                    + this.grupos.get(tema.toUpperCase()).getTema()
                    + ":" + quebralinha(1)
                    + this.grupos.get(tema.toUpperCase()).imprimeAlunos();
        }
        return saida;
    }

    /**
     * Cadastra a matricula de um aluno que respondeu uma questão em uma lista.
     * @param matricula a matricula do aluno.
     * @return uma String falando se houve ou não sucesso ao cadastrar a resposta.
     */
    public String cadastraRespostaAluno(String matricula) {
        if (matricula == null || "".equals(matricula.trim())) {
            throw new IllegalArgumentException("Matrícula inválida!");
        }

        String saida = "";
        if (this.alunos.containsKey(matricula)){
            this.alunosRespostas.add(this.alunos.get(matricula));
            saida = "ALUNO REGISTRADO!";
        } else {
            saida = "Aluno não cadastrado.";
        }
        return saida;
    }

    /**
     * Imprime os alunos que responderam as questões passadas.
     * @return a representação em String de cada aluno que teve sua resposta registrada.
     */
    public String imprimeAlunosRespostas(){
        String saida = "Alunos:" + quebralinha(1);
        for (int i = 0; i < this.alunosRespostas.size(); i++) {
            saida += String.format("%d. ", i + 1)
                  + this.alunosRespostas.get(i).toString() + quebralinha(1);
        }
        return saida;
    }
}
