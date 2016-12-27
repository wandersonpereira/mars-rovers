package br.com.rovers.utils;

public class GeograficaUtil {
	private static String[] orientacaoGeografica = {"N", "E", "S", "W"};
	
	/***
	 * Retorna a proxima orietan�o do rover, levando em considera��o a sua movmenta��o
	 * Direita ou esquerda
	 * @param orientacao
	 * @param movimentacao
	 * @return
	 */
	public static String retornarProximaOrientacao(String orientacao, String movimentacao) {
		int posicao = getPosicaoOrientacao(orientacao);
		int orientacaoMovimentacao = getOrientacao(movimentacao);
		
		int proximaMovimentacao = (posicao + orientacaoMovimentacao);
		
		if (hasNext(proximaMovimentacao)) {
			proximaMovimentacao = 0;
		} else if (hasLast(proximaMovimentacao)) {
			proximaMovimentacao = orientacaoGeografica.length -1;
		}
		
		return orientacaoGeografica[proximaMovimentacao];
	}
	
	/**
	 * Retorna pra onde vai mover a proxima posi��o da movimenta��o
	 * Caso seja para direita ser� incrementado mais 1 na posi��o atual
	 * Caso seja para esquerda ser� menos 1 na posi��o atual
	 * @param movimentacao
	 * @return
	 */
	public static int getOrientacao(String movimentacao) {
		if (movimentacao.toUpperCase().equals("R")) {
			return 1;
		}
		
		return -1;
	}


	/***
	 * Retorna a posi��o do elemento procurado, caso n�o exista retorna -1
	 * @param valor
	 * @return int
	 */
	public static int getPosicaoOrientacao (String valor) {
		for (int i = 0; i < orientacaoGeografica.length; i++) {
			if (orientacaoGeografica[i].equals(valor.toUpperCase())) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * Valida se existe uma posi��o anterior
	 * @param posicao
	 * @return boolean
	 */
	public static boolean hasLast (int posicao) {
		return posicao == -1;
	}
	
	/**
	 * Valida se existe uma pr�xima posi��o
	 * @param posicao
	 * @return boolean
	 */
	public static boolean hasNext (int posicao) {
		return posicao > orientacaoGeografica.length -1;
	}
}
