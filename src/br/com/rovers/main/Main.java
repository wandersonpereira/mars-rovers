package br.com.rovers.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.rovers.entidades.Rover;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String continuar = "";
		
		List<Rover> listaRovers = new ArrayList<>();
		
		System.out.println("Informe a cordenada maxima de X e Y:");
		Scanner lerCoordenadaXY = new Scanner(System.in);
		String maximoCoordenadaXY = lerCoordenadaXY.nextLine();
		
		//Captura as coordenadas e movimentações dos Rovers
		do {
			System.out.println("Informe o posicionamento de X e Y e a orietanção do rover:");
			//Captura a posicão inicial do rover
			Scanner lerPosicionamento = new Scanner(System.in);
			String posicionamento = lerPosicionamento.nextLine();

			System.out.println("Informe a movimentação do rover:");
			//Captura a movimentação do rover
			Scanner lerMovimentacao = new Scanner(System.in);
			String movimentacao = lerMovimentacao.nextLine();
			
			Rover rover = new Rover();
			rover.montarCoordenadas(posicionamento);
			rover.montarMovimentacao(movimentacao);
			rover.montarMaximoCoordenadas(maximoCoordenadaXY);
			
			//Faz a movimentação do rover
			rover.movimentarRover();
			
			//Adiciona o rover na lista
			listaRovers.add(rover);
			
			System.out.println("Cadastrar novo rover (s/n)");
			Scanner lerContinuar = new Scanner(System.in);
			continuar = lerContinuar.nextLine();
			
		} while(continuar.toUpperCase().equals("S"));

		printarListaRover(listaRovers);
		
	}
	
	/**
	 * Printa o resltado no console
	 * @param listaRovers
	 */
	public static void printarListaRover (List<Rover> listaRovers) {
		int tamanhoLista = listaRovers.size();
		for (int i = 0; i < tamanhoLista; i++) {
			Rover rover = listaRovers.get(i);
			
			//Printa na saida do console
			System.out.print(rover.getCoordenadaX());
			System.out.print(" ");
			System.out.print(rover.getCoordenadaY());
			System.out.print(" ");
			System.out.print(rover.getOrientacao());
			System.out.println(" ");
		}
	}

}
