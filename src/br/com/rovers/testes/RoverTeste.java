package br.com.rovers.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.rovers.entidades.Rover;

public class RoverTeste {


	public static void main(String[] args) {
		List<Rover> listaRovers = new ArrayList<>();
		
		System.out.println("Cadastrando a cordenada maxima de X e Y: 5 5");
		
		listaRovers.add(criarMovimentacaoRover("5 5", "1 2 N", "LMLMLMLMM"));
		listaRovers.add(criarMovimentacaoRover("5 5", "3 3 E", "MMRMMRMRRM"));
		
		printarListaRover(listaRovers);
	}
	
	/***
	 * Cria um novo rover, printando na tela o passo a passo
	 * @param maximoXY
	 * @param posicaoRover
	 * @param mvimentacaoRover
	 * @return
	 */
	private static Rover criarMovimentacaoRover(String maximoXY, String posicaoRover, String mvimentacaoRover) {
		Rover rover = new Rover();
	
		rover.montarMaximoCoordenadas(maximoXY);
		
		System.out.println("Cadastrando posição Rover: ".concat(posicaoRover));
		
		rover.montarCoordenadas(posicaoRover);
		
		System.out.println("Cadastrando movimentacao Rover: ".concat(mvimentacaoRover));
		rover.montarMovimentacao(mvimentacaoRover);
		
		return rover;
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
