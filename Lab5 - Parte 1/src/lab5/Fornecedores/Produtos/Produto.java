package lab5.Fornecedores.Produtos;
import java.util.Objects;

/**
 * Representação de um Produto
 * @author Luciano Erick Sousa Figueiredo Filho
 */
public class Produto {

    /**
     * O nome de um produto, representado por uma String.
     */
    private String nome;
    /**
     * o preco de um produto, representado por um double.
     */
    private double preco;
    /**
     * a descricao de um produto, representado por uma String.
     */
    private String descricao;

    /**
     * Constroi um produto, a partir da validacao das informacoes.
     * @param nome o nome do produto.
     * @param descricao a descricao do produto.
     * @param preco o preco do produto.
     */
    public Produto(String nome, String descricao, double preco) {
        if (nome == null || "".equals(nome.trim())){
            throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
        }
        if (descricao == null || "".equals(descricao.trim())) {
            throw new IllegalArgumentException("descricao nao pode ser vazia ou nula");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("preco invalido.");
        }
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    /**
     * @return o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o preco do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @return a descricao do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Permite a alteracao do preco do produto.
     * @param preco o novo preco do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Verifica se há a igualdade entre dois objetos.
     * @param o um objeto o qualquer.
     * @return um booleano verificando se há a igualdade entre dois objetos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getNome(), produto.getNome()) &&
                Objects.equals(getDescricao(), produto.getDescricao());
    }

    /**
     * O endereco de memoria de um determinado objeto.
     * @return o endereco de memoria de um objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDescricao());
    }

    /**
     * A representacao textual de um produto.
     * @return a representacao textual de um produto, na forma
     * 'nome - descricao - preco'.
     */
    @Override
    public String toString() {
        return String.format("%s - %s - R$%.2f", getNome(), getDescricao(), getPreco());
    }
}
