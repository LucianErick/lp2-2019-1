package lab5.Clientes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void testConstrutorParametrosValidos() {
        Cliente cliente1 = new Cliente("12345678900", "Zé ninguém", "eunaotenhoemail@gmail.com", "404-Not Found");
        assertEquals("12345678900", cliente1.getCpf());
        assertEquals("Zé ninguém", cliente1.getNome());
        assertEquals("404-Not Found", cliente1.getLocalizacao());
        assertEquals("eunaotenhoemail@gmail.com", cliente1.getEmail());
    }

    @Test
    void testConstrutorParametrosInvalidos() {
        try {
         Cliente cliente1 = new Cliente(null, "Qualquer um aí",  "emailaleatorio@gmail.com", "alguma aí");
         fail();
        } catch (IllegalArgumentException erro){
            assertEquals("cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("     ", "Qualquer um aí", "emailaleatorio@gmail.com", "alguma aí");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("cpf nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", null, "emailaleatorio@gmail.com", "alguma aí");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("nome nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", "    ","emailaleatorio@gmail.com", "alguma aí" );
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("nome nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", "Qualquer um aí", null, "qualquer um");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("email nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", "Qualquer um aí", "     ", "qualquer um");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("email nao pode ser vazio ou nulo.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", "Qualquer um aí", "algum aí", null);
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("localizacao nao pode ser vazia ou nula.", erro.getMessage());
        }

        try {
            Cliente cliente1 = new Cliente("00000000000", "Qualquer um aí", "alguma aí", "      ");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("localizacao nao pode ser vazia ou nula.", erro.getMessage());
        }
    }

    @Test
    void testEquals() {
        Cliente cliente1 = new Cliente("12345678900", "Zé", "eunaotenhoemail@gmail.com", "CG");
        Cliente cliente2 = new Cliente ("98765432199", "Maria",  "eutenhoemail@gmail.com", "JP");
        Cliente cliente3 = new Cliente("12345678900", "Outro Zé", "eusouze@gmail.com", "BH");

        assertEquals(false, cliente1.equals(cliente2));
        assertEquals(true, cliente1.equals(cliente3));
    }

    @Test
    void testToString() {
        Cliente cliente1 = new Cliente("12345678900", "Zé",  "eunaotenhoemail@gmail.com", "CG");
        String saidaEsperada = "Zé - CG - eunaotenhoemail@gmail.com";
        assertEquals(saidaEsperada, cliente1.toString());
    }
}