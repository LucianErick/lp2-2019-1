package lab5;

import lab5.Clientes.CrudClientes;
import lab5.Fornecedores.CrudFornecedores;

public class Facade {

    CrudClientes clientes;
    CrudFornecedores fornecedores;

    public Facade() {
        this.clientes = new CrudClientes();
        this.fornecedores = new CrudFornecedores();
    }

    // US1
    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.clientes.cadastrarCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.clientes.exibirCliente(cpf);
    }

    public String exibeClientes() {
        return this.clientes.imprimirClientes();
    }

    public void editaCadastroCliente(String cpf, String antigoAtributo, String novoAtributo) {
        this.clientes.editarCadastroCliente(cpf, antigoAtributo, novoAtributo);
    }

    public void removeCliente(String cpf) {
        this.clientes.removerCadastroCliente(cpf);
    }

    // US2
    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.fornecedores.cadastrarFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome) {
        return this.fornecedores.exibirFornecedor(nome);
    }

    public String exibeFornecedores() {
        return this.fornecedores.imprimirFornecedores();
    }

    public void editaCadastroFornecedor(String nome, String antigoAtributo, String novoAtributo) {
        this.fornecedores.editarCadastroFonecededor(nome, antigoAtributo, novoAtributo);
    }

    public void removeFornecedor(String nome) {
        this.fornecedores.removerCadastroFornecedor(nome);
    }

    // US3
    public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto, double preco) {
        this.fornecedores.cadastrarProdutoParaFornecedor(nomeFornecedor, nomeProduto, descricaoProduto, preco);
    }

    public String exibeProdutoFornecedor(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        return this.fornecedores.exibirProdutoDeFornecedor(nomeFornecedor, nomeProduto, descricaoProduto);
    }

    public String exibeProdutosFornecedor(String nomeFornecedor) {
        return this.fornecedores.exibirTodosProdutosDeFornecedor(nomeFornecedor);
    }

    public String exibeProdutos() {
        return this.fornecedores.exibirTodosOsProdutos();
    }

    public void editaPrecoProduto(String nomeProduto, String descricaoProduto, double novoPreco) {
        this.fornecedores.alterarPrecoProduto(nomeProduto, descricaoProduto, novoPreco);
    }

    public void removeProduto(String nomeFornecedor, String nomeProduto, String descricaoProduto) {
        this.fornecedores.removerProdutoFornecedor(nomeFornecedor, nomeProduto, descricaoProduto);
    }
}
