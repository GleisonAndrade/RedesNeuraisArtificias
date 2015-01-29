package arquivos;

import java.util.ArrayList;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String temp = "" + 1.0000;
//
//	
//
//		System.out.println(	replace(temp, '.',','));
		
		GerarArquivo arq = new GerarArquivo();
		ArrayList<Double> epoca = new ArrayList<Double>();
		ArrayList<Double> erro = new ArrayList<Double>();
		
		for (int i = 0; i < 10; i++) {
			epoca.add((double) i);
			erro.add((double) i*2);
		}
		
		arq.gerarCsvErro("A.csv", epoca, erro);

	}

	public static String replace(String entrada, char antes, char depois) {
		String saida = "";
		for (int i = 0; i < entrada.length(); i++) {
			if (entrada.charAt(i) == antes)
				saida = saida + depois;
			else
				saida = saida + entrada.charAt(i);
		}
		return saida;
	}

}
