package lab03.Main;
import lab03.Agenda;
import lab03.Utilidades;

    /**
     * Representacao do menu de interacao sobre uma agenda de contatos, contendo
     * as opcoes que podem ser escolhidas pelo usuario.

     * @author Luciano Erick Sousa Figueiredo Filho - Matricula: 118110400
     */

    public class Menu {

        /**
         * Representacao do menu de interacao, com as opcoes que o usuario
         * pode interagir e, implicitamente, as operacoes por tras.
         */
        public static void exibirMenu(){

            String menuInteracao =
                    "(C)adastrar Contato" + Utilidades.quebraLinha(1)
                    + "(L)istar Contatos" + Utilidades.quebraLinha(1)
                    + "(E)xibir Contato" + Utilidades.quebraLinha(1)
                    + "(S)air" + Utilidades.quebraLinha(2)
                    + "Opção> ";

            String opcao;
            Agenda agenda = new Agenda();

            do {
                opcao = Utilidades.entrada(menuInteracao).toUpperCase();
                switch (opcao) {
                    case "C":
                        cadastraPessoa(agenda);
                        break;

                    case "L":
                        listarContatos(agenda);
                        break;

                    case "E":
                        exibirContato(agenda);
                        break;

                    case "S":
                        break;

                    default:
                        System.out.println("OPÇÃO INVÁLIDA!" + Utilidades.quebraLinha(1));
                }

            } while (!opcao.equals("S"));
        }

        /**
         * Operacao de cadastro de um contato na agenda, apos o usuario digitar "C".
         * Nao ha retorno, apenas a implementacao do metodo cadastro(classe Agenda) no objeto agenda.

         * @param agenda um objeto que contém a lista de contatos.
         */
        private static void cadastraPessoa(Agenda agenda) {

            String posicao = Utilidades.entrada("Posição: ");
            String nome = Utilidades.entrada("Nome: ");
            String sobrenome = Utilidades.entrada("Sobrenome: ");
            String telefone = Utilidades.entrada("Telefone: ");

            String a = agenda.cadastro(nome, sobrenome, telefone, Integer.parseInt(posicao));
            System.out.println(a);
        }

        /**
         * Operacao de listagem de contatos da agenda, apos o usuario digitar "L".
         * @param agenda um objeto que contém a lista de contatos.
         */
        private static void listarContatos(Agenda agenda) {
            System.out.println(Utilidades.quebraLinha(1) + agenda.listagem());
        }

        /**
         * Operacao de exibicao de um determinado contato da lista de contatos, apos o usuario digitar
         * "E".
         * @param agenda um objeto que contém a lista de contatos.
         */
        private static void exibirContato(Agenda agenda) {
            String posicao = Utilidades.entrada("Posição> ");
            System.out.println(agenda.exibicao(Integer.parseInt(posicao)));
        }
    }