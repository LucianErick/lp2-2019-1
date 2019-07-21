package lp2;

/**
 * Controle da conta do laboratório de um aluno matriculado, no qual possui um espaço limitado para guardar seus arquivos e dados.

   @author Luciano Erick Sousa Figueiredo Filho // Matrícula: 118110400
 */

public class ContaLaboratorio {

    /**
     * Nome do laboratório a ser cadastrado no sistema, representado por uma String.
     */

    private String nomeLaboratorio;

    /**
     * Cota de memória na qual é definida no sistema, representada por um inteiro.
     */

    private int cota;

    /**
     * Espaço de memória ocupado no sistema, representado por um inteiro.
     * Obs: Esse espaço pode ser maior que a cota, pois o sistema permite que, mesmo atingindo a cota, o aluno
     * ainda poderá registrar dados e arquivos na sua conta.
     */

    private int espacoOcupado;

    /**
     * Constrói uma conta no laboratório a partir do nome desta e da cota estabelecida pelo sistema.

     * @param nomeLaboratorio o nome do laboratório
     * @param cota a cota de memória que o sistema define
     */

    public ContaLaboratorio(String nomeLaboratorio, int cota) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cota = cota;
    }

    /**
     * Constrói uma conta no laboratório a partir do nome desta.
     * a cota que é definida inicialmente pelo sistema é de 2000MB, aproximadamente 2GB.

     * @param nomeLaboratorio define o nome do laboratório a ser cadastrado.
     */

    public ContaLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cota = 2000;
    }

    /**
     * Não há retorno, apenas implementação no atributo espacoOcupado.

     * @param mbytes implementa, no atributo espacoOcupado, o espaço de memória
     * consumido pelo usuário.
     */

    public void consomeEspaco(int mbytes) {

        this.espacoOcupado += mbytes;
    }

    /**
     * Não há retorno, apenas modificação no atributo espacoOcupado.

     * @param mbytes subtrai, do atributo espacoOcupado, o espaço de memória
     * liberado pelo usuário.
     */

    public void liberaEspaco(int mbytes) {

        this.espacoOcupado -= mbytes;
    }

    /**
     * Retorna um valor booleano, sendo true ou false, para a verificação se, por acaso, a cota
     * de memória foi atingida.

     * @return um valor do tipo booleano, representando se a cota foi atingida ou não.
     */

    public boolean atingiuCota() {
        if (espacoOcupado >= cota) return true;
        else {
            return false;
        }
    }

    /**
     * Retorna a representação em String de uma conta do laboratório, contendo o nome, o espaço ocupado
     * e a cota de memória.

     * @return a representação em String de uma conta no laboratório.
     */

    public String toString() {
        return String.format("%s %s/%s", nomeLaboratorio, espacoOcupado, cota);
    }
}
