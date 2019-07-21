package Final;

import static Final.Util.entrada;

public class Facade {

    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        ControleAlunos controller = new ControleAlunos();

        String menuInterativo = "(C)adastrar Aluno" + "\n"
                + "(E)xibir Aluno" + "\n"
                + "(N)ovo Grupo" + "\n"
                + "(A)locar Aluno no Grupo e Imprimir Grupos" + "\n"
                + "(R)egistrar Aluno que Respondeu" + "\n"
                + "(I)mprimir Alunos que Responderam" + "\n"
                + "(O)ra, vamos fechar o programa!" + "\n"
                + "Opção> ";

        String opcao;
        do {
            opcao = entrada(menuInterativo).toUpperCase();
            System.out.print("\n");
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
                        System.out.println("OPÇÃO INVÁLIDA!" + "\n");
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
                    System.out.println("Opção inválida!" + "\n");
            }
        } while (!opcao.equals("O"));
    }

    private static void cadastrarAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");
        String nome = entrada("Nome: ");
        String curso = entrada("Curso: ");

        System.out.println(controller.cadastrarAluno(matricula, nome, curso) + "\n");
    }

    private static void exibirAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");

        System.out.println(controller.consultarAluno(matricula) + "\n");
    }

    private static void cadastrarGrupo(ControleAlunos controller) {
        String tema = entrada("Tema: ");

        System.out.println(controller.cadastrarGrupo(tema) + "\n" );
    }

    private static void alocarAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");
        String tema = entrada("Tema: ");

        System.out.println(controller.alocarAluno(matricula, tema) + "\n");
    }

    private static void imprimirGrupo(ControleAlunos controller) {
        String tema = entrada("Tema: ");

        System.out.println(controller.imprimirGrupo(tema) + "\n");
    }

    private static void registrarRespostaDeAluno(ControleAlunos controller) {
        String matricula = entrada("Matrícula: ");

        System.out.println(controller.cadastrarAlunoQueRespondeu(matricula) + "\n");
    }

    private static void imprimirAlunosQueResponderam(ControleAlunos controller){
        System.out.println(controller.imprimirAlunosResponderam() + "\n");
    }
}