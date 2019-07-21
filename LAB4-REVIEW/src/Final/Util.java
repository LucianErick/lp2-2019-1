package Final;

import java.util.Scanner;

public class Util {

    public static void validaString(String parametro, String mensagem) {
        if (parametro.trim().equals("") || parametro == null) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static String entrada(String texto) {
        Scanner sc = new Scanner(System.in);
        System.out.print(texto);
        return sc.nextLine();
    }
}
