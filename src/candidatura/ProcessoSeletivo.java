package candidatura;

import java.text.DecimalFormat;
import java.util.Random;
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
		String [] listaCandidatosSelecionados = new String[5]; //array em que serão armazenados os candidatos selecionados
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		System.out.println("Salário pretendido pelos candidatos:");
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
		
		//vai imprimir a lista de candidatos que serão chamados pra entrevista
		System.out.println("---------------------------------------------------");
		System.out.println("Lista de candidatos selecionados abaixo:");
		for(String candidatoSelecionado: listaCandidatosSelecionados) {
			if(candidatoSelecionado != null)
			System.out.println(candidatoSelecionado);
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Entrando em contato com os candidatos selecionados:");
		for(String candidato: listaCandidatosSelecionados) {
			if(candidato != null)
			entrandoEmContato(candidato);
		}
	}
	
	//vai gerar um valor aleatório entre 1800 e 2200
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else 
				System.out.println("CONTATO REALIZADO COM SUCESSO!");
		} while (continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA.");
		else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NAS " + tentativasRealizadas + " TENTATIVAS REALIZADAS.");
		}
	}
	
	//método auxiliar simulando o atendimento da ligação
	static boolean atender() {
		return new Random().nextInt(3)==1;
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
