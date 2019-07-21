package lab4.main;

import lab4.ControleAlunos;
import lab4.Utilidades;

import static lab4.Utilidades.*;
import static lab4.Utilidades.entrada;
import static lab4.Utilidades.quebralinha;

    /**
    * @author Luciano Erick Sousa Figueiredo Filho - Matrícula: 118110400
    */
public class Menu {

    public static void main(String[] args) {
        exibirMenu();
    }
    public static void exibirMenu() {

        ControleAlunos controller = new ControleAlunos();

        String menuInterativo = "(C)adastrar Aluno" + quebralinha(1)
                + "(E)xibir Aluno" + quebralinha(1)
                + "(N)ovo Grupo" + quebralinha(1)
                + "(A)locar Aluno no Grupo e Imprimir Grupos" + quebralinha(1)
                + "(R)egistrar Aluno que Respondeu" + quebralinha(1)
                + "(I)mprimir Alunos que Responderam" + quebralinha(1)
                + "(O)ra, vamos fechar o programa!" + quebralinha(1)
                + "Opção> ";

        String opcao;
        do {
            opcao = entrada(menuInterativo).toUpperCase();
            System.out.print(quebralinha(1));
            switch (opcao) {

                case "C":
                    cadastrarAluno(controller);
                    // Cadastra aluno;
                    break;

                case "E":
                    exibirAluno(controller);
                    // Consulta os dados de um determinado aluno;
                    break;

                case "N":
                    cadastrarGrupo(controller);
                    // Cadastra um novo grupo de estudos;
                    break;

                case "A":
                    String opcao2 = entrada("(A)locar Aluno ou (I)mprimir Grupo? ").toUpperCase();
                    if (opcao2.equals("A")) {
                        alocarAluno(controller);
                    }
                    else if (opcao2.equals("I")) {
                        imprimirGrupo(controller);
                    } else {
                        System.out.println("OPÇÃO INVÁLIDA!" + quebralinha(1));
                    }
                    break;

                case "R":
                    registrarRespostaDeAluno(controller);
                    break;

                case "I":
                    imprimirAlunosQueResponderam(controller);
                    break;

                case "O":
                    //Encerrar programa.
                    break;

                default:
                    System.out.println("Opção inválida!" + quebralinha(1));
            }
        } while (!opcao.equals("O"));
    }

    private static void cadastrarAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");
        String nome = entrada("Nome: ");
        String curso = entrada("Curso: ");

        System.out.println(controller.cadastroAluno(matricula, nome, curso) + quebralinha(1));
    }

    private static void exibirAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");

        System.out.println(controller.consultaAluno(matricula) + quebralinha(1));
    }

    private static void cadastrarGrupo(ControleAlunos controller) {
        String tema = entrada("Tema: ");

        System.out.println(controller.cadastraGrupo(tema) + quebralinha(1) );
    }

    private static void alocarAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");
        String tema = entrada("Tema: ");

        System.out.println(controller.alocaAluno(matricula, tema) + quebralinha(1));
    }

    private static void imprimirGrupo(ControleAlunos controller) {
        String tema = entrada("Tema: ");

        System.out.println(controller.imprimeGrupo(tema) + quebralinha(1));
    }

    private static void registrarRespostaDeAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");

        System.out.println(controller.cadastraRespostaAluno(matricula) + quebralinha(1));
    }

    private static void imprimirAlunosQueResponderam(ControleAlunos controller){
        System.out.println(controller.imprimeAlunosRespostas() + quebralinha(1));
    }
}