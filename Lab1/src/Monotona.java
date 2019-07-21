/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;

public class Monotona {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int entrada1, entrada2, entrada3, entrada4;
		
		entrada1 = sc.nextInt();
		entrada2 = sc.nextInt();
		entrada3 = sc.nextInt();
		entrada4 = sc.nextInt();
		
		if (entrada1 > entrada2 && entrada3 > entrada4 && entrada2 > entrada3 && entrada1 > entrada4)  {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
			}
		
		else if (entrada4 > entrada3 && entrada2 > entrada1 && entrada3 > entrada2 && entrada4 > entrada1) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
			}
			
		else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
			}
		sc.close();
	}
}
