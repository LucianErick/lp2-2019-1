package Final.Sistema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinALTest {

    private FinAL sistema;

    @BeforeEach
    void setUp() {
        sistema = new FinAL();
    }

    @Test

    void testaTudo() {
        this.sistema.cadastrarPontual("nao sei", 1, 3, 2);
        this.sistema.cadastrarServico("hmm", 3,250,230);

        assertEquals("1 - hmm - 3 - 230h - R$250/h - R$57500", sistema.exibirDespesa(1));
        assertEquals("", sistema.exibirDespesa(2));
        sistema.cadastrarCategoria("opa", "num sei");
        sistema.associarDespesaACategoria("opa", 1);
        sistema.associarDespesaACategoria("opa", 2);

        assertEquals(1, sistema.despesaMaisCara("opa"));

    }

}