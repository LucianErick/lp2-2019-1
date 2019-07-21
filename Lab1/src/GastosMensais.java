/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/
import java.util.Scanner;

public class GastosMensais {

    public static void main(String[] args) {
		
        String[] listaMeses = new String[12];
        String[] listaValores = new String[12];

        Scanner sc = new Scanner(System.in);
        
        String meses, valores, objetivo;

        meses = sc.nextLine();
        listaMeses = meses.split(" ");
        valores = sc.nextLine();
        listaValores = valores.split(" ");

        objetivo = sc.nextLine();

        for (int i=0;i<12;i++){
            if (objetivo.equals(listaMeses[i])) {
                System.out.println(listaValores[i]);
			}
    	}
    }

}
