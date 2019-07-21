package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
     void testConstrutorComTodosOsParametrosValidos() {
        Aluno aluno = new Aluno("1181", "Aiaiai Bolsonaro eh o car**", "Cc");
        assertEquals("1181", aluno.getMatricula());
        assertEquals("Aiaiai Bolsonaro eh o car**", aluno.getNome());
        assertEquals("Cc", aluno.getCurso());
    }

    @Test
    void testConstrutorComMatriculaInvalida() {
        try {
        Aluno aluno = new Aluno(null, "Salnorabo", "infelizmente n tem curso, pois ele n gosta de univesidade :(");
        fail();
        } catch (IllegalArgumentException erro) {
           assertEquals("Matrícula inválida!", erro.getMessage());
        }

        try {
        Aluno aluno = new Aluno("   ", "Salnorabo", "infelizmente n tem curso, pois ele n gosta de univesidade :(");
        fail();
        } catch (IllegalArgumentException erro) {
           assertEquals("Matrícula inválida!", erro.getMessage());
        }

    }

    @Test
    void testConstrutorComNomeInvalido(){

        try {
            Aluno aluno = new Aluno("17", null, "infelizmente n tem curso, pois ele n gosta de univesidade :(");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }

        try {
            Aluno aluno = new Aluno("17", "     ", "infelizmente n tem curso, pois ele n gosta de univesidade :(");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }
    }

    @Test
    void testConstrutorComCursoInvalido(){

        try {
            Aluno aluno = new Aluno("17", "Bolso", null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Curso inválido!", erro.getMessage());
        }

        try {
            Aluno aluno = new Aluno("17", "Bolso", "    ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Curso inválido!", erro.getMessage());
        }
    }

    @Test
    void testEqualsTrueComDoisAlunosValidos() {
        Aluno aluno1 = new Aluno("1181", "Luciano", "Ciência da Computação");
        Aluno aluno2 = new Aluno("1181", "Luci", "Ciência da Computação");

        assertEquals(aluno1,aluno2);
    }

    @Test
    void testEqualsFalseComDoisAlunosValidos() {
        Aluno aluno1 = new Aluno("1181", "Luciano", "Ciência da Computação");
        Aluno aluno2 = new Aluno("321", "Ana", "Computação");

        assertNotEquals(aluno1,aluno2);
    }

    @Test
    void testToStringDeUmAlunoValido(){
        Aluno aluno = new Aluno("1181", "Luciano", "Ciência da Computação");
        assertEquals("1181 - Luciano - Ciência da Computação", aluno.toString());
    }


}