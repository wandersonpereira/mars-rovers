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
	 * Monta a cordenada de acordo com o informado pelo usu�rio
	 * 1 2 N Da um split por espa�o e informa quais s�o as cordenadas e orienta��o
	 * @param stringCoordenada
	 */
	public void montarCoordenadas (String stringCoordenada) {
		String[] arr = stringCoordenada.split(" ");
		
		this.coordenadaX = Integer.parseInt(arr[0]);
		this.coordenadaY = Integer.parseInt(arr[1]);
		this.orientacao = arr[2];
	}
	
	/***
	 * Monta a movimenta��o de acordo com informado pelo usu�rio
	 * LMLMLMLMM Da um split por character, e monta um array da movimenta��o do Rover
	 * @param stringMovimentacao
	 */
	public void montarMovimentacao (String stringMovimentacao) {
		this.movimentacao = stringMovimentacao.split("");
	}
	
	/***
	 * Monta o tamanho maximo da coordenada em X e Y de acordo com que foi informado pelo usu�rio
	 * 5 5 Da um split por espa�o e monta o maximoX e maximoY
	 * @param stringMaximoCoordenada
	 */
	public void montarMaximoCoordenadas(String stringMaximoCoordenada) {
		String [] maximoCoordenadas = stringMaximoCoordenada.split(" ");
		
		this.maximoCoordenadaX = Integer.parseInt(maximoCoordenadas[0]);
		this.maximoCoordenadaY = Integer.parseInt(maximoCoordenadas[1]);
	}
	
	/***
	 * Faz a movimenta��o do Rover, levando em considera��o os dados informados para este objeto,
	 * Movimenta��o;
	 * CoordenadaX
	 * CoordenadaY
	 * Orienta��o
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
	 * Valida qual � a orietan�o da movimenta��o, e move o rover para sua respetiva posi��o.
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
	 * E o tamanho maximo no qual foi especificado pelo usu�rio.
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
	 * Retorna a orienta��o
	 * @return string
	 */
	public String getOrientacao() {
		return this.orientacao;
	}
	
}
