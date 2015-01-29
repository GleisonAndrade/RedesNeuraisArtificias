/**
 * 
 */
package neuronios;

import java.util.ArrayList;
import java.util.Random;

import arquivos.GerarArquivo;
import arquivos.ManipulaExcel;

import funcoes.FuncaoAtivacao;

/**
 * @author Gleison
 * 
 */
public class Adaline {
	private double w[];
	// private double[] u;
	private double pesosTreinado[];
	private double saidaDesejada[];
	private double amostrasDeTreinamento[][];
	private double taxaAprendizagem;
	private double precisaoRequerida;
	private Integer epocas;
	private Integer amostra;
	private Integer numeroDeEntradas;
	private Integer numeroDeAmostras;
	private FuncaoAtivacao funcaoDeAtivacao;
	private ArrayList<Double> erros = new ArrayList<Double>();

	public Adaline(Integer numeroDeEntradas, double saidaDesejada[],
			double taxaAprendizagem, double precisaoRequerida,
			double amostrasDeTreinamento[][], Integer numeroDeAmostras,
			FuncaoAtivacao funcaoDeAtivacao) {
		this.saidaDesejada = saidaDesejada;
		this.taxaAprendizagem = taxaAprendizagem;
		this.precisaoRequerida = precisaoRequerida;
		this.amostrasDeTreinamento = amostrasDeTreinamento;
		this.numeroDeEntradas = numeroDeEntradas;
		this.numeroDeAmostras = numeroDeAmostras;
		this.epocas = 0;
		this.amostra = 0;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
	}

	public void inicializa(double valor, double vet[]) {
		// w = new double[numeroDeEntradas + 1];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = valor;
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

	public void inicializaPesos(double valor) {
		w = new double[numeroDeEntradas + 1];
		for (int i = 0; i <= numeroDeEntradas; i++) {
			w[i] = valor;
		}
	}

	public void atualizaPesos(double uu, Integer amostra) {
		double d = saidaDesejada[amostra] - uu;
		w[0] = w[0] + ((taxaAprendizagem * d) * -1);
		for (int i = 1; i <= numeroDeEntradas; i++) {
			w[i] = w[i]
					+ ((taxaAprendizagem * d) * amostrasDeTreinamento[amostra][i - 1]);
		}
		// for (int i = 0; i <= numeroDeEntradas; i++) {
		// System.out.print(w[i] + " ");
		// }
		// System.out.println();
	}

	public double somatorioErros() {
		double erroSum = 0.0;
		for (int i = 0; i < erros.size(); i++) {
			erroSum += erros.get(i);
		}
		erroSum = erroSum / numeroDeAmostras;
		return erroSum;
	}

	public void atualizaPesosOffline(double uu, Integer amostra, double d) {
		// double d = ErroQuadratico();
		w[0] = w[0] + ((taxaAprendizagem * d) * -1);
		for (int i = 1; i <= numeroDeEntradas; i++) {
			w[i] = w[i]
					+ ((taxaAprendizagem * d) * amostrasDeTreinamento[amostra][i - 1]);
		}
		// for (int i = 0; i <= numeroDeEntradas; i++) {
		// System.out.print(w[i] + " ");
		// }
		// System.out.println();
	}

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
		// System.out.println("tam w "+w.length+" amostra "+amostra+" entradas "+numeroDeEntradas);
		for (int i = 0; i < numeroDeEntradas; i++) {
			somatorio += (w[i + 1] * amostrasDeTreinamento[amostra][i]);
		}
		// System.out.println("Somatorio: "+somatorio);
		return somatorio;
	}

	public double ErroQuadratico() {
		double Eqm = 0.0, u = 0;
		for (int amostra = 0; amostra < numeroDeAmostras; amostra++) {
			// saida += (Math.pow(2, (saidaDesejada[amostra] - u[amostra])));
			u = somatorio(amostra);
			// System.out.println("Quadrado "+(saidaDesejada[amostra] -
			// u)+": "+Math.pow((saidaDesejada[amostra] - u), 2));
			Eqm = Eqm + (Math.pow((saidaDesejada[amostra] - u), 2));
		}
		Eqm = Eqm / numeroDeAmostras;
		return Eqm;
	}

	public void treinamento(int numMaximoEpocas) {
		// normalizarValor(-4.0, 6.0);
		double u = 0.0;
		double EqAtual = 0.0, EqAnterior = 0.0;// , Eqaux=0.0;
		// GerarArquivo arq = new GerarArquivo();
		// ArrayList<Double> epoca = new ArrayList<Double>();
		// ArrayList<Double> erro = new ArrayList<Double>();
		// u = new double[numeroDeAmostras];
		// inicializa(0.0, u);
		// inicializaPesos(0.0);
		inicializaPesosAleatorio();
		// normalizarValor(-2.0, 13.0);
		epocas = 0;
		do {
			EqAnterior = ErroQuadratico();
			// System.out.println("EqmAnterior : "+EqAnterior);
			for (int amostra = 0; amostra < numeroDeAmostras; amostra++) {
				u = somatorio(amostra);
				atualizaPesos(u, amostra);
			}
			epocas++;

			EqAtual = ErroQuadratico();
			// epoca.add((double)epocas);
			// erro.add(EqAtual);
			// System.out.println("EqmAtual : "+EqAtual);
			if (epocas == numMaximoEpocas)
				break;
		} while (Math.abs(EqAtual - EqAnterior) > precisaoRequerida);
		// arq.gerarCsvErro("Treinamento3-1.csv", epoca, erro);
		pesosTreinado = w;
	}

	public void treinamentoOffline(int numMaximoEpocas) {
		double u = 0.0;
		double EqAtual = 0.0, EqAnterior = 0.0;// , Eqaux=0.0;
		GerarArquivo arq = new GerarArquivo();
		ArrayList<Double> epoca = new ArrayList<Double>();
		ArrayList<Double> erro = new ArrayList<Double>();
		// double erros[] = new double[numeroDeAmostras];
		// u = new double[numeroDeAmostras];
		// inicializa(0.0, u);
		// inicializaPesos(0.0);
		inicializaPesosAleatorio();
		double err = 0.0;
		// normalizarValor(-2.0, 13.0);
		epocas = 0;
		do {
			EqAnterior = ErroQuadratico();
			for (int amostra = 0; amostra < numeroDeAmostras; amostra++) {
				err += (saidaDesejada[amostra] - somatorio(amostra)) * -1;
				for (int i = 1; i <= numeroDeEntradas; i++)
					err += (saidaDesejada[amostra] - somatorio(amostra))
							* amostrasDeTreinamento[amostra][i - 1];
			}
			for (int entrada = 0; entrada < numeroDeEntradas; entrada++) {
				w[entrada] = w[entrada] + (taxaAprendizagem * (err));
			}
			err = 0.0;
			epocas++;

			EqAtual = ErroQuadratico();

		} while (Math.abs(EqAtual - EqAnterior) > precisaoRequerida);
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
		// normalizarValor(-4.0, 6.0);
		double y;
		w = getPesosTreinado();
		for (int i = 0; i < numeroDeAmostras; i++) {
			funcaoDeAtivacao.setU(somatorio(i));
			y = funcaoDeAtivacao.ativar();
			if (y == -1.0 || y == 0)
				System.out.println("Amostra " + i + " pertence a classe A");
			else
				System.out.println("Amostra " + i + " pertence a classe B");
		}
	}

}
