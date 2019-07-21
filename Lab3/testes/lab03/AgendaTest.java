package lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lab03.Agenda.*;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test

    void cadastroSucesso() {
        Agenda agenda = new Agenda();
        String mensagem = "CADASTRO REALIZADO!" + Utilidades.quebraLinha(1);

        assertEquals(mensagem, agenda.cadastro("Matheus", "Gaudencio","(83) 99999-0000",1));
    }

    @Test
    void cadastroSobreposto() {
        Agenda agenda = new Agenda();
        String mensagem = "CADASTRO REALIZADO!" + Utilidades.quebraLinha(1);
        // Cadastrando uma vez;
        agenda.cadastro("Nome", "Qualquer", "Telefone qualquer", 10);
        // Cadastrando um contato diferente na mesma posicao.
        agenda.cadastro("Pedro", "Alcântara", "13265478", 10);
        assertEquals(mensagem, agenda.cadastro("Pedro", "Alcântara", "13265478", 10));
    }

    @Test
    void cadastroPosicaoInvalida() {
        Agenda agenda = new Agenda();
        String mensagem = "Posição Inválida!" + Utilidades.quebraLinha(1);

        assertEquals(mensagem, agenda.cadastro("Peter", "Parker", "666999966", 0));
    }

    @Test
    void cadastroPosicaoInvalida2() {
        Agenda agenda = new Agenda();
        String mensagem = "Posição Inválida!" + Utilidades.quebraLinha(1);

        assertEquals(mensagem, agenda.cadastro("Ana", "Carolina", "40028922", 101));
    }

    @Test

    void cadastroNoLimite() {
        Agenda agenda = new Agenda();
        String mensagem = "CADASTRO REALIZADO!" + Utilidades.quebraLinha(1);

        assertEquals(mensagem,agenda.cadastro("Maria", "Flor", "+1 (595) 5555-1234", 100));
    }

    @Test

    void exibicao() {
        Agenda agenda = new Agenda();
        agenda.cadastro("Nome", "Qualquer", "12345678", 10);
        assertEquals(  Utilidades.quebraLinha(1) + "Nome Qualquer - 12345678" + Utilidades.quebraLinha(1) ,agenda.exibicao(10));
    }

    @Test
    void exibicao2() {
        Agenda agenda = new Agenda();
        agenda.cadastro("João", "da Silva", "12345678", 4);
        assertEquals( "\nJoão da Silva - 12345678\n",agenda.exibicao(4));
    }

    @Test
    void listagem() {
    Agenda agenda = new Agenda();
    agenda.cadastro("Manuel", "Costa", "33245688", 10);
    agenda.cadastro("Marcos", "Costa", "44125478", 4);
    agenda.cadastro("Josevaldo", "Costa", "996584632", 98);

    assertEquals("4 - Marcos Costa\n" + "10 - Manuel Costa\n" + "98 - Josevaldo Costa\n", agenda.listagem());
    }

    @Test
    void equals() {
        Agenda agenda1 = new Agenda();

        agenda1.cadastro("Priscila", "Silva", "33245688", 6);
        agenda1.cadastro("Marcela", "Silva", "44125478", 15);
        agenda1.cadastro("Lucas", "Silva", "996584632", 96);

        Agenda agenda2 = new Agenda();

        agenda2.cadastro("Priscina", "Silva", "33245688", 6);
        agenda2.cadastro("Marcela", "Silva", "44125478", 15);
        agenda2.cadastro("Lucas", "Silva", "996584632", 96);

        assertEquals(agenda1,agenda2);


    }
}