package lp2;

/**
 * Representação da movimentação financeira na conta da cantina de um aluno cadastrado na universidade
 * o valor deve ser dado em centavos e o pagamento não pode ser maior que o que se deve.

 * @author Luciano Erick Sousa Figueiredo Filho // Matrícula: 118110400
 */

public class ContaCantina {

    /**
     * Nome da cantina a ser registrado no sistema, representado por um string.
     */

    public String nomeCantina;

    /**
     * O valor que o aluno deve na referida cantina, representado por um inteiro, Já que as operações
     * serão realizadas por meio de centavos.
     */

    public int debitoConta;

    /**
     * Quantidade total de itens consumidos pelo aluno, reperesentado por um valor inteiro.
     */

    public int qtdItens;

    /**
     * Valor em centavos no qual as operações vão ser realizadas, por este motivo, é representado
     * por um valor inteiro.
     */

    public int valorCentavos;

    /**
     * Constrói uma Conta na cantina a partir do nome desta.

     * @param nomeCantina o nome da cantina
     */


    public ContaCantina(String nomeCantina) {

        this.nomeCantina = nomeCantina;
    }

    /**
     * Não há retorno, apenas implementação de valores, servindo como um cadastro das informações.

     * @param qtdItens implementa, no atributo de mesmo nome, a quantidade de itens consumidos.
     * @param valorCentavos implementa, no atributo de mesmo nome, o valor em centavos total
     * gasto pelo aluno.
     * @param valorCentavos, também, implementa o valor devido na conta do estudante, repesentado
     * pelo atributo debitoConta
     */

    public void cadastraLanche(int qtdItens, int valorCentavos){

        this.qtdItens += qtdItens;
        this.valorCentavos += valorCentavos;
        debitoConta += valorCentavos;
    }

    /**
     * Não há retorno, apenas uma movimentação no atributo debitoConta

     * @param valorCentavos subtrai do atributo debitoConta o valor passado pelo usuario, servindo como pagamento.
     * Porém, esse valor não pode ser maior que o valor atual da dívida.
     */

    public void pagaConta(int valorCentavos) {

        debitoConta -= valorCentavos;
    }

    /**
     * Retorna o valor restante, após o pagamento, da divida, em centavos(int), do aluno na cantina.

     * @return o valor restante a ser pago, em inteiro, pelo aluno.
     */

    public int getFaltaPagar() {

        return debitoConta;
    }

    /**
     * Retorna representação em String de uma conta de um aluno na cantina, com o nome, quantidade de itens
     * e valor em centavos.

     * @return a representação em String de uma conta na cantina.
     */

    public String toString() {

        return String.format("%s %s %s", nomeCantina, qtdItens, valorCentavos);
    }
}
