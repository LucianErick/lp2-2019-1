package lab4;
import java.util.Scanner;

/**
 * Classe auxiliar que contém funcionalidades auxiliares no código.

 * @author Luciano Erick Sousa Figueiredo Filho - Matrícula: 118110400
 */
public class Utilidades {

    /**
     * Pula uma determinada quantidade de linhas.
     * @param qtdLinhas um inteiro que representa quantas linhas pular.
     * @return uma "quebra" de linha
     */
    public static String quebralinha(int qtdLinhas){
        String saida = "";
        for (int i = 0; i < qtdLinhas; i++) {
            saida += System.lineSeparator();
        }
        return saida;
    }

    /**
     * Lê uma entrada com uma mensagem já escrita, de modo a faciliar o input.
     * @param mensagem uma mensagem qualquer, do tipo String.
     * @return a leitura de uma entrada.
     */
    public static String entrada(String mensagem) {
        Scanner sc = new Scanner(System.in);

        System.out.print(mensagem);
        return sc.nextLine();
    }
}
