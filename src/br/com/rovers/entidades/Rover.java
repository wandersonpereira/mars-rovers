package br.com.rovers.entidades;

import java.util.ArrayList;

import br.com.rovers.utils.GeograficaUtil;

public class Rover {
	
	private int coordenadaX;
	private int coordenadaY;
	private int maximoCoordenadaX;
	private int maximoCoordenadaY;
	private String orientacao;
	private String[] movimentacao;
	
	
	public Rover () {
	}
	
	/***
	 * Monta a cordenada de acordo com o informado pelo usuário
	 * 1 2 N Da um split por espaço e informa quais são as cordenadas e orientação
	 * @param stringCoordenada
	 */
	public void montarCoordenadas (String stringCoordenada) {
		String[] arr = stringCoordenada.split(" ");
		
		this.coordenadaX = Integer.parseInt(arr[0]);
		this.coordenadaY = Integer.parseInt(arr[1]);
		this.orientacao = arr[2];
	}
	
	/***
	 * Monta a movimentação de acordo com informado pelo usuário
	 * LMLMLMLMM Da um split por character, e monta um array da movimentação do Rover
	 * @param stringMovimentacao
	 */
	public void montarMovimentacao (String stringMovimentacao) {
		this.movimentacao = stringMovimentacao.split("");
	}
	
	/***
	 * Monta o tamanho maximo da coordenada em X e Y de acordo com que foi informado pelo usuário
	 * 5 5 Da um split por espaço e monta o maximoX e maximoY
	 * @param stringMaximoCoordenada
	 */
	public void montarMaximoCoordenadas(String stringMaximoCoordenada) {
		String [] maximoCoordenadas = stringMaximoCoordenada.split(" ");
		
		this.maximoCoordenadaX = Integer.parseInt(maximoCoordenadas[0]);
		this.maximoCoordenadaY = Integer.parseInt(maximoCoordenadas[1]);
	}
	
	/***
	 * Faz a movimentação do Rover, levando em consideração os dados informados para este objeto,
	 * Movimentação;
	 * CoordenadaX
	 * CoordenadaY
	 * Orientação
	 */
	public void movimentarRover() {
		String posicao = "";
		for(int i = 0; i < this.movimentacao.length; i++) {
			String movimentacao = this.movimentacao[i];
			if (!movimentacao.toUpperCase().equals("M")) {
				posicao = GeograficaUtil.retornarProximaOrientacao(this.orientacao, movimentacao);
				this.orientacao = posicao;
			} else {
				this.moverPosicao(this.orientacao);
			}
		}
	}
	
	/***
	 * Valida qual é a orietanão da movimentação, e move o rover para sua respetiva posição.
	 * @param orientacao
	 */
	private void moverPosicao(String orientacao) {
		orientacao = orientacao.toUpperCase();
		
		if (orientacao.equals("S")) {
			this.coordenadaY--;
		} else if (orientacao.equals("N")) {
			this.coordenadaY++;
		} else if (orientacao.equals("E")) {
			this.coordenadaX++;
		} else if (orientacao.equals("W")) {
			this.coordenadaX--;
		}
		
		this.validarCoordenadas();
	}
	
	/**
	 * Valida as coordenadas de acordo com o tamanho minimo que seria de 0 x e 0 y
	 * E o tamanho maximo no qual foi especificado pelo usuário.
	 */
	private void validarCoordenadas() {
		if (this.coordenadaX < 0) {
			this.coordenadaX = 0;
		}
		
		if (this.coordenadaY < 0) {
			this.coordenadaY = 0;
		}
		
		if (this.coordenadaX > this.maximoCoordenadaX) {
			this.coordenadaX = this.maximoCoordenadaX;
		}
		
		if (this.coordenadaY > this.maximoCoordenadaY) {
			this.coordenadaY = this.maximoCoordenadaY;
		}
		
	}

	/**
	 * Retorna a coordenada X
	 * @return int
	 */
	public int getCoordenadaX() {
		return this.coordenadaX;
	}

	/**
	 * Retorna a coordenada Y
	 * @return int
	 */
	public int getCoordenadaY() {
		return this.coordenadaY;
	}

	/**
	 * Retorna a orientação
	 * @return string
	 */
	public String getOrientacao() {
		return this.orientacao;
	}
	
}
