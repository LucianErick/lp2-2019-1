/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;

public class Wally {
	
	public static void main(String[] args) {
	

	Scanner sc = new Scanner(System.in);
	String entrada = "";
	
	while(!entrada.equals("wally")) {
		
		entrada = sc.nextLine();
		if(entrada == "wally") {
			break;
		}
		String[] array = new String[10];
		array = entrada.split(" ");
	
		String wallyEh = "";
	
		for(String nome : array) { 
			
			if(nome.length() == 5 && (!"wally".equals(nome))) {
				wallyEh = nome;
				}	
		}
		
		if (wallyEh.equals("") && (!entrada.equals("wally"))) {
			wallyEh = "?";
		}
		
		if (wallyEh.equals("")) {
			break;
			}
		
		System.out.println(wallyEh);
	}
	sc.close();
	}

}
