package candidatura;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		/*
		analisarCandidato(1900.0);
		analisarCandidato(2300.0);
		analisarCandidato(2000.0);
		*/
		
		selecaoCandidatos();
	}
	static void selecaoCandidatos() {
		String [] candidatos = {"LUIZ", "JOÃO", "MARIA", "ANA", "FÁBIO", "GABRIELA", "ROBERTO", "SÉRGIO", "ELISA", "DAVID"};
		String [] listaCandidatosSelecionados = new String[5];
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			DecimalFormat df = new DecimalFormat("#.00");
			
			System.out.println("O candidato " + candidato + " solicitou esse valor de salário: R$" + df.format(salarioPretendido));
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
				listaCandidatosSelecionados[candidatosSelecionados] = candidato;
				candidatosSelecionados++;
				
			}
			candidatoAtual++;
			
		}
		System.out.println("Lista de candidatos selecionados abaixo:");
		for(String candidatoSelecionado: listaCandidatosSelecionados) {
			if(candidatoSelecionado != null)
			System.out.println(candidatoSelecionado);
		}
		
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	/*
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO!");
		} else if(salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA!");
		} else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS!!");
		}
	}
	*/
}
