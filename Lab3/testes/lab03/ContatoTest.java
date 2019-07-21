package lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {

    @Test
    void testeSucesso(){
        Contato umContato = new Contato("Luís", "Fernandes", "(41) 2362-6070");
        assertEquals("Luís", umContato.getNome());
        assertEquals("Fernandes", umContato.getSobrenome());
        assertEquals("(41) 2362-6070", umContato.getTelefone());
    }

    @Test
    void testeSucesso2(){
        Contato umContato = new Contato("Ana Calorina", "Vasconcelos", "(83) 4002-8922");
        assertEquals("Ana Calorina", umContato.getNome());
        assertEquals("Vasconcelos", umContato.getSobrenome());
        assertEquals("(83) 4002-8922", umContato.getTelefone());
    }

    @Test
    void testeSucesso3(){
        Contato umContato = new Contato("Luciano Erick", "Figueiredo", "(83) 98653-4102");
        assertEquals("Luciano Erick", umContato.getNome());
        assertEquals("Figueiredo", umContato.getSobrenome());
        assertEquals("(83) 98653-4102", umContato.getTelefone());
    }

    @Test
    void testeSucesso4() {
        Contato umContato = new Contato("ó", "de sá", "(45) 1234-5678");
        assertEquals("ó" , umContato.getNome());
        assertEquals("de sá", umContato.getSobrenome());
        assertEquals("(45) 1234-5678", umContato.getTelefone());
    }

    @Test
    void comparacaoInformacoesDiferentes() {
        Contato contato1 = new Contato("Jair", "Bolsonaro", "(17) 986546528");
        Contato contato2 = new Contato("Maria", "Do Rosário", "(13) 987321421");

        assertFalse(contato1.equals(contato2));

    }

    @Test
    void comparacaoSobrenomesDiferentes() {
        Contato contato1 = new Contato("Michael", "Douglas", "(17) 986546528");
        Contato contato2 = new Contato("Michael", "Ribeiro", "(21) 987321421");

        assertFalse(contato1.equals(contato2));
    }
    @Test
    void comparacaoNomesIguais() {
        Contato contato1 = new Contato("Ana Beatriz", "Porto", "(21) 987654321");
        Contato contato2 = new Contato("Ana Beatriz", "Porto", "(21) 987654321");

        assertTrue(contato1.equals(contato2));
    }

    @Test

    void comparacaoInformacoesIguais() {
        Contato contato1 = new Contato("Ana Beatriz", "Porto", "(12) 912345678");
        Contato contato2 = new Contato("Ana Beatriz", "Porto", "(21) 987654321");

        assertTrue(contato1.equals(contato2));
    }

    @Test

    void saidaNormal() {
        Contato umContato = new Contato("Jucelino", "NomeDificil", "(12) 912345678");
        assertEquals("Jucelino NomeDificil - (12) 912345678", umContato.toString());
    }

    @Test
    void saidaNormal2() {
        Contato umContato = new Contato("Antônio Bertino", "É lindo demais", "(S2) 912345678");
        assertEquals("Antônio Bertino É lindo demais - (S2) 912345678", umContato.toString());
    }

    @Test
    void saidaNormal3() {
        Contato umContato = new Contato("Manuela", "Cavalcante", "(83) 987456321");
        assertEquals("Manuela Cavalcante - (83) 987456321", umContato.toString());
    }
}