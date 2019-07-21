package lab5.Fornecedores;
import lab5.Fornecedores.Produtos.Produto;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Representação de um Fornecedor, contendo informações importantes do mesmo.
 * @author Luciano Erick Sousa Figueiredo Filho
 */
public class Fornecedor {

    /**
     * O nome do fornecedor, representado por uma String.
     */
    private String nome;
    /**
     * O email do fornecedor, representado por uma String.
     */
    private String email;
    /**
     * O telefone do fornecedor, representado por uma String.
     */
    private String telefone;

    /**
     * Uma lista de produtos do fornecedor.
     */
    private ArrayList<Produto> produtosFornecedor;

    /**
     * Constrói um fornecedor, a partir da validacao das informacoes recebidas.
     * @param nome o nome do fornecedor.
     * @param email o email do fornecedor.
     * @param telefone o telefone do fornecedor.
     */
    public Fornecedor(String nome, String email, String telefone) {
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
        }
        if (email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException("email nao pode ser vazio ou nulo.");
        }
        if (telefone == null || "".equals(telefone.trim())) {
            throw new IllegalArgumentException("telefone nao pode ser vazio ou nulo.");
        }
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtosFornecedor = new ArrayList<>();
    }

    /**
     * @return o nome do fornecedor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o email do fornecedor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return o telefone do fornecedor.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Realiza a alteracao do email do fornecedor.
     * @param email o novo email do fornecedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Realiza a alteracao do telefone do fornecedor.
     * @param telefone o novo telefone do fornecedor.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Realiza o cadatro de um novo produto a o fornecedor.
     * @param nomeProduto o nome do produto a ser adicionado.
     * @param descricao a descricao do produto a ser adicionado.
     * @param preco o preco do produto a ser adicionado.
     * @return um booleano sinalizando se foi ou nao cadastrado com exito.
     */
    public boolean cadastrarProdutoFornecedor(String nomeProduto, String descricao, double preco) {
        boolean saida = false;
        if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        } else if (nomeProduto == null || "".equals(nomeProduto.trim())) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim())){
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        } else {
            this.produtosFornecedor.add(new Produto(nomeProduto, descricao, preco));
            saida = true;
        }
        return saida;
    }

    /**
     * Realiza a impressao de todos os produtos de um fornecedor.
     * @return a representacao textual de todos os produtos cadastrados para o fornecedor,
     * separados por ' | '.
     */
    public String imprimirProdutosFornecedor() {
        String saida = "";
        for (Produto produto : produtosFornecedor) {
            saida += produto.toString() + " | ";
        }
        int tamanhoString = saida.length();
        if (tamanhoString > 0) {
            saida = saida.substring(0, tamanhoString - 3);
        }
        return saida;
    }

    /**
     * Realiza a impressao de um determinado produto.
     * @param nome o nome do produto a ser exibido.
     * @param descricao a descricao do produto a ser exibido.
     * @return a representacao textual de um determinado produto.
     */
    public String imprimirDeterminadoProduto(String nome, String descricao) {
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim())) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else {
            String saida = "";
            boolean existeProduto = false;
            for (Produto produto : produtosFornecedor) {
                if ((produto.getNome().equals(nome)) && (produto.getDescricao().equals(descricao))) {
                    existeProduto = true;
                    saida += produto.toString();
                }
            }
            if (!existeProduto) {
                throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
            }
            return saida;
        }
    }

    /**
     * Realiza a alteracao de preco para um determinado produto cadastrado.
     * @param nome o nome do produto.
     * @param descricao a descricao do produto.
     * @param novoPreco o novo preco a ser atribuido ao produto.
     */
    public void alterarPrecoProdutoFornecedor(String nome, String descricao, double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        else if (descricao == null || "".equals(descricao.trim())) {
           throw new IllegalArgumentException  ("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        }
        else if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException ("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        }
        else {
            for (Produto produto : this.produtosFornecedor) {
                if ((produto.getNome().equals(nome)) && (produto.getDescricao().equals(descricao))) {
                    produto.setPreco(novoPreco);
                }
            }
        }
     }

    /**
     * Realiza a remocao de um determinado produto.
     * @param nome o nome do produto.
     * @param descricao a descricao do produto.
     */
    public void removerProduto(String nome, String descricao) {
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || "".equals(descricao.trim())) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else {
            for (Produto produto : produtosFornecedor) {
                if ((nome.equals(produto.getNome())) && (descricao.equals(produto.getDescricao()))) {
                    this.produtosFornecedor.remove(produto);
                }
            }
        }
    }

    /**
     * Retorna um booleano verificando se ha ou nao a igualdade entre dois objetos.
     * @param o um objeto o qualquer.
     * @return um booleando checando a igualdade entre dois ob jetos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(getNome(), that.getNome());
    }

    /**
     * Retorna o endereco de memoria de um determinado objeto.
     * @return o endereco de memoria de um objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    /**
     * @return a representacao textual de um fornecedor, do tipo
     * "nome - email - telefone".
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(), getEmail(), getTelefone());
    }
}

