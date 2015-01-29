package neuronios;

import java.util.ArrayList;
import java.util.List;

import funcoes.FuncaoAtivacao;

public class FeedForward {
	/*
	 * mapa diz configuração da minha rede, numero de elementos menos um e o
	 * numero de camadas, o valor no primeiro elemento é o numero de entradas o
	 * valor nos elementos entre o primeiro e o ultimo é o numero de neuronios
	 * na camada o valor no ultimo elemento é o numero de neuronios na camada de
	 * saida
	 */
	private ArrayList<Integer> mapa = new ArrayList<Integer>();
	private ArrayList<Double> camadaDeEntrada;// = new ArrayList<Double>();
	private Double[][] pesosSinapticos;// = new ArrayList<Double>();
	private Double[][] limiares;// = new ArrayList<Double>();
	private ArrayList<Double> saida;
	private NeuronioArtificial neuronioTemp;
	private FuncaoAtivacao[][] funcaoDeAtivacao;

	public FeedForward(ArrayList<Integer> mapa,
			ArrayList<Double> camadaDeEntrada, Double[][] pesosSinapticos,
			Double[][] limiares, FuncaoAtivacao[][] funcaoDeAtivacao) {
		this.mapa = mapa;
		this.camadaDeEntrada = camadaDeEntrada;
		this.pesosSinapticos = pesosSinapticos;
		this.limiares = limiares;
		this.saida = new ArrayList<Double>();
		this.funcaoDeAtivacao = funcaoDeAtivacao;
	}

	public ArrayList<Double> obterSaida() {
		ArrayList<Double> y = camadaDeEntrada;
		ArrayList<Double> aux = new ArrayList<Double>();
		ArrayList<Double> w;
		for (int camada = 1; camada < mapa.size(); camada++) {
			aux.clear();
			aux.addAll(y);

			y.clear();
			for (int neuronio = 0; neuronio < mapa.get(camada); neuronio++) {
				w = matrizToArray(pesosSinapticos, camada - 1,
						mapa.get(camada - 1));

				Double limiar = (matrizToArray(limiares, camada - 1,
						mapa.get(camada))).get(neuronio);
				FuncaoAtivacao func = funcaoDeAtivacao[camada - 1][neuronio];

				neuronioTemp = new NeuronioArtificial(aux, w, limiar, func);
				y.add(neuronioTemp.getY());
			}
		}

		saida.addAll(aux);
		aux.clear();
		
		return saida;
	}

	public ArrayList<Double> matrizToArray(Double[][] matriz, int linha, int tam) {
		ArrayList<Double> temp = new ArrayList<Double>();
		for (int i = 0; i < tam; i++) {
			temp.add(matriz[linha][i]);
		}
		return temp;
	}

}
