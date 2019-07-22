package Final.Util;

public class Validador {

    public static void validadaString(String parametro, String mensagem) {

        if (parametro.trim().equals("") || parametro == null) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
