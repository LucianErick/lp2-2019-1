package lab5.Clientes;
import java.util.Objects;

/**
 * Representação de um Cliente, contendo as informações fundamentais.
 *
 * @author Luciano Erick Sousa Figueiredo Filho
 */
public class Cliente {
    /**
     * O cpf do cliente, contendo 11 digitos, representado por uma String.
     */
    private String cpf;
    /**
     * O nome do cliente, representado por uma String.
     */
    private String nome;
    /**
     * O email de um cliente, representado por uma String.
     */
    private String email;
    /**
     * A Localização de um cliente, representado por uma String.
     */
    private String localizacao;

    /**
     * Constroi um Cliente, checando se nenhuma informação é nula ou vazia.
     * @param cpf o cpf do cliente.
     * @param nome o nome do cliente.
     * @param email o email do cliente.
     * @param localizacao a localizacao do cliente.
     */
    public Cliente(String cpf, String nome, String email, String localizacao) {
        if ((cpf == null) || ("".equals(cpf.trim())) ) {
            throw new IllegalArgumentException("cpf nao pode ser vazio ou nulo.");
        }
        if ((nome == null) || ("".equals(nome.trim())) ) {
            throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
        }
        if ((localizacao == null) || ("".equals(localizacao.trim())) ) {
            throw new IllegalArgumentException("localizacao nao pode ser vazia ou nula.");
        }
        if ((email == null) || ("".equals(email.trim())) ) {
            throw new IllegalArgumentException("email nao pode ser vazio ou nulo.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
    }

    /**
     * @return o cpf do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return a localizacao do cliente.
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Permite a alteração do nome do cliente.
     * @param nome o novo nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Permite a alteração do email do cliente.
     * @param email o novo email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Permite a alteração da localizacao do cliente.
     * @param localizacao o novo nome do cliente.
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Retorna um booleano para igualdade entre dois objetos,
     * @param o um objeto qualquer o.
     * @return um booleano assinalando a igualdade ou não entre dois objetos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCpf(), cliente.getCpf());
    }

    /**
     * Retorna o endereco de memória de um objeto, util para o equals.
     * @return o valor ocupado na memoria para um objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    /**
     * Retorna a representação textual de um cliente
     * no tipo 'nome - email - localizacao'.
     * @return a representacao textual de um cliente.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getLocalizacao(), getEmail());
    }
}
