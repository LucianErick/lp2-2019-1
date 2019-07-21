/**
* Laboratório de Programação 2 - Lab 1
* 
* @author Luciano Erick Sousa Figueiredo Filho - 118110400
*/

import java.util.Scanner;
public class AlunosENotas {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] planilha = new int[10];
		
		String nome = "";
		int nota = 0, i = 0, soma = 0, quantidade = 0; // Definindo os contadores iniciais necessárias
		int maior = 0, menor = 0, media = 0, acima = 0, abaixo = 0; // Definindo as variáveis a serem impressas
		
		while(! nome.equals("-")) {
			
			
		planilha[i] = nota;
		
		i += 1;
		soma += nota;
		quantidade += 1;
		}
		
		media = soma / quantidade;

		for (int j=0; j<10; j++) {
			
			if(planilha[j] > maior) {
				maior = planilha[j];
				}
			
			if(planilha[j] < menor) {
				menor = planilha[j];
				}
			
			if(planilha[j] >= 700) {
				acima += 1;
				}
			
			if(planilha[j] < 700) {
				abaixo += 1;
				}	
			
			System.out.println("maior: " + maior);
			System.out.println("menor: " + menor);
			System.out.println("media: " + media);
			System.out.println("acima: " + acima);
			System.out.println("abaixo: " + abaixo);
			}
			
	sc.close();
	}
}
