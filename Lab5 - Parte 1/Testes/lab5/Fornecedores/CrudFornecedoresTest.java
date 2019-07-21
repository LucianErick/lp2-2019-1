package lab5.Fornecedores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrudFornecedoresTest {
    private CrudFornecedores controle;

    @BeforeEach
    void setUp() {
        this.controle = new CrudFornecedores();
    }

    @Test
    void cadastrarFornecedor() {
        assertEquals("Zé luis", this.controle.cadastrarFornecedor("Zé luis", "zezin@gmail.com", "33217962"));
        try {
            this.controle.cadastrarFornecedor("  ", "qualquer", "213");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle.cadastrarFornecedor("Luci", "   ", "86534102");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle.cadastrarFornecedor("Luci", "qualquer", "   ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", erro.getMessage());
        }
    }

    @Test
    void exibirFornecedor() {
        this.controle.cadastrarFornecedor("Luci", "qualquer", "86534102");
        assertEquals("Luci - qualquer - 86534102", this.controle.exibirFornecedor("Luci"));
        try{
            this.controle.exibirFornecedor("   ");
            fail();
            } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.", erro.getMessage());
        }
        try {
            this.controle.exibirFornecedor("zé");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }
    }

    @Test
    void imprimirFornecedores() {
        assertEquals("", this.controle.imprimirFornecedores());
        this.controle.cadastrarFornecedor("Luciano", "lucianoerick", "86534102");
        assertEquals("Luciano - lucianoerick - 86534102", this.controle.imprimirFornecedores());
        this.controle.cadastrarFornecedor("a", "b", "c");
        assertEquals("a - b - c | Luciano - lucianoerick - 86534102" , this.controle.imprimirFornecedores());

    }

    @Test
    void editarCadastroFonecededor() {
        this.controle.cadastrarFornecedor("Luciano", "lucianoerick", "86534102");
        assertEquals("Luciano - lucianoerick - 86534102", this.controle.exibirFornecedor("Luciano"));
        this.controle.editarCadastroFonecededor("Luciano", "Email", "luci");
        assertEquals("Luciano - luci - 86534102", this.controle.exibirFornecedor("Luciano"));
        try {
            this.controle.editarCadastroFonecededor("Luciano", "Nome", "Maicão");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Erro na edicao do fornecedor: nome nao pode ser editado.", erro.getMessage());
        }
    }

    @Test
    void removerCadastroFornecedor() {
        this.controle.cadastrarFornecedor("Luciano", "lucianoerick", "86534102");
        assertEquals("Luciano - lucianoerick - 86534102", this.controle.exibirFornecedor("Luciano"));
        this.controle.removerCadastroFornecedor("Luciano");
        try {
            this.controle.exibirFornecedor("Luciano");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Erro na exibicao do fornecedor: fornecedor nao existe.", erro.getMessage());
        }
        assertEquals("", this.controle.imprimirFornecedores());
    }

    @Test
    void cadastrarProdutoParaFornecedor() {
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
    void exibirProdutoDeFornecedor() {
        Fornecedor fornecedor = new Fornecedor("zé", "zedopo@hotmail.com", "13245678");
        fornecedor.cadastrarProdutoFornecedor("a", "b", 1);
        fornecedor.cadastrarProdutoFornecedor("c", "d", 2);
        assertEquals("a - b - R$1,00 | c - d - R$2,00", fornecedor.imprimirProdutosFornecedor());
    }

    @Test
    void exibirTodosProdutosDeFornecedor() {

    }

    @Test
    void exibirTodosOsProdutos() {
    }
}