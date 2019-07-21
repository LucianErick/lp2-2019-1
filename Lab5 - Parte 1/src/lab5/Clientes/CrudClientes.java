package lab5.Clientes;

import java.util.HashMap;

/**
 * Representação de um CRUD (Create, Read, Update and Delete) de Clientes.
 * @author Luciano Erick Sousa Figueiredo Filho
 */
public class CrudClientes {
    /**
     * Um mapa de clientes, no qual contém Strings como chaves.
     */
    private HashMap<String, Cliente> clientes;

    /**
     * Constrói um mapa de Clientes, util para os metodos e operacoes.
     */
    public CrudClientes() {
        this.clientes = new HashMap<>();
    }

    /**
     * Realiza o cadastro de um determinado cliente.
     * @param cpf o cpf do cliente, com 11 digitos.
     * @param nome o nome do cliente.
     * @param email o email do cliente.
     * @param localizacao a localizacao de um cliente.
     * @return caso todas as informações sejam colocadas corretamente,
     * retornará-se o cpf do cliente.
     */
    public String cadastrarCliente(String cpf, String nome, String email, String localizacao) {
        if (cpf == null || "".equals(cpf.trim())) {
            throw new IllegalArgumentException("cpf nao pode ser vazio ou nulo.");
        } else if (nome == null || "".equals(nome.trim())) {
            throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
        } else if (localizacao == null || "".equals(localizacao.trim())) {
            throw new IllegalArgumentException("localizacao nao pode ser vazia ou nula.");
        } else if (email == null || "".equals(email.trim())) {
            throw new IllegalArgumentException("email nao pode ser vazio ou nulo.");
        } else if (this.clientes.containsKey(cpf)) {
            return "cliente ja cadastrado.";
        } else if (cpf.length() != 11) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        } else {
            this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
            return cpf;
        }
    }

    /**
     * Realiza a exibicao de um cliente.
     * @param cpf o cpf, em 11 digitos, do cliente.
     * @return se as informacoes passadas sao validas, retornará-se
     * a representacao textual do cliente.
     */
    public String exibirCliente(String cpf) {
        if (cpf != null && !"".equals(cpf.trim())) {
            if (this.clientes.containsKey(cpf)) {
                return this.clientes.get(cpf).toString();
            } else {
                return "Erro na exibicao do cliente: cliente nao existe."; }
        } else {
            throw new IllegalArgumentException("cpf nao pode ser vazio ou nulo.");
        }
    }

    /**
     * Realiza a impressao dos clientes ja cadastrados.
     * @return a representacao textual de todos os clientes ja cadastrados
     * separados por ' | '.
     */
    public String imprimirClientes() {
        String saida = "";
        for (String chave : clientes.keySet()) {
            saida += this.clientes.get(chave).toString() + " | ";
        }
        int tamanhoString = saida.length();
        if (tamanhoString > 0) {
            saida = saida.substring(0, tamanhoString - 3);
        }
        return saida;
    }

    /**
     * Realiza a edicao do cadastro de um cliente.
     * @param cpf o cpf(identificador) do cliente.
     * @param atributoASerTrocado o atributo que deve ser modificado.
     * @param novoValor o novo valor do atributo especificado anteriormente.
     */
    public void editarCadastroCliente(String cpf, String atributoASerTrocado, String novoValor) {
        if (atributoASerTrocado == null || "".equals(atributoASerTrocado.trim())) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        }
        if (novoValor == null || "".equals(novoValor.trim())) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        }
        if((cpf != null) && (this.clientes.containsKey(cpf))) {
            switch (atributoASerTrocado.toUpperCase()) {
                case "NOME":
                    this.clientes.get(cpf).setNome(novoValor);
                    break;

                case "EMAIL":
                    this.clientes.get(cpf).setEmail(novoValor);
                    break;

                case "LOCALIZACAO":
                    this.clientes.get(cpf).setLocalizacao(novoValor);
                    break;

                default:
                    throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
            }
        }
        if (!this.clientes.containsKey(cpf)) {
            throw new  IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Realiza a remocao do cadastro de um determinado cliente.
     * @param cpf o cpf(identificador) do cliente.
     */
    public void removerCadastroCliente(String cpf){
            if(this.clientes.containsKey(cpf)) {
                 this.clientes.remove(cpf);
            } else {
                throw  new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
            }
    }
}