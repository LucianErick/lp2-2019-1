package Final;

public class Util {
    public static void validaString(String parametro, String mensagem) {
        if (parametro.trim().equals("") || parametro == null) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
