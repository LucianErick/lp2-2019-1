package lab5.Fornecedores;
import java.util.HashMap;

/**
 * Representação de um CRUD (Create, Read, Update and Delete) de fornecedores.
 * @author Luciano Erick Sousa Figueiredo Filho
 */
public class CrudFornecedores {
    /**
     * Um mapa de fornecedores, na qual as chaves sao Strings.
     */
    private HashMap<String, Fornecedor> fornecedores;

    /**
     * Controi um mapa de fornecedores.
     */
    public CrudFornecedores() {
        this.fornecedores = new HashMap<>();
    }

    /**
     * Realiza o cadastro de um fornecedor.
     * @param nome o nome do fornecedor.
     * @param email o email do fornecedor.
     * @param telefone o telefone do fornecedor.
     * @return o nome do fornecedor, caso todas as informações sejam validas.
     */
    public String cadastrarFornecedor(String nome, String email, String telefone) {
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        } else if (email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (telefone == null || "".equals(telefone.trim())){
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        } else {
            if (this.fornecedores.containsKey(nome)) {
                throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
            } else {
                    this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
            return nome;
            }
        }
    }

    /**
     * Realiza a exibicao de um determinado fornecedor.
     * @param nome o nome do fornecedor.
     * @return a representacao textual de um determinado fornecedor.
     */
    public String exibirFornecedor(String nome) {
        String saida = "";
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        else if (this.fornecedores.containsKey(nome)) {
            saida += this.fornecedores.get(nome).toString();
        } else {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        return saida;
    }

    /**
     * Realiza a impressao de todos os fornecedores.
     * @return a representacao textual de todos os fornecedores.
     */
    public String imprimirFornecedores() {
        String saida = "";
        for (String chave : fornecedores.keySet()) {
            saida += fornecedores.get(chave).toString() + " | ";
        }
        int tamanhoString = saida.length();
        if (tamanhoString > 0) {
            saida = saida.substring(0, tamanhoString - 3);
        }
        return saida;
    }

    /**
     * Realiza a edicao das informacoes de um fornecedor.
     * @param nome o nome do fornecedor.
     * @param atributoASerMudado o atributo a ser mudado.
     * @param novoAtributo o novo valor dado ao atributo.
     */
    public void editarCadastroFonecededor(String nome, String atributoASerMudado, String novoAtributo) {
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        }
        else if ((nome != null) && this.fornecedores.containsKey(nome)) {
            switch (atributoASerMudado.toUpperCase()) {
                case "NOME":
                    throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");

                case "EMAIL":
                    this.fornecedores.get(nome).setEmail(novoAtributo);
                    break;

                case "TELEFONE":
                    this.fornecedores.get(nome).setTelefone(novoAtributo);
                    break;

                default:
                    throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
        }
        else if (novoAtributo == null || "".equals(novoAtributo.trim())){
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        }
    }

    /**
     * Realiza a remocao do cadastro de um determinado fornecedor.
     * @param nome o nome do fornecedor.
     */
    public void removerCadastroFornecedor(String nome) {
        String saida = "";
        if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        }
        else if ((nome != null) && (this.fornecedores.containsKey(nome))) {
            this.fornecedores.remove(nome);
        } else {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Realiza o cadastro de um produto para um dado fornecedor.
     * @param nomeFornecedor o nome do fornecedor.
     * @param nomeProduto o nome do produto.
     * @param descricaoProduto a descricao do produto.
     * @param preco o preco do produto.
     */
    public void cadastrarProdutoParaFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto, double preco) {

        if(this.fornecedores.containsKey(nomeFornecedor)) {
            this.fornecedores.get(nomeFornecedor).cadastrarProdutoFornecedor(nomeProduto, descricaoProduto, preco);
        } else {
            if (nomeFornecedor == null || "".equals(nomeFornecedor.trim())) {
                throw new IllegalArgumentException("Erro no cadastro do produto: fornecedor nao pode ser vazio ou nulo.");
            } else {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
            }
        }
    }

    /**
     * Realiza a exibicao de um produto para um dado fornecedor.
     * @param nomeFornecedor o nome do fornecedor.
     * @param nomeProduto o nome do produto.
     * @param descricaoProduto a descricao do produto.
     * @return a representacao textual de um determinado produto.
     */
    public String exibirProdutoDeFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        String saida = "";
        if (this.fornecedores.containsKey(nomeFornecedor)) {
            saida += this.fornecedores.get(nomeFornecedor).imprimirDeterminadoProduto(nomeProduto, descricaoProduto);
        } else {
            if (nomeFornecedor == null || "".equals(nomeFornecedor.trim())) {
                throw new IllegalArgumentException("Erro no cadastro do produto: fornecedor nao pode ser vazio ou nulo.");
            } else {
                throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
            }
        }
        return saida;
    }
    /**
     * Realiza a impressao de todos os produtos de um fornecedor.
     * @param nomeFornecedor o nome do fornecedor.
     * @return a representacao textual de todos os produtos de um fornecedor.
     */
    public String exibirTodosProdutosDeFornecedor(String nomeFornecedor) {
        String saida = "";
        if (nomeFornecedor == null || "".equals(nomeFornecedor.trim())){
            throw new IllegalArgumentException("Erro na exibicao de produtos: nome nao pode ser vazio ou nulo.");
        }
        if (this.fornecedores.containsKey(nomeFornecedor)) {
            saida += this.fornecedores.get(nomeFornecedor).imprimirProdutosFornecedor();
        }
        return saida;
    }
    /**
     * Realiza a exibicao de todos os produtos cadastrados.
     * @return representacao de todos os produtos cadastrados.
     */
    public String exibirTodosOsProdutos() {
        String saida = "";
        for (String chave : this.fornecedores.keySet()) {
            saida += this.fornecedores.get(chave).imprimirProdutosFornecedor() + " | ";
        }
        int tamanhoString = saida.length();
        if (tamanhoString > 0) {
            saida = saida.substring(0, tamanhoString - 3);
        }
        return saida;
    }
    /**
     * Realiza a alteracao do preco de um dado produto.
     * @param nomeProduto o nome do produto.
     * @param descricaoProduto a descricao do produto.
     * @param novoPreco o novo preco do produto.
     */
    public void alterarPrecoProduto(String nomeProduto, String descricaoProduto, double novoPreco) {
        for (String chave : this.fornecedores.keySet()) {
            this.fornecedores.get(chave).alterarPrecoProdutoFornecedor(nomeProduto, descricaoProduto, novoPreco);
        }
    }
    /**
     * Realiza a remocao de um produto de um dado fornecedor.
     * @param nomeFornecedor o nome do fornecedor.
     * @param nomeProduto o nome do produto.
     * @param descricaoProduto a descricao do produto.
     */
    public void removerProdutoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        if (nomeFornecedor == null || "".equals(nomeFornecedor.trim())) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        }
        if (this.fornecedores.containsKey(nomeFornecedor)) {
            this.fornecedores.get(nomeFornecedor).removerProduto(nomeProduto, descricaoProduto);
        }
    }
}
