package lab03;

import java.util.Objects;

    /**
     * Representacao de um contato, contendo informacões para identificacao.

     * @author Luciano Erick Sousa Figueiredo Filho - Matricula: 118110400
     */

    public class Contato {

    /**
     * Nome do contato, no tipo String.
     */

    private String nome;

    /**
     * Sobrenome do contato, no tipo String.
     */
    private String sobrenome;

    /**
     * Telefone do contato, também no tipo String.
     */
    private String telefone;

    /**
     * Constroi um contato, obrigando ao usuario inserir um nome, um sobrenome e um telefone
     * caso tais parametros nao forem inseridos (Nulos) ou validos (Composto por espacos)
     * o programa encerrara.

     * @param nome o nome do contato, sem ser vazio.
     * @param sobrenome o sobrenome do contato, sem ser vazio.
     * @param telefone o telefone do contato, sem ser vazio.
     */

    public Contato(String nome, String sobrenome, String telefone) {

        if (nome.equals("") || nome.equals(" ")) {
            throw new IllegalArgumentException("Nome inválido!");
        }

        if (nome == null) {
            throw new NullPointerException("Nome vazio!");
        }

        if (sobrenome.equals("") || sobrenome.equals(" ")) {
            throw new IllegalArgumentException("Sobrenome inválido!");
        }

        if (sobrenome == null) {
            throw new NullPointerException("Sobrenome vazio!");
        }

        if (telefone.equals("") || telefone.equals(" ")) {
            throw new IllegalArgumentException("Telefone inválido!");
        }

        if (telefone == null) {
            throw new NullPointerException("Telefone vazio!");
        }

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    /**
     * Retorna a String que representa o nome do contato, afim de facilitar a implementacao do mesmo.

     * @return o nome do contato.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Retorna a String que representa o Sobrenome do contato, afim de facilitar a implementacao do mesmo.

     * @return o sobrenome do contato.
     */

    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Retorna a String que representa o telefone do contato, afim de facilitar a implementacao do mesmo.
     * @return o telefone do contato.
     */

    public String getTelefone() {
        return telefone;
    }

        /**
         * Compara dois objetos, afim de checar se sao iguais.
         * @param obj um objeto qualquer.
         * @return um valor booleano, podendo ser true ou false, para a verificacao da igualdade.
         */

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Contato)) return false;
            Contato contato = (Contato) obj;
            return Objects.equals(getNome(), contato.getNome()) &&
                    Objects.equals(getSobrenome(), contato.getSobrenome());
        }

    /**
     * Auxilia na estruturacao do codigo.
     * @return uma string qualquer.
     */

    @Override
    public String toString() {
        return String.format("%s %s - %s", nome, sobrenome, telefone);
    }

     /**
     * Referencia dois objetos, a partir de seus enderecos de memoria.
     * @return o endereco de memoria dos objetos.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSobrenome());
    }
}
