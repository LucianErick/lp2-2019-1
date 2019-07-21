package lab5.Clientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrudClientesTest {
    private CrudClientes controle;

    @BeforeEach
    void setUp() {
        this.controle = new CrudClientes();
    }

    @Test
    void testCadastraCliente(){

        assertEquals("12345678900", controle.cadastrarCliente("12345678900", "Luciano Erick",  "lucianoericksousa@gmail.com", "Lcc3"));
        assertEquals("cliente ja cadastrado.", controle.cadastrarCliente("12345678900", "Kcire Onaicul",  "nomeaocontrario", "Lcc2"));
        try {
            controle.cadastrarCliente(null, "Kcire Onaicul", "nomeaocontrario", "Lcc2");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle.cadastrarCliente("23131316857", null, "semnome@gmail.com","Lcc1");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle.cadastrarCliente("23546789101", "Maria", "maria@outlook.com", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("localizacao nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            controle.cadastrarCliente("32165432165", "Peter",null, "Splab");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("email nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            controle.cadastrarCliente("1315616118187181818181", "a", "b", "c");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do cliente: cpf invalido.", erro.getMessage());
        }
    }

    @Test
    void testExibirCliente() {
        controle.cadastrarCliente("12345678900", "Luciano Erick", "lucianoericksousa@gmail.com", "Lcc3");
        assertEquals("Luciano Erick - Lcc3 - lucianoericksousa@gmail.com", controle.exibirCliente("12345678900"));
        assertEquals("Erro na exibicao do cliente: cliente nao existe.", controle.exibirCliente("123"));
        try {
            controle.exibirCliente(null);
        } catch (IllegalArgumentException erro) {
            assertEquals("cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }

    @Test
    void testImprimirClientes() {
        assertEquals("", controle.imprimirClientes());
        controle.cadastrarCliente("12345678910", "a", "b", "c");
        controle.cadastrarCliente("45678910112", "d", "e", "f");
        assertEquals("d - f - e | a - c - b", controle.imprimirClientes());
        controle.cadastrarCliente("78910111213", "g", "h", "i");
        assertEquals("g - i - h | d - f - e | a - c - b", controle.imprimirClientes());
    }

    @Test
    void testEditarCadastroCliente() {
        controle.cadastrarCliente("12345678900", "Luciano Erick", "Lcc3", "lucianoericksousa@gmail.com");
        controle.editarCadastroCliente("12345678900", "Nome", "Luci");
        controle.editarCadastroCliente("12345678900", "Email", "novoemail");
        controle.editarCadastroCliente("12345678900", "Localizacao", "casa");
        assertEquals("Luci - casa - novoemail", controle.exibirCliente("12345678900"));
        try {
            controle.editarCadastroCliente("12345678900", "Maconha", "sei lá, algo aleatorio");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao existe.", erro.getMessage());
        }
        try {
            controle.editarCadastroCliente("1234567900", null, "sei lá, algo aleatorio");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            controle.editarCadastroCliente("1234567900", "Nome", "      ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }
    @Test
            void testRemoveCadastroCliente() {
        controle.cadastrarCliente("12345678900", "luci", "lucianoerick", "Lcc3");
        assertEquals("luci - Lcc3 - lucianoerick", controle.exibirCliente("12345678900"));
        controle.removerCadastroCliente("12345678900");
        assertEquals("Erro na exibicao do cliente: cliente nao existe.", controle.exibirCliente("12345678900"));
        try {
            controle.removerCadastroCliente("12345678901");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do cliente: cliente nao existe.", erro.getMessage());
        }
    }
}