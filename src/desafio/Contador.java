package desafio;

import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro: ");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro: ");
		int parametroDois = terminal.nextInt();
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException e) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
		}
		terminal.close();
	
}
	
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		int contagem;
		if(parametroUm > parametroDois) {
			throw new ParametrosInvalidosException();
		}
		 else {
			contagem = parametroDois - parametroUm;
			for(int indice = 1; indice <= contagem; indice++) 
				System.out.println(indice);
		 }
	}
}
		
	

