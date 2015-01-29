package testes;

import java.util.ArrayList;
import java.util.Random;

import funcoes.DeGrau;
import funcoes.Sinal;
import neuronios.Perceptron1;

public class TestesPerceptron {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Questao7();
		// classificacaoPetroleo();
		// inicializaPesosAleatorio();
		//testeTreinamento();
		classificacaoPetroleoNormalizado();
	}

	public static double normalizarValor(double x, double min, double max) {
		double v = 0.0;
		v = (x - min) / (max - min);
		return v;
	}
	
	public static void classificacaoPetroleo() {
		int numeroDeEntradas = 3;
		int numeroDeAMostras = 30;
		double saidaDesejada[] = new double[numeroDeAMostras];
		double taxaAprendizagem = 0.01;
		double amostrasDeTreinamento[][] = new double[numeroDeAMostras][numeroDeEntradas];
		int numeroDeAmostras = 4;
		Sinal funcaoDeAtivacao = new Sinal(0.0);

		amostrasDeTreinamento[0][0] = -0.6508;
		amostrasDeTreinamento[0][1] = 0.1097;
		amostrasDeTreinamento[0][2] = 4.0009;
		saidaDesejada[0] = -1.0000;
		amostrasDeTreinamento[1][0] = -1.4492;
		amostrasDeTreinamento[1][1] = 0.8896;
		amostrasDeTreinamento[1][2] = 4.4005;
		saidaDesejada[1] = -1.0000;
		amostrasDeTreinamento[2][0] = 2.0850;
		amostrasDeTreinamento[2][1] = 0.6876;
		amostrasDeTreinamento[2][2] = 12.0710;
		saidaDesejada[2] = -1.0000;
		amostrasDeTreinamento[3][0] = 0.2626;
		amostrasDeTreinamento[3][1] = 1.1476;
		amostrasDeTreinamento[3][2] = 7.7985;
		saidaDesejada[3] = 1.0000;
		amostrasDeTreinamento[4][0] = 0.6418;
		amostrasDeTreinamento[4][1] = 1.0234;
		amostrasDeTreinamento[4][2] = 7.0427;
		saidaDesejada[4] = 1.0000;
		amostrasDeTreinamento[5][0] = 0.2569;
		amostrasDeTreinamento[5][1] = 0.6730;
		amostrasDeTreinamento[5][2] = 8.3265;
		saidaDesejada[5] = -1.0000;
		amostrasDeTreinamento[6][0] = 1.1155;
		amostrasDeTreinamento[6][1] = 0.6043;
		amostrasDeTreinamento[6][2] = 7.4446;
		saidaDesejada[6] = 1.0000;
		amostrasDeTreinamento[7][0] = 0.0914;
		amostrasDeTreinamento[7][1] = 0.3399;
		amostrasDeTreinamento[7][2] = 7.0677;
		saidaDesejada[7] = -1.0000;
		amostrasDeTreinamento[8][0] = 0.0121;
		amostrasDeTreinamento[8][1] = 0.5256;
		amostrasDeTreinamento[8][2] = 4.6316;
		saidaDesejada[8] = 1.0000;
		amostrasDeTreinamento[9][0] = -0.0429;
		amostrasDeTreinamento[9][1] = 0.4660;
		amostrasDeTreinamento[9][2] = 5.4323;
		saidaDesejada[9] = 1.0000;
		amostrasDeTreinamento[10][0] = 0.4340;
		amostrasDeTreinamento[10][1] = 0.6870;
		amostrasDeTreinamento[10][2] = 8.2287;
		saidaDesejada[10] = -1.0000;
		amostrasDeTreinamento[11][0] = 0.2735;
		amostrasDeTreinamento[11][1] = 1.0287;
		amostrasDeTreinamento[11][2] = 7.1934;
		saidaDesejada[11] = 1.0000;
		amostrasDeTreinamento[12][0] = 0.4839;
		amostrasDeTreinamento[12][1] = 0.4851;
		amostrasDeTreinamento[12][2] = 7.4850;
		saidaDesejada[12] = -1.0000;
		amostrasDeTreinamento[13][0] = 0.4089;
		amostrasDeTreinamento[13][1] = -0.1267;
		amostrasDeTreinamento[13][2] = 5.5019;
		saidaDesejada[13] = -1.0000;
		amostrasDeTreinamento[14][0] = 1.4391;
		amostrasDeTreinamento[14][1] = 0.1614;
		amostrasDeTreinamento[14][2] = 8.5843;
		saidaDesejada[14] = -1.0000;
		amostrasDeTreinamento[15][0] = -0.9115;
		amostrasDeTreinamento[15][1] = -0.1973;
		amostrasDeTreinamento[15][2] = 2.1962;
		saidaDesejada[15] = -1.0000;
		amostrasDeTreinamento[16][0] = 0.3654;
		amostrasDeTreinamento[16][1] = 1.0475;
		amostrasDeTreinamento[16][2] = 7.4858;
		saidaDesejada[16] = 1.0000;
		amostrasDeTreinamento[17][0] = 0.2144;
		amostrasDeTreinamento[17][1] = 0.7515;
		amostrasDeTreinamento[17][2] = 7.1699;
		saidaDesejada[17] = 1.0000;
		amostrasDeTreinamento[18][0] = 0.2013;
		amostrasDeTreinamento[18][1] = 1.0014;
		amostrasDeTreinamento[18][2] = 6.5489;
		saidaDesejada[18] = 1.0000;
		amostrasDeTreinamento[19][0] = 0.6483;
		amostrasDeTreinamento[19][1] = 0.2183;
		amostrasDeTreinamento[19][2] = 5.8991;
		saidaDesejada[19] = 1.0000;
		amostrasDeTreinamento[20][0] = -0.1147;
		amostrasDeTreinamento[20][1] = 0.2242;
		amostrasDeTreinamento[20][2] = 7.2435;
		saidaDesejada[20] = -1.0000;
		amostrasDeTreinamento[21][0] = -0.7970;
		amostrasDeTreinamento[21][1] = 0.8795;
		amostrasDeTreinamento[21][2] = 3.8762;
		saidaDesejada[21] = 1.0000;
		amostrasDeTreinamento[22][0] = -1.0625;
		amostrasDeTreinamento[22][1] = 0.6366;
		amostrasDeTreinamento[22][2] = 2.4707;
		saidaDesejada[22] = 1.0000;
		amostrasDeTreinamento[23][0] = 0.5307;
		amostrasDeTreinamento[23][1] = 0.1285;
		amostrasDeTreinamento[23][2] = 5.6883;
		saidaDesejada[23] = 1.0000;
		amostrasDeTreinamento[24][0] = -1.2200;
		amostrasDeTreinamento[24][1] = 0.7777;
		amostrasDeTreinamento[24][2] = 1.7252;
		saidaDesejada[24] = 1.0000;
		amostrasDeTreinamento[25][0] = 0.3957;
		amostrasDeTreinamento[25][1] = 0.1076;
		amostrasDeTreinamento[25][2] = 5.6623;
		saidaDesejada[25] = -1.0000;
		amostrasDeTreinamento[26][0] = -0.1013;
		amostrasDeTreinamento[26][1] = 0.5989;
		amostrasDeTreinamento[26][2] = 7.1812;
		saidaDesejada[26] = -1.0000;
		amostrasDeTreinamento[27][0] = 2.4482;
		amostrasDeTreinamento[27][1] = 0.9455;
		amostrasDeTreinamento[27][2] = 11.2095;
		saidaDesejada[27] = 1.0000;
		amostrasDeTreinamento[28][0] = 2.0149;
		amostrasDeTreinamento[28][1] = 0.6192;
		amostrasDeTreinamento[28][2] = 10.9263;
		saidaDesejada[28] = -1.0000;
		amostrasDeTreinamento[29][0] = 0.2012;
		amostrasDeTreinamento[29][1] = 0.2611;
		amostrasDeTreinamento[29][2] = 5.4631;
		saidaDesejada[29] = 1.0000;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	
	public static void testeTreinamento() {
		int numeroDeEntradas = 3;
		int numeroDeAmostras = 10;
		// int numeroDeAMostras = 10;
		// double saidaDesejada[] = new double [numeroDeAMostras];
		double taxaAprendizagem = 1.0;
		double amostrasDeTreinamento[][] = new double[numeroDeAmostras][numeroDeEntradas];

		Sinal funcaoDeAtivacao = new Sinal(0.0);
		// falta salvar os dados
		amostrasDeTreinamento[0][0] = -0.3665;
		amostrasDeTreinamento[0][1] = 0.0620;
		amostrasDeTreinamento[0][2] = 5.9891;
		amostrasDeTreinamento[1][0] = -0.7842;
		amostrasDeTreinamento[1][1] = 1.1267;
		amostrasDeTreinamento[1][2] = 5.5912;
		amostrasDeTreinamento[2][0] = 0.3012;
		amostrasDeTreinamento[2][1] = 0.5611;
		amostrasDeTreinamento[2][2] = 5.8234;
		amostrasDeTreinamento[3][0] = 0.7757;
		amostrasDeTreinamento[3][1] = 1.0648;
		amostrasDeTreinamento[3][2] = 8.0677;
		amostrasDeTreinamento[4][0] = 0.1570;
		amostrasDeTreinamento[4][1] = 0.8028;
		amostrasDeTreinamento[4][2] = 6.3040;
		amostrasDeTreinamento[5][0] = -0.7014;
		amostrasDeTreinamento[5][1] = 1.0316;
		amostrasDeTreinamento[5][2] = 3.6005;
		amostrasDeTreinamento[6][0] = 0.3748;
		amostrasDeTreinamento[6][1] = 0.1536;
		amostrasDeTreinamento[6][2] = 6.1537;
		amostrasDeTreinamento[7][0] = -0.6920;
		amostrasDeTreinamento[7][1] = 0.9404;
		amostrasDeTreinamento[7][2] = 4.4058;
		amostrasDeTreinamento[8][0] = -1.3970;
		amostrasDeTreinamento[8][1] = 0.7141;
		amostrasDeTreinamento[8][2] = 4.9263;
		amostrasDeTreinamento[9][0] = -1.8842;
		amostrasDeTreinamento[9][1] = -0.2805;
		amostrasDeTreinamento[9][2] = 1.2548;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas, null,
				taxaAprendizagem, amostrasDeTreinamento, numeroDeAmostras,
				funcaoDeAtivacao);
		double peso[] = new double[4];

		// peso[0] = 0.24396974989924738;
		// peso[1] = 0.3316689635674268;
		// peso[2] = 0.7126784851492193;
		// peso[3] = -0.08419289559049922;

		// peso[0] = 0.7884078978665909;
		// peso[1] = 0.13415834556710346;
		// peso[2] = 0.7131431506470068;
		// peso[3] = -0.0019562868059819216;

		// peso[0] = 0.7926090674571803;
		// peso[1] = 0.08932371967688077;
		// peso[2] = 0.7091069681870973;
		// peso[3] = -0.0042135295101728976;

		// peso[0] = 0.7991867770719575;
		// peso[1] = 0.21284106739532152;
		// peso[2] = 0.8410780543833056;
		// peso[3] = -0.02402234702356129;

		peso[0] = 0.26736096532696924;
		peso[1] = 0.27507413311046996;
		peso[2] = 0.6649037072298012;
		peso[3] = -0.07151682369333198;

		perceptron.setPesosTreinado(peso);
		perceptron.Operacao();
	}


	public static void testeTreinamentoNormalizado() {
		int numeroDeEntradas = 3;
		int numeroDeAmostras = 10;
		// int numeroDeAMostras = 10;
		// double saidaDesejada[] = new double [numeroDeAMostras];
		double taxaAprendizagem = 0.1;
		double amostrasDeTreinamento[][] = new double[numeroDeAmostras][numeroDeEntradas];
		double min=-2.0, max=7.0;

		Sinal funcaoDeAtivacao = new Sinal(0.0);
		// falta salvar os dados
		amostrasDeTreinamento[0][0] = normalizarValor(-0.3665, min, max);
		amostrasDeTreinamento[0][1] = normalizarValor(0.0620, min, max);
		amostrasDeTreinamento[0][2] = normalizarValor(5.9891, min, max);
		amostrasDeTreinamento[1][0] = normalizarValor(-0.7842, min, max);
		amostrasDeTreinamento[1][1] = normalizarValor(1.1267, min, max);
		amostrasDeTreinamento[1][2] = normalizarValor(5.5912, min, max);
		amostrasDeTreinamento[2][0] = normalizarValor(0.3012, min, max);
		amostrasDeTreinamento[2][1] = normalizarValor(0.5611, min, max);
		amostrasDeTreinamento[2][2] = normalizarValor(5.8234, min, max);
		amostrasDeTreinamento[3][0] = normalizarValor(0.7757, min, max);
		amostrasDeTreinamento[3][1] = normalizarValor(1.0648, min, max);
		amostrasDeTreinamento[3][2] = normalizarValor(8.0677, min, max);
		amostrasDeTreinamento[4][0] = normalizarValor(0.1570, min, max);
		amostrasDeTreinamento[4][1] = normalizarValor(0.8028, min, max);
		amostrasDeTreinamento[4][2] = normalizarValor(6.3040, min, max);
		amostrasDeTreinamento[5][0] = normalizarValor(-0.7014, min, max);
		amostrasDeTreinamento[5][1] = normalizarValor(1.0316, min, max);
		amostrasDeTreinamento[5][2] = normalizarValor(3.6005, min, max);
		amostrasDeTreinamento[6][0] = normalizarValor(0.3748, min, max);
		amostrasDeTreinamento[6][1] = normalizarValor(0.1536, min, max);
		amostrasDeTreinamento[6][2] = normalizarValor(6.1537, min, max);
		amostrasDeTreinamento[7][0] = normalizarValor(-0.6920, min, max);
		amostrasDeTreinamento[7][1] = normalizarValor(0.9404, min, max);
		amostrasDeTreinamento[7][2] = normalizarValor(4.4058, min, max);
		amostrasDeTreinamento[8][0] = normalizarValor(-1.3970, min, max);
		amostrasDeTreinamento[8][1] = normalizarValor(0.7141, min, max);
		amostrasDeTreinamento[8][2] = normalizarValor(4.9263, min, max);
		amostrasDeTreinamento[9][0] = normalizarValor(-1.8842, min, max);
		amostrasDeTreinamento[9][1] = normalizarValor(-0.2805, min, max);
		amostrasDeTreinamento[9][2] = normalizarValor(1.2548, min, max);

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas, null,
				taxaAprendizagem, amostrasDeTreinamento, numeroDeAmostras,
				funcaoDeAtivacao);
		double peso[] = new double[4];

		// peso[0] = 0.24396974989924738;
		// peso[1] = 0.3316689635674268;
		// peso[2] = 0.7126784851492193;
		// peso[3] = -0.08419289559049922;

		// peso[0] = 0.7884078978665909;
		// peso[1] = 0.13415834556710346;
		// peso[2] = 0.7131431506470068;
		// peso[3] = -0.0019562868059819216;

		// peso[0] = 0.7926090674571803;
		// peso[1] = 0.08932371967688077;
		// peso[2] = 0.7091069681870973;
		// peso[3] = -0.0042135295101728976;

		// peso[0] = 0.7991867770719575;
		// peso[1] = 0.21284106739532152;
		// peso[2] = 0.8410780543833056;
		// peso[3] = -0.02402234702356129;

		peso[0] = 0.26736096532696924;
		peso[1] = 0.27507413311046996;
		peso[2] = 0.6649037072298012;
		peso[3] = -0.07151682369333198;

		perceptron.setPesosTreinado(peso);
		perceptron.Operacao();
	}

	public static void classificacaoPetroleoNormalizado() {
		int numeroDeEntradas = 3;
		int numeroDeAMostras = 30;
		double saidaDesejada[] = new double[numeroDeAMostras];
		double taxaAprendizagem = 0.01;
		double amostrasDeTreinamento[][] = new double[numeroDeAMostras][numeroDeEntradas];
		int numeroDeAmostras = 4;
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		//double max = 13, min = -2;

		amostrasDeTreinamento[0][0] = -0.6508;
		amostrasDeTreinamento[0][1] = 0.1097;
		amostrasDeTreinamento[0][2] = 4.0009;
		saidaDesejada[0] = -1.0000;
		amostrasDeTreinamento[1][0] = -1.4492;
		amostrasDeTreinamento[1][1] = 0.8896;
		amostrasDeTreinamento[1][2] = 4.4005;
		saidaDesejada[1] = -1.0000;
		amostrasDeTreinamento[2][0] = 2.0850;
		amostrasDeTreinamento[2][1] = 0.6876;
		amostrasDeTreinamento[2][2] = 12.0710;
		saidaDesejada[2] = -1.0000;
		amostrasDeTreinamento[3][0] = 0.2626;
		amostrasDeTreinamento[3][1] = 1.1476;
		amostrasDeTreinamento[3][2] = 7.7985;
		saidaDesejada[3] = 1.0000;
		amostrasDeTreinamento[4][0] = 0.6418;
		amostrasDeTreinamento[4][1] = 1.0234;
		amostrasDeTreinamento[4][2] = 7.0427;
		saidaDesejada[4] = 1.0000;
		amostrasDeTreinamento[5][0] = 0.2569;
		amostrasDeTreinamento[5][1] = 0.6730;
		amostrasDeTreinamento[5][2] = 8.3265;
		saidaDesejada[5] = -1.0000;
		amostrasDeTreinamento[6][0] = 1.1155;
		amostrasDeTreinamento[6][1] = 0.6043;
		amostrasDeTreinamento[6][2] = 7.4446;
		saidaDesejada[6] = 1.0000;
		amostrasDeTreinamento[7][0] = 0.0914;
		amostrasDeTreinamento[7][1] = 0.3399;
		amostrasDeTreinamento[7][2] = 7.0677;
		saidaDesejada[7] = -1.0000;
		amostrasDeTreinamento[8][0] = 0.0121;
		amostrasDeTreinamento[8][1] = 0.5256;
		amostrasDeTreinamento[8][2] = 4.6316;
		saidaDesejada[8] = 1.0000;
		amostrasDeTreinamento[9][0] = -0.0429;
		amostrasDeTreinamento[9][1] = 0.4660;
		amostrasDeTreinamento[9][2] = 5.4323;
		saidaDesejada[9] = 1.0000;
		amostrasDeTreinamento[10][0] = 0.4340;
		amostrasDeTreinamento[10][1] = 0.6870;
		amostrasDeTreinamento[10][2] = 8.2287;
		saidaDesejada[10] = -1.0000;
		amostrasDeTreinamento[11][0] = 0.2735;
		amostrasDeTreinamento[11][1] = 1.0287;
		amostrasDeTreinamento[11][2] = 7.1934;
		saidaDesejada[11] = 1.0000;
		amostrasDeTreinamento[12][0] = 0.4839;
		amostrasDeTreinamento[12][1] = 0.4851;
		amostrasDeTreinamento[12][2] = 7.4850;
		saidaDesejada[12] = -1.0000;
		amostrasDeTreinamento[13][0] = 0.4089;
		amostrasDeTreinamento[13][1] = -0.1267;
		amostrasDeTreinamento[13][2] = 5.5019;
		saidaDesejada[13] = -1.0000;
		amostrasDeTreinamento[14][0] = 1.4391;
		amostrasDeTreinamento[14][1] = 0.1614;
		amostrasDeTreinamento[14][2] = 8.5843;
		saidaDesejada[14] = -1.0000;
		amostrasDeTreinamento[15][0] = -0.9115;
		amostrasDeTreinamento[15][1] = -0.1973;
		amostrasDeTreinamento[15][2] = 2.1962;
		saidaDesejada[15] = -1.0000;
		amostrasDeTreinamento[16][0] = 0.3654;
		amostrasDeTreinamento[16][1] = 1.0475;
		amostrasDeTreinamento[16][2] = 7.4858;
		saidaDesejada[16] = 1.0000;
		amostrasDeTreinamento[17][0] = 0.2144;
		amostrasDeTreinamento[17][1] = 0.7515;
		amostrasDeTreinamento[17][2] = 7.1699;
		saidaDesejada[17] = 1.0000;
		amostrasDeTreinamento[18][0] = 0.2013;
		amostrasDeTreinamento[18][1] = 1.0014;
		amostrasDeTreinamento[18][2] = 6.5489;
		saidaDesejada[18] = 1.0000;
		amostrasDeTreinamento[19][0] = 0.6483;
		amostrasDeTreinamento[19][1] = 0.2183;
		amostrasDeTreinamento[19][2] = 5.8991;
		saidaDesejada[19] = 1.0000;
		amostrasDeTreinamento[20][0] = -0.1147;
		amostrasDeTreinamento[20][1] = 0.2242;
		amostrasDeTreinamento[20][2] = 7.2435;
		saidaDesejada[20] = -1.0000;
		amostrasDeTreinamento[21][0] = -0.7970;
		amostrasDeTreinamento[21][1] = 0.8795;
		amostrasDeTreinamento[21][2] = 3.8762;
		saidaDesejada[21] = 1.0000;
		amostrasDeTreinamento[22][0] = -1.0625;
		amostrasDeTreinamento[22][1] = 0.6366;
		amostrasDeTreinamento[22][2] = 2.4707;
		saidaDesejada[22] = 1.0000;
		amostrasDeTreinamento[23][0] = 0.5307;
		amostrasDeTreinamento[23][1] = 0.1285;
		amostrasDeTreinamento[23][2] = 5.6883;
		saidaDesejada[23] = 1.0000;
		amostrasDeTreinamento[24][0] = -1.2200;
		amostrasDeTreinamento[24][1] = 0.7777;
		amostrasDeTreinamento[24][2] = 1.7252;
		saidaDesejada[24] = 1.0000;
		amostrasDeTreinamento[25][0] = 0.3957;
		amostrasDeTreinamento[25][1] = 0.1076;
		amostrasDeTreinamento[25][2] = 5.6623;
		saidaDesejada[25] = -1.0000;
		amostrasDeTreinamento[26][0] = -0.1013;
		amostrasDeTreinamento[26][1] = 0.5989;
		amostrasDeTreinamento[26][2] = 7.1812;
		saidaDesejada[26] = -1.0000;
		amostrasDeTreinamento[27][0] = 2.4482;
		amostrasDeTreinamento[27][1] = 0.9455;
		amostrasDeTreinamento[27][2] = 11.2095;
		saidaDesejada[27] = 1.0000;
		amostrasDeTreinamento[28][0] = 2.0149;
		amostrasDeTreinamento[28][1] = 0.6192;
		amostrasDeTreinamento[28][2] = 10.9263;
		saidaDesejada[28] = -1.0000;
		amostrasDeTreinamento[29][0] = 0.2012;
		amostrasDeTreinamento[29][1] = 0.2611;
		amostrasDeTreinamento[29][2] = 5.4631;
		saidaDesejada[29] = 1.0000;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	public static void Questao4() {
		int numeroDeEntradas = 2;
		double saidaDesejada[] = new double[4];
		double taxaAprendizagem = 1.0;
		double amostrasDeTreinamento[][] = new double[4][numeroDeEntradas];
		int numeroDeAmostras = 4;
		DeGrau funcaoDeAtivacao = new DeGrau(0.0);

		saidaDesejada[0] = 0.0;
		saidaDesejada[1] = 0.0;
		saidaDesejada[2] = 0.0;
		saidaDesejada[3] = 1.0;

		amostrasDeTreinamento[0][0] = 0.2;
		amostrasDeTreinamento[0][1] = 0.2;
		amostrasDeTreinamento[1][0] = 0.2;
		amostrasDeTreinamento[1][1] = 0.8;
		amostrasDeTreinamento[2][0] = 0.8;
		amostrasDeTreinamento[2][1] = 0.2;
		amostrasDeTreinamento[3][0] = 0.8;
		amostrasDeTreinamento[3][1] = 0.8;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	public static void Questao5() {
		int numeroDeEntradas = 2;
		double saidaDesejada[] = new double[4];
		double taxaAprendizagem = 0.9;
		double amostrasDeTreinamento[][] = new double[4][numeroDeEntradas];
		int numeroDeAmostras = 4;
		DeGrau funcaoDeAtivacao = new DeGrau(0.0);

		saidaDesejada[0] = 0.0;
		saidaDesejada[1] = 1.0;
		saidaDesejada[2] = 1.0;
		saidaDesejada[3] = 1.0;

		amostrasDeTreinamento[0][0] = 0.49;
		amostrasDeTreinamento[0][1] = 0.49;
		amostrasDeTreinamento[1][0] = 0.49;
		amostrasDeTreinamento[1][1] = 0.51;
		amostrasDeTreinamento[2][0] = 0.51;
		amostrasDeTreinamento[2][1] = 0.49;
		amostrasDeTreinamento[3][0] = 0.51;
		amostrasDeTreinamento[3][1] = 0.51;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	public static void Questao6() {
		int numeroDeEntradas = 2;
		double saidaDesejada[] = new double[4];
		double taxaAprendizagem = 1.0;
		double amostrasDeTreinamento[][] = new double[4][numeroDeEntradas];
		int numeroDeAmostras = 4;
		DeGrau funcaoDeAtivacao = new DeGrau(0.0);

		saidaDesejada[0] = 1.0;
		saidaDesejada[1] = 1.0;
		saidaDesejada[2] = 0.0;
		saidaDesejada[3] = 1.0;

		amostrasDeTreinamento[0][0] = 0.0;
		amostrasDeTreinamento[0][1] = 0.0;
		amostrasDeTreinamento[1][0] = 0.0;
		amostrasDeTreinamento[1][1] = 1.0;
		amostrasDeTreinamento[2][0] = 1.0;
		amostrasDeTreinamento[2][1] = 0.0;
		amostrasDeTreinamento[3][0] = 1.0;
		amostrasDeTreinamento[3][1] = 1.0;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	public static void Questao7() {
		int numeroDeEntradas = 2;
		double saidaDesejada[] = new double[4];
		double taxaAprendizagem = 0.001;
		double amostrasDeTreinamento[][] = new double[4][numeroDeEntradas];
		int numeroDeAmostras = 4;
		DeGrau funcaoDeAtivacao = new DeGrau(0.0);

		saidaDesejada[0] = 1.0;
		saidaDesejada[1] = 0.0;
		saidaDesejada[2] = 0.0;
		saidaDesejada[3] = 1.0;

		amostrasDeTreinamento[0][0] = 0.4;
		amostrasDeTreinamento[0][1] = 0.4;
		amostrasDeTreinamento[1][0] = 0.4;
		amostrasDeTreinamento[1][1] = 0.6;
		amostrasDeTreinamento[2][0] = 0.6;
		amostrasDeTreinamento[2][1] = 0.4;
		amostrasDeTreinamento[3][0] = 0.6;
		amostrasDeTreinamento[3][1] = 0.6;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

	public static void teste1() {
		int numeroDeEntradas = 2;
		double saidaDesejada[] = new double[4];
		double taxaAprendizagem = 0.5;
		double amostrasDeTreinamento[][] = new double[4][2];
		int numeroDeAmostras = 4;
		DeGrau funcaoDeAtivacao = new DeGrau(0.0);

		saidaDesejada[0] = 0.0;
		saidaDesejada[1] = 1.0;
		saidaDesejada[2] = 1.0;
		saidaDesejada[3] = 1.0;

		amostrasDeTreinamento[0][0] = 0.0;
		amostrasDeTreinamento[0][1] = 0.0;
		amostrasDeTreinamento[1][0] = 0.0;
		amostrasDeTreinamento[1][1] = 1.0;
		amostrasDeTreinamento[2][0] = 1.0;
		amostrasDeTreinamento[2][1] = 0.0;
		amostrasDeTreinamento[3][0] = 1.0;
		amostrasDeTreinamento[3][1] = 1.0;

		Perceptron1 perceptron = new Perceptron1(numeroDeEntradas,
				saidaDesejada, taxaAprendizagem, amostrasDeTreinamento,
				numeroDeAmostras, funcaoDeAtivacao);

		perceptron.treinamento(0.0);

		perceptron.getRelatorio();
	}

}
