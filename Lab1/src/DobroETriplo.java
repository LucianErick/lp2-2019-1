/**
* Laboratório de Programação 2 - Lab 1
* 
* @Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;

public class DobroETriplo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int entrada = sc.nextInt();
		
		System.out.printf("dobro: %d, triplo: %d", 2 * entrada, 3 * entrada);
		
		sc.close();
		}
	}
