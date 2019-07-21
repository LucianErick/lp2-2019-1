package lp2;
/**
 * Registro da situação acadêmica de um aluno matriculado em determinada disciplina. No qual conta com informações sobre notas e horas de estudo.

 * @author Luciano Erick Sousa Figueiredo Filho // Matrícula: 118110400
 */

public class Disciplina {
    /**
     * Nome da disciplina a ser cadastrada, representado por uma String.
     */

    private String nomeDisciplina;

    /**
     * Quantidade de horas de estudo do aluno, representada por um inteiro.
     */

    private int horasEstudo;

    /**
     * Nota 1, representada por um double.
     */

    private double nota1;

    /**
     * Nota 2, representada por um double.
     */

    private double nota2;

    /**
     * Nota 3, representada por um double.
     */

    private double nota3;

    /**
     * Nota 4, representada por um double.
     */

    private double nota4;

    /**
     * Média, calculada a partir das notas das provas, representada por um double.
     */

    private double media;

    /**
     * Constrói uma disciplina a partir do nome desta.
     * Todo aluno começa com as notas 1,2,3 e 4 nulas(0.0)

     * @param nomeDisciplina o nome da disciplina
     */

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
    }

    /**
     * Não há retorno, apenas a implementação no atributo horasEstudo.

     * @param horas implementa, ao atributo horasEstudo, as horas que o aluno passou estudando.
     */

    public void cadastraHoras(int horas) {

        horasEstudo += horas;
    }

    /**
     * Não há retorno, apenas a atribuição, através do cadastro, das notas do aluno.

     * @param nota o número da nota, podendo ser 1º, 2°, 3° ou 4°
     * Caso a mesma nota seja posta, pelo menos, duas vezes no cadastro, a última que conta.
     * @param valorNota o valor da nota especificada, podendo ir de 0.0 a 10.0.
     */

    public void cadastraNota(int nota, double valorNota) {

        if (nota == 1) {
            this.nota1 = valorNota;
        } else if (nota == 2) {
            this.nota2 = valorNota;
        } else if (nota == 3) {
            this.nota3 = valorNota;
        } else {
            this.nota4 = valorNota;
        }
    }
      /**
       * Retorna um valor booleano para representar a situação do aluno
       * se foi aprovado(True) ou reprpvado(False), a partir de sua média.

       * @return um valor do tipo booleano, para verificar se o aluno foi aprovado ou não.
       */

    public boolean aprovado() {
        media = (nota1 + nota2 + nota3 + nota4) / 4;
        if (media >= 7.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna a representação em String da situação de um aluno numa determinaa disciplina.

     * @return uma Strig contando o nome da disciplina, as horas de estudo do aluno, a média deste e suas
     * 4 notas (1,2,3 e 4).
     */

    public String toString() {
        return String.format("%s %s %s [%s, %s, %s, %s]", nomeDisciplina, horasEstudo, media, nota1, nota2, nota3, nota4);
    }
}