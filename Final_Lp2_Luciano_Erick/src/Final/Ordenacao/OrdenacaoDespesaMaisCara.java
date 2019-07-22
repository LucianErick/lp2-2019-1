package Final.Ordenacao;

import Final.Entidades.Despesa;

import java.util.Comparator;

public class OrdenacaoDespesaMaisCara implements Comparator {

    public int compare(Object o1, Object o2) {
        o1 = (Despesa)o1;
        return ((Despesa) o1).getValorFinal() - ((Despesa) o2).getValorFinal();

    }
}
