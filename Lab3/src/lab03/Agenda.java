package lab03;
import java.util.Arrays;
    /**
     * Representacao de uma Agenda de contatos, fazendo operacoes de cadastro, listagem e exibicao
     * usando as informacoes fornecidas.

     * @author Luciano Erick Sousa Figueiredo Filho - Matrícula: 118110400.
     */

    public class Agenda {
        /**
         * Uma lista de contatos, na qual recebe as informacoes de cada contato.
         */
        private Contato[] listaContatos;

        /**
        * Constrói uma agenda, sem parâmetros, na qual contem uma lista de contatos de tamanho 100.
        */

        public Agenda() {
        this.listaContatos = new Contato[100];
    }

        /**
        * Realiza, se a posicao for valida, o cadastro de um contato na agenda
        * retornando uma mensagem caso o cadastro tenha sido realizado com sucesso.

        * @param nome o nome do contato, caso nao seja vazio.
        * @param sobrenome o sobrenome do contato, caso nao seja vazio.
        * @param telefone o telefone do contato, caso nao seja vazio.
        * @param posicao a posicao do contato a ser registrada na agenda, podendo ir de 1 a 100.

        * @return a mensagem "CADASTRO REALIZADO!", caso o cadastro ocorra com sucesso, caso contrario
        * a mensagem retornada sera o erro que ocorreu.
        */

        public String cadastro(String nome, String sobrenome, String telefone, int posicao) {

            try {
                this.listaContatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
            } catch (IndexOutOfBoundsException iobe) {
                return "Posição Inválida!"
                   + Utilidades.quebraLinha(1);
            }

            return "CADASTRO REALIZADO!"
                + Utilidades.quebraLinha(1);
        }

        /**
         * Exibe o contato cadastrado numa posicao específica, escolhida pelo usuario.
         * @param posicao a posicao escolhida pelo usuario.

         * @return a representacao, em string, do contato escolhido, no formato
         * "nome sobrenome - telefone"
         */

        public String exibicao(int posicao) {

            String saida = "";
            if (this.listaContatos[posicao - 1] != null) {
                saida = Utilidades.quebraLinha(1)
                        + listaContatos[posicao - 1].getNome()
                        + " "
                        + listaContatos[posicao - 1].getSobrenome()
                        + " - "
                        + listaContatos[posicao - 1].getTelefone()
                        + Utilidades.quebraLinha(1);

            }
            return saida;
         }

        /**
         * Lista todos os contato cadastrados, ate o momento, pelo usuario, na agenda, podendo
         * ser acessado a qualquer momento.

     * @return a representacao, em string, dos contatos cadastrados pelo usuario
     * ate o momento, no formato "posicao - nome sobrenome"
     */
    public String listagem() {

        String saida = "";
        for (int i = 0; i < this.listaContatos.length ; i++) {

            if(this.listaContatos[i] != null) {
               saida += (i + 1)
                     + " - "
                     + listaContatos[i].getNome()
                     + " "
                     + listaContatos[i].getSobrenome()
                     + Utilidades.quebraLinha(1);
            }
        }
        return saida;
    }

    /**
     * Compara dois objetos, afim de checar se sao iguais.
     * @param obj objeto qualquer.

     * @return um valor booleano, podendo ser true ou false, para a verificacao da igualdade.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Agenda)) return false;
        Agenda agenda = (Agenda) obj;
        return Arrays.equals(listaContatos, agenda.listaContatos);
    }

    /**
     * Referencia os objetos, a partir do seus enderecos de memória.
     * @return o endereco de memória dos objetos.
     */

    @Override
    public int hashCode() {
        return Arrays.hashCode(listaContatos);
    }
}
