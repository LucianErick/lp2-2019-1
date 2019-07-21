package lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoEstudoTest {
    @Test
    void testConstrutorComParametroValido() {
        GrupoEstudo grupoAlunos = new GrupoEstudo("P2");
        assertEquals("P2", grupoAlunos.getTema());
    }

    @Test
    void testConstrutorComParametroInvalido() {
        try {
            GrupoEstudo grupoAlunos = new GrupoEstudo("     ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }

        try {
            GrupoEstudo grupoAlunos = new GrupoEstudo(null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }
    }

    @Test
    void testAlocarAlunoComAlunoInvalido() {
        try {
            Aluno aluno = null;
            GrupoEstudo grupoAlunos = new GrupoEstudo("Sei lá");
            grupoAlunos.alocarAluno(aluno);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Aluno inválido!", erro.getMessage());
        }
    }

    @Test
    void testAlocarAlunoComAlunoValido() {
        Aluno aluno = new Aluno("123", "Luciano", "CC");
        GrupoEstudo grupoAlunos = new GrupoEstudo("FMCC2 do cão");

        assertEquals("ALUNO ALOCADO!", grupoAlunos.alocarAluno(aluno));

    }

    @Test
    void testImprimeAlunosDoGrupo() {
        Aluno aluno1 = new Aluno("132", "Luci", "CC");
        Aluno aluno2 = new Aluno("41115", "Bolso", "sem curso ok");
        GrupoEstudo grupoAlunos = new GrupoEstudo("Um assunto totalmente aleatorio aí");

        grupoAlunos.alocarAluno(aluno1);
        grupoAlunos.alocarAluno(aluno2);

        assertEquals("* " + aluno2.toString() + Utilidades.quebralinha(1) + "* " + aluno1.toString() + Utilidades.quebralinha(1), grupoAlunos.imprimeAlunos());
    }

    @Test
    void testEqualsEntre2Grupos() {
        GrupoEstudo grupo1 = new GrupoEstudo("P2");
        GrupoEstudo grupo2 = new GrupoEstudo("FMCC");
        GrupoEstudo grupo3 = new GrupoEstudo("P2");

        assertNotEquals(grupo1, grupo2);
        assertNotEquals(grupo2, grupo3);
        assertEquals(grupo1, grupo3);
    }
}