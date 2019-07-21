package lab5.Fornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    void testConstrutorParametrosValidos() {
        Fornecedor fornecedor = new Fornecedor("Loja qualquer", "algumemailai@gmail.com", "33357090");
        assertEquals("Loja qualquer", fornecedor.getNome());
        assertEquals("algumemailai@gmail.com", fornecedor.getEmail());
        assertEquals("33357090", fornecedor.getTelefone());
    }

    @Test
    void testConstrutorParametrosInvalidos() {
        try {
            Fornecedor fornecedor = new Fornecedor(null, "jose@hotmail.com", "33010204");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            Fornecedor fornecedor = new Fornecedor("     ", "jose@hotmail.com", "33010204");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            Fornecedor fornecedor = new Fornecedor("Seu José", null, "33010204");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("email nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            Fornecedor fornecedor = new Fornecedor("Seu José", "     ", "33010204");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("email nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            Fornecedor fornecedor = new Fornecedor("Seu José", "jose@hotmail.com", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("telefone nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            Fornecedor fornecedor = new Fornecedor("Seu José", "jose@hotmail.com", "        ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("telefone nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }
    @Test
    void testCadastraProduto() {
        Fornecedor fornecedor = new Fornecedor("José", "ze@hotmail.com", "33332146");
        assertEquals(true , fornecedor.cadastrarProdutoFornecedor("maconha", "da boa", 10));
        try {
            fornecedor.cadastrarProdutoFornecedor("  ", "chico do pó", 150);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            fornecedor.cadastrarProdutoFornecedor("droga", "   ", 150);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            fornecedor.cadastrarProdutoFornecedor("droga", "pó", -15);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro de produto: preco invalido.", erro.getMessage());
        }
    }
    @Test
    void testImprimirProdutosFornecedor() {
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 1);
        fornecedor.cadastrarProdutoFornecedor("c", "d", 2);
        assertEquals("a - b - R$1,00 | c - d - R$2,00", fornecedor.imprimirProdutosFornecedor());
    }
    @Test
    void testExibirProduto() {
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 10);
        assertEquals("a - b - R$10,00", fornecedor.imprimirDeterminadoProduto("a", "b"));
        try {
            fornecedor.imprimirDeterminadoProduto("  ", "b");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            fornecedor.imprimirDeterminadoProduto("a", "  ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            fornecedor.imprimirDeterminadoProduto("c", "e");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao de produto: produto nao existe.", erro.getMessage());
        }
    }
    @Test
    void testAlterarPrecoProduto() {
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 10);
        fornecedor.alterarPrecoProdutoFornecedor("a", "b", 100);
        assertEquals("a - b - R$100,00", fornecedor.imprimirDeterminadoProduto("a", "b"));
        try {
            fornecedor.alterarPrecoProdutoFornecedor("  ", "b", 100);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao de produto: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            fornecedor.alterarPrecoProdutoFornecedor("a", "  ", 100);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao de produto: descricao nao pode ser vazia ou nula.", erro.getMessage());
        }
        try {
            fornecedor.alterarPrecoProdutoFornecedor("droga", "pó", -15);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao de produto: preco invalido.", erro.getMessage());
        }
    }
    @Test
    void testRemoveProduto() {
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 10);
        fornecedor.cadastrarProdutoFornecedor("c", "d", 50);
        fornecedor.removerProduto("a", "b");
        assertEquals("c - d - R$50,00" ,fornecedor.imprimirProdutosFornecedor());
        try {
            fornecedor.removerProduto("   ", "b");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na remocao de produto: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            fornecedor.removerProduto("a", "  ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na remocao de produto: descricao nao pode ser vazia ou nula.", erro.getMessage());
        }
    }
    @Test
    void testToString(){
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 10);
        assertEquals("zé - zedopo@hotmail.com - 13245678", fornecedor.toString());
    }
}