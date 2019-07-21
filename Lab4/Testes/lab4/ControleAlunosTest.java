package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleAlunosTest {

    private ControleAlunos controller;

    @BeforeEach
    void setUp() {
        this.controller = new ControleAlunos();
    }

    @Test
    void testCadastraAluno() {
        assertEquals("CADASTRO REALIZADO!", this.controller.cadastroAluno("118110", "Luciano", "CC"));
        assertEquals("MATRÍCULA JÁ CADASTRADA!", this.controller.cadastroAluno("118110","Luciano","CC"));
        try {
            this.controller.cadastroAluno("   ", "Lulinha", "Cadeia");
            fail();
        } catch (IllegalArgumentException erro){
            assertEquals("Matrícula inválida!", erro.getMessage());
        }

        try {
            this.controller.cadastroAluno("13", "", "Cadeia");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Nome inválido!", erro.getMessage());
        }

        try {
            this.controller.cadastroAluno("13", "Lulinha", null);
        } catch (IllegalArgumentException erro){
            assertEquals("Curso inválido!", erro.getMessage());
        }
    }

    @Test
    void testExibeAluno() {
        this.controller.cadastroAluno("1181","Luci","Ciência da Computação");
        assertEquals("Aluno: 1181 - Luci - Ciência da Computação", this.controller.consultaAluno("1181"));
        assertEquals("Aluno não cadastrado.",this.controller.consultaAluno("666"));
        try {
            this.controller.consultaAluno(null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Matrícula inválida!", erro.getMessage());
        }

        try {
            this.controller.consultaAluno(" ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Matrícula inválida!", erro.getMessage());
        }
    }

    @Test
    void testCadastraGrupo() {
        assertEquals("CADASTRO REALIZADO!", this.controller.cadastraGrupo("Programação 2"));
        assertEquals("GRUPO JÁ CADASTRADO!", this.controller.cadastraGrupo("ProGRAmaÇÃo 2"));

        try {
            this.controller.cadastraGrupo(null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }

        try {
            this.controller.cadastraGrupo(" ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }
    }

    @Test
    void testAlocaAluno() {
            this.controller.cadastroAluno("1181","Luciano","Ciência da Computação");
            assertEquals("CADASTRO REALIZADO!",this.controller.cadastraGrupo("P2"));
            assertEquals("ALUNO ALOCADO!",this.controller.alocaAluno("1181","P2"));
            assertEquals("ALUNO ALOCADO!",this.controller.alocaAluno("1181","p2"));
            assertEquals("Grupo não cadastrado.",this.controller.alocaAluno("1181","Python"));
            assertEquals("Aluno não cadastrado.", this.controller.alocaAluno("1623","p2"));
            assertEquals("Aluno e Grupo não cadastrados.", this.controller.alocaAluno("000", "aaa"));
            try {
                this.controller.alocaAluno(" ", "fmcc");
                fail(); }
            catch (IllegalArgumentException erro) {
                assertEquals("Matrícula inválida!", erro.getMessage());
            }
            try {
                this.controller.alocaAluno("1181", " ");
                fail(); }
            catch (IllegalArgumentException erro) {
                assertEquals("Tema inválido!", erro.getMessage());
            }
    }

    @Test
    void testImprimeGrupo() {
        this.controller.cadastroAluno("123","Luciano","Ciência da Computação");
        this.controller.cadastroAluno("456","Erick", "Direito");

        this.controller.cadastraGrupo("Python");
        this.controller.cadastraGrupo("Java");
        this.controller.alocaAluno("123","Java");
        this.controller.alocaAluno("456","Java");

        String saidaEsperada = Utilidades.quebralinha(1) + "Alunos do grupo Java:" + Utilidades.quebralinha(1)
                + "* 123 - Luciano - Ciência da Computação" + Utilidades.quebralinha(1)
                + "* 456 - Erick - Direito" + Utilidades.quebralinha(1);

        assertEquals(saidaEsperada,this.controller.imprimeGrupo("Java"));
        assertEquals(saidaEsperada,this.controller.imprimeGrupo("JaVA"));

        try {
            this.controller.imprimeGrupo(null);
            fail(); }
        catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }
        try {
            this.controller.imprimeGrupo(" ");
            fail(); }
        catch (IllegalArgumentException erro) {
            assertEquals("Tema inválido!", erro.getMessage());
        }
    }

    @Test
    void testCadastraRespostaAluno() {
        this.controller.cadastroAluno("123", "Pedro", "Direito");
        assertEquals("ALUNO REGISTRADO!",this.controller.cadastraRespostaAluno("123"));
        assertEquals("Aluno não cadastrado.", this.controller.cadastraRespostaAluno("321"));
        assertEquals("ALUNO REGISTRADO!",this.controller.cadastraRespostaAluno("123"));
        try {
            this.controller.cadastraRespostaAluno(null);
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Matrícula inválida!", erro.getMessage());
        }

        try {
            this.controller.cadastraRespostaAluno(" ");
            fail();
        } catch (IllegalArgumentException erro) {
            assertEquals("Matrícula inválida!", erro.getMessage());
        }
    }

    @Test
    void testImprimeAlunosQueResponderam() {

        this.controller.cadastroAluno("123","Pedro","Ciência da Computação");
        this.controller.cadastroAluno("321","Paulo","Arquitetura");
        this.controller.cadastraRespostaAluno("123");
        this.controller.cadastraRespostaAluno("321");
        this.controller.cadastraRespostaAluno("123");

        String saida = "Alunos:" + Utilidades.quebralinha(1)
                + "1. 123 - Pedro - Ciência da Computação" + Utilidades.quebralinha(1)
                + "2. 321 - Paulo - Arquitetura" + Utilidades.quebralinha(1)
                + "3. 123 - Pedro - Ciência da Computação" + Utilidades.quebralinha(1);

        assertEquals(saida,this.controller.imprimeAlunosRespostas());
    }
    }