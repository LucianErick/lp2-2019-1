package lab03;
import java.util.Scanner;

   /**
    * Classe auxiliar, contendo funcionalidades que ajudam na construcao
    * do codigo.

    * @author Luciano Erick Sousa Figueiredo Filho - Matricula: 118110400.
    */

   public class Utilidades {

       /**
        * Facilita a entrada do prompt, evitando repeticao de codigo e deixando mais
        * organizado, ja estanciando o objeto sc.
        * @param mensagem a mensagem intuitiva que diz pro usuario qual dado digitar.
        * @return o método nextLine, esperando uma entrada do tipo string.
        */
    public static String entrada(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        return sc.nextLine();
    }
       /**
        * Facilita a quebra de linhas, ao invés do pouco intuitivo "\n", deixando
        * o codigo mais organizado.

        * @param qntdLinhas a quantidades de linhas a serem "puladas".
        * @return a quebra da quantidade de linhas requeridas pelo usuario.
        */
    public static String quebraLinha(int qntdLinhas) {
        String linha = "";
        for (int i = 0; i < qntdLinhas; i++) {
            linha += System.lineSeparator();
        }
        return linha;
    }
}
