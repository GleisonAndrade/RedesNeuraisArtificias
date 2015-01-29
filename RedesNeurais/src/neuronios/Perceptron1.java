package neuronios;

import java.util.ArrayList;
import java.util.Random;

import funcoes.FuncaoAtivacao;

public class Perceptron1 {
	// private FeedForward feedforward;
	private double w[];
	private double pesosTreinado[];
	private double saidaDesejada[];
	private double amostrasDeTreinamento[][];
	private double taxaAprendizagem;
	private Integer epocas;
	private Integer amostra;
	private Integer numeroDeEntradas;
	private Integer numeroDeAmostras;
	private boolean erro;
	private FuncaoAtivacao funcaoDeAtivacao;

	public Perceptron1(Integer numeroDeEntradas, double saidaDesejada[],
			double taxaAprendizagem, double amostrasDeTreinamento[][],
			Integer numeroDeAmostras, FuncaoAtivacao funcaoDeAtivacao) {// ,
		// double
		// w[]){
		this.saidaDesejada = saidaDesejada;
		this.taxaAprendizagem = taxaAprendizagem;
		this.amostrasDeTreinamento = amostrasDeTreinamento;
		// this.w = w;
		this.numeroDeEntradas = numeroDeEntradas;
		this.numeroDeAmostras = numeroDeAmostras;
		this.epocas = 0;
		this.amostra = 0;
		this.erro = false;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
	}

	public void inicializaPesos(double valor) {
		w = new double[numeroDeEntradas + 1];
		for (int i = 0; i <= numeroDeEntradas; i++) {
			w[i] = valor;
		}
	}

	public void inicializaPesosAleatorio() {
		w = new double[numeroDeEntradas + 1];
		Random rand = new Random();
		for (int i = 0; i <= numeroDeEntradas; i++) {
			w[i] = rand.nextDouble();
		}
		for (int i = 0; i <= numeroDeEntradas; i++) {
			System.out.print(w[i] + " ");
		}
		System.out.println();
	}

	public void atualizaPesos(double y, Integer amostra) {
		double d = saidaDesejada[amostra] - y;
		w[0] = w[0] + ((taxaAprendizagem * d) * -1);
		for (int i = 1; i <= numeroDeEntradas; i++) {
			w[i] = w[i]
					+ ((taxaAprendizagem * d) * amostrasDeTreinamento[amostra][i - 1]);
		}
	}

	// public ArrayList<double> matrizToArray(double matriz[][], int tam, int
	// indice){
	// ArrayList<double> news = new ArrayList<double>();
	// news.add(-1.0);
	// for(int i = 0; i < tam; i++){
	// news.add(matriz[indice][i]);
	// }
	// return news;
	// }

	public void normalizarValor(double min, double max) {
		for (int amostra = 0; amostra < numeroDeAmostras; amostra++) {
			for (int i = 0; i < numeroDeEntradas; i++) {
				amostrasDeTreinamento[amostra][i] = (amostrasDeTreinamento[amostra][i] - min)
						/ (max - min);
			}
		}
	}

	public double somatorio(int amostra) {
		double somatorio = -1.0 * w[0];

		for (int i = 0; i < numeroDeEntradas; i++) {
			somatorio += w[i + 1] * amostrasDeTreinamento[amostra][i];
		}
		// System.out.println(somatorio);
		return somatorio;
	}

	public void treinamento(double valor) {
		double y = 0.0;
		// inicializaPesos(valor);
		inicializaPesosAleatorio();
		//normalizarValor(-2.0, 13.0);
		epocas = 0;
		erro = true;
		while (erro) {
			erro = false;
			for (int amostra = 0; amostra < numeroDeAmostras; amostra++) {
				// calcula u
				funcaoDeAtivacao.setU(somatorio(amostra));
				// System.out.println("valor de u ="+funcaoDeAtivacao.getU());
				// recebe saida
				y = funcaoDeAtivacao.ativar();
				// System.out.println("u = "+funcaoDeAtivacao.getU()+" y = "+y+" saida desejada "+saidaDesejada[amostra]);
				if (y != saidaDesejada[amostra]) { // saida desejada na amostra
													// i
					// System.out.println("valor de y ="+y+" Desejada "+saidaDesejada[amostra]);
					atualizaPesos(y, amostra);
					erro = true;
					// System.out.println("Erro!");
					// System.out.println("Entrou!");
				}
				// System.out.println("Pesos encontrados "+w[0]+" "+w[1]+" "+w[2]);
				// System.out.println();
				// if(erro) System.out.println("Erro!"); else
				// System.out.println("Nao Erro!");
			}

			epocas++;
			// System.out.println("Epoca "+epocas);
			// System.out.println("------------------------------------------------");
			 if (epocas == 10000) break;
			// if (erro == false) break;
		}
		pesosTreinado = w;
	}

	public double[] getPesosTreinado() {
		return this.pesosTreinado;
	}

	public void setPesosTreinado(double[] peso) {
		this.pesosTreinado = peso;
	}

	public void getRelatorio() {
		System.out.println("Numero de epocas: " + epocas);
		System.out.println("Pesos encontrados: ");
		for (int i = 0; i < pesosTreinado.length; i++) {
			System.out.print(pesosTreinado[i] + " ");
		}
		System.out.println();
	}

	public void Operacao() {
		double y;
		w = getPesosTreinado();
		for (int i = 0; i < numeroDeAmostras; i++) {
			funcaoDeAtivacao.setU(somatorio(i));
			y = funcaoDeAtivacao.ativar();
			if (y == -1.0)
				System.out.println("Amostra " + i + " pertence a classe P1");
			else
				System.out.println("Amostra " + i + " pertence a classe P2");
		}
	}

}
