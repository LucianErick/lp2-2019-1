package lab5.Fornecedores.Produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void testConstrutor() {
        Produto produto = new Produto("maconha", "da boa", 10);
        assertEquals("maconha" , produto.getNome());
        assertEquals("da boa", produto.getDescricao());
        assertEquals(10, produto.getPreco());
    }
    @Test
    void testSetPreco() {
        Produto produto = new Produto("maconha", "da boa", 10);
        produto.setPreco(100);
        assertEquals(100, produto.getPreco());
    }

    @Test
    void testEquals() {
        Produto produto1 = new Produto("maconha", "da boa", 10);
        Produto produto2 = new Produto("agua", "da boa", 10);
        Produto produto3 = new Produto("maconha", "da ruim", 10);
        Produto produto4 = new Produto("maconha", "da boa", 5);

        assertFalse(produto1.equals(produto2));
        assertFalse(produto2.equals(produto3));
        assertTrue(produto1.equals(produto4));
    }

    @Test
    void testToString() {
        Produto produto = new Produto("maconha", "da boa", 10);
        assertEquals("maconha - da boa - R$10,00", produto.toString());
    }
}