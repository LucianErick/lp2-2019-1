package lp2;

/**
 * Representação do estado de saúde, tanto física, quanto mental, de um aluno matriculado. Podendo ser definido por 'boa', 'fraca' ou 'ok'.

 * @author Luciano Erick Sousa Figueiredo Filho // Matrícula: 118110400
 */

public class Saude {

    /**
     * O estado de saúde Física do aluno, representado por uma String
     * podendo ser "fraca" ou "boa".
     */

    private String saudeFisica;

    /**
     * O estado de saúde Mental do aluno, representado por uma String
     * podendo ser "fraca" ou "boa".
     */

    private String saudeMental;

    /**
     * Constrói um status de saúde, sem nenhum parâmetro.

     * O valor inicial do atributo saudeFisica começa como "boa"
     * O Valor inicial do atributo saudeMental começa como "boa"
     */

    public Saude() {
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
    }



    /**
     * Não há retorno, apenas há a atribuição, por meio do parâmetro valor, para
     * o atributo saudeMental.

     * @param valor define o estado de Saúde Mental, representado pelo atributo saudeMental, do aluno.
     */

    public void defineSaudeMental(String valor) {

        this.saudeMental = valor;
    }

    /**
     * Não há retorno, apenas há a atribuição, por meio do parâmetro valor, para
     * o atributo saudeFisica.

     * @param valor define o estado de Saúde Física, representado pelo atributo saudeFisica, do aluno.
     */

    public void defineSaudeFisica(String valor) {

        this.saudeFisica = valor;
    }

    /**
     * Retorna uma String, representando o status de saúde geral do aluno.
     * esse status será "boa", caso ambas as variáveis tiverem o valor "boa",
     * será "fraco"

     * @return um status de saúde geral.
     */

    public String getStatusGeral() {
        if (saudeMental.equals("boa") && saudeFisica.equals("boa")){
            return "boa";
        }
        else if (saudeMental.equals("fraca") && saudeFisica.equals("fraca")){
            return "fraca";
        }
        else {
            return "ok";
        }
    }
}
