package br.com.rovers.utils;

public class GeograficaUtil {
	private static String[] orientacaoGeografica = {"N", "E", "S", "W"};
	
	/***
	 * Retorna a proxima orietanão do rover, levando em consideração a sua movmentação
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
	 * Retorna pra onde vai mover a proxima posição da movimentação
	 * Caso seja para direita será incrementado mais 1 na posição atual
	 * Caso seja para esquerda será menos 1 na posição atual
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
	 * Retorna a posição do elemento procurado, caso não exista retorna -1
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
	 * Valida se existe uma posição anterior
	 * @param posicao
	 * @return boolean
	 */
	public static boolean hasLast (int posicao) {
		return posicao == -1;
	}
	
	/**
	 * Valida se existe uma próxima posição
	 * @param posicao
	 * @return boolean
	 */
	public static boolean hasNext (int posicao) {
		return posicao > orientacaoGeografica.length -1;
	}
}
