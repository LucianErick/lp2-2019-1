/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Locale;
import java.util.Scanner;

public class AcimaDaMedia{

	public static void main(String[] args) {
	
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	String linha = sc.nextLine();
	int soma = 0, quantidade = 0;
	for(String caractere : linha.split(" ")) {
		soma += Integer.parseInt(caractere);
		quantidade += 1;
	}
	
	double media = soma / quantidade;
	
	for(String numero : linha.split(" ")) {
		
		if(Integer.parseInt(numero) > media) {
			System.out.print(numero + " ");
		}
		
	}
	sc.close();
	}
}
