/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;
import java.util.Locale;
public class SePassou {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double entrada1, entrada2, media;
		
		entrada1 = sc.nextDouble();
		entrada2 = sc.nextDouble();
		
		media = (entrada1 + entrada2) / 2;
	
		if (media >= 7.0) {
			
			System.out.println("pass: True!");
			}
		
		else {
			
			System.out.println("pass: False!");
			}
	
		sc.close();
		
		}
	}
