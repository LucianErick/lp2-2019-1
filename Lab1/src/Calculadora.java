/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;
public class Calculadora {
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);	

		String operacao = sc.next();
		double termo1, termo2;

		if ("+".equals(operacao)) { 
			
			termo1 = sc.nextDouble();
			termo2 = sc.nextDouble(); 
			
			System.out.println("RESULTADO: " + (termo1 + termo2));
		}
	
		else if ("-".equals(operacao)) {
			
			termo1 = sc.nextDouble();
			termo2 = sc.nextDouble(); 
			
			System.out.println("RESULTADO: " + (termo1 - termo2));
			}
	
		else if ("*".equals(operacao)) {
			
			termo1 = sc.nextDouble();
			termo2 = sc.nextDouble(); 
			
			System.out.println("RESULTADO: " + (termo1 * termo2));
			}
		
		else if ("/".equals(operacao)) {
			
			termo1 = sc.nextDouble();
			termo2 = sc.nextDouble(); 
			
			if (termo2 == 0) {
				System.out.println("ERRO");
								}
			else { 
				
				System.out.println("RESULTADO: " + (termo1 / termo2));
								}
														}			
		else {
			
			System.out.println("ENTRADA INVALIDA");
			}
	sc.close();
	}
	
}	
