package testes;

import java.util.ArrayList;

import neuronios.FeedForward;

import arquivos.GerarArquivo;

import funcoes.FuncaoAtivacao;
import funcoes.Hiperbolica;
import funcoes.Logistica;

public class TestesFeedforward {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		feedforwardSimples();
	}

	public static void feedforwardSimples() {
		Double[][] limiares = new Double[3][10];
		Double[][] pesosSinapticos = new Double[4][10];
		ArrayList<Double> camadaDeEntrada = new ArrayList<Double>();
		ArrayList<Integer> mapa = new ArrayList<Integer>();
		FuncaoAtivacao[][] funcaoDeAtivacao = new FuncaoAtivacao[3][10];

		// Gerar CSV
		ArrayList<Double> x1 = new ArrayList<Double>();
		ArrayList<Double> x2 = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		GerarArquivo g = new GerarArquivo();
		Logistica log = new Logistica(0.0, 1.0);
		
		funcaoDeAtivacao[0][0] = log; 
		funcaoDeAtivacao[0][1] = log; 
		funcaoDeAtivacao[0][2] = log; 
		funcaoDeAtivacao[0][3] = log; 
		funcaoDeAtivacao[0][4] = log; 
		funcaoDeAtivacao[0][5] = log; 
		funcaoDeAtivacao[0][6] = log; 
		funcaoDeAtivacao[0][7] = log; 
		funcaoDeAtivacao[0][8] = log; 
		funcaoDeAtivacao[0][9] = log; 
		
		funcaoDeAtivacao[1][0] = log; 
		funcaoDeAtivacao[1][1] = log; 
		funcaoDeAtivacao[1][2] = log; 
		funcaoDeAtivacao[1][3] = log;
		funcaoDeAtivacao[1][4] = log; 
		

		funcaoDeAtivacao[2][0] = log;
		
//		Hiperbolica hip = new Hiperbolica(0.0, 1.0);
//		funcaoDeAtivacao[0][0] = hip;
		limiares[0][0] = 0.0;
		limiares[0][1] = 0.0;
		limiares[0][2] = 0.0;
		limiares[0][3] = 0.0;
		limiares[0][4] = 0.0;
		limiares[0][5] = 0.0;
		limiares[0][6] = 0.0;
		limiares[0][7] = 0.0;
		limiares[0][8] = 0.0;
		limiares[0][9] = 0.0;
		
		limiares[1][0] = 0.0;
		limiares[1][1] = 0.0;
		limiares[1][2] = 0.0;
		limiares[1][3] = 0.0;
		limiares[1][4] = 0.0;
		
		limiares[2][0] = 0.0;
		
		// pesos entrada, escondida e saida;
		pesosSinapticos[0][0] = 1.0;
		pesosSinapticos[0][1] = 1.0;
		
		pesosSinapticos[1][0] = 1.0;
		pesosSinapticos[1][1] = 1.0;
		pesosSinapticos[1][2] = 1.0;
		pesosSinapticos[1][3] = 1.0;
		pesosSinapticos[1][4] = 1.0;
		pesosSinapticos[1][5] = 1.0;
		pesosSinapticos[1][6] = 1.0;
		pesosSinapticos[1][7] = 1.0;
		pesosSinapticos[1][8] = 1.0;
		pesosSinapticos[1][9] = 1.0;
		
		pesosSinapticos[2][0] = 1.0;
		pesosSinapticos[2][1] = 1.0;
		pesosSinapticos[2][2] = 1.0;
		pesosSinapticos[2][3] = 1.0;
		pesosSinapticos[2][4] = 1.0;
		pesosSinapticos[2][5] = 1.0;
		pesosSinapticos[2][6] = 1.0;
		pesosSinapticos[2][7] = 1.0;
		pesosSinapticos[2][8] = 1.0;
		pesosSinapticos[2][9] = 1.0;

		
		pesosSinapticos[3][0] = 1.0;
		pesosSinapticos[3][1] = 1.0;
		pesosSinapticos[3][2] = 1.0;
		pesosSinapticos[3][3] = 1.0;
		pesosSinapticos[3][4] = 1.0;

		mapa.add(2);
		mapa.add(10);
		mapa.add(5);
		mapa.add(1);

		for (double i = 0.0; i < 1.0; i += 0.05) {
			x1.add(i);
			// if (i<=0.05)
			x2.add(i);
			for (double j = 0.0; j < 1.0; j += 0.05) {

				camadaDeEntrada = new ArrayList<Double>();
				camadaDeEntrada.add((double) i);
				camadaDeEntrada.add((double) j);

				FeedForward feedforward = new FeedForward(mapa,
						camadaDeEntrada, pesosSinapticos, limiares,
						funcaoDeAtivacao);

				y.add(feedforward.obterSaida().get(0));
				// System.out.println("y = "+y);

			}

		}

		g.gerarCsv2("lista02/questao6Teste1.csv", x1, x2, y);

	}

	public static void feedforwardMultiplas() {
		return;
	}

}
