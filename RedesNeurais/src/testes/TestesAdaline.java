package testes;

import java.io.IOException;

import jxl.read.biff.BiffException;
import arquivos.ManipulaExcel;
import neuronios.Adaline;
import neuronios.Perceptron1;
import funcoes.DeGrau;
import funcoes.FuncaoAtivacao;
import funcoes.Sinal;

/**
 * @author Gleison
 *
 */
public class TestesAdaline {

	/**
	 * @param Lista de Exercicios 6 RNA
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {

//		Questao3();
//		TreinamentoI();
		TreinamentoII();
//		Testes();
//		TreinamentoAdaB();

	}
	
	
	public static void Questao3(){
		int numeroDeEntradas = 4;
		Integer numeroDeAmostras = 4;
		double[] saidaDesejada = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.0025;
		double[][] amostrasDeTreinamento = new double[numeroDeAmostras][numeroDeEntradas];
		double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		
		saidaDesejada[0] = 0.0;
		saidaDesejada[1] = 1.0;
		saidaDesejada[2] = 1.0;
		saidaDesejada[3] = 1.0;
		
		amostrasDeTreinamento[0][0] = 0.0; amostrasDeTreinamento[0][1] = 0.0;
		amostrasDeTreinamento[1][0] = 0.0; amostrasDeTreinamento[1][1] = 1.0;
		amostrasDeTreinamento[2][0] = 1.0; amostrasDeTreinamento[2][1] = 0.0;
		amostrasDeTreinamento[3][0] = 1.0; amostrasDeTreinamento[3][1] = 1.0;
		
		
		Adaline adaline = new Adaline(numeroDeEntradas, saidaDesejada, taxaAprendizagem, precisaoRequerida, amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		adaline.treinamento(10);
		
		adaline.getRelatorio();
	
	}
	
	public static void TreinamentoI() throws BiffException, IOException{
		int numeroDeEntradas = 4;
		Integer numeroDeAmostras;// = 4;
		double[] saidaDesejada;// = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.0025;
		double[][] amostrasDeTreinamento;// = new double[numeroDeAmostras][numeroDeEntradas];
		double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Treinamento_Adaline_PPA.xls", 1, 1);
		amostrasDeTreinamento = excel.getPlanilhaTreinamento();
		numeroDeAmostras = excel.getLinhas() - 1;
		saidaDesejada = excel.getD();
		
		Adaline adaline = new Adaline(numeroDeEntradas, saidaDesejada, taxaAprendizagem, precisaoRequerida, amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		adaline.treinamento(100000000);
		
		adaline.getRelatorio();
	
	}
	
	
	public static void TreinamentoII() throws BiffException, IOException{
		int numeroDeEntradas = 4;
		Integer numeroDeAmostras;// = 4;
		double[] saidaDesejada;// = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.0025;
		double[][] amostrasDeTreinamento;// = new double[numeroDeAmostras][numeroDeEntradas];
		double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Treinamento_Adaline_PPA.xls", 1, 1);
		amostrasDeTreinamento = excel.getPlanilhaTreinamento();
		numeroDeAmostras = excel.getLinhas() - 1;
		saidaDesejada = excel.getD();
		
		Adaline adaline = new Adaline(numeroDeEntradas, saidaDesejada, taxaAprendizagem, precisaoRequerida, amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		adaline.treinamentoOffline(0);
		
		adaline.getRelatorio();
	
	}
	
	public static void Testes() throws BiffException, IOException{
		int numeroDeEntradas = 4;
		Integer numeroDeAmostras;// = 4;
		double[] saidaDesejada;// = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.0025;
		double[][] amostrasDeTreinamento;// = new double[numeroDeAmostras][numeroDeEntradas];
		double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Teste_Adaline_PPA.xls", 1, 1);
		amostrasDeTreinamento = excel.getPlanilha();
		numeroDeAmostras = excel.getLinhas() - 1;
		saidaDesejada = excel.getD();
		
		Adaline adaline = new Adaline(numeroDeEntradas, saidaDesejada, taxaAprendizagem, precisaoRequerida, amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		double peso[] = new double[5];
		/* Treinamento I - de T1 a T5
		peso[0] = -1.813;
		peso[1] = 1.312;
		peso[2] = 1.642;
		peso[3] = -0.427;
		peso[4] = -1.177;
		*/
		
		/* Treinamento II */
//		peso[0] = 3.552;	peso[1]=-0.828;	peso[2] = 3.856; 	peso[3] = -1.409;	peso[4]= 2.997;
//		peso[0] = 2.743;	peso[1] = -0.468;	peso[2] = 3.619; 	peso[3] = -1.466;	peso[4]= 2.421;
//		peso[0] = 4.408;	peso[1] = -1.787;	peso[2] = -2.952; 	peso[3] = 6.719;	peso[4]= 4.416;
//		peso[0] = 3.262;	peso[1] = -1.012;	peso[2] = 4.719; 	peso[3] = -1.336;	peso[4]= 2.922;
//		peso[0] = 0.964;	peso[1] = 0.774;	peso[2] = 1.109; 	peso[3] = 0.130;	peso[4]= 0.395;
		
		/* Treinamento III */
//		peso[0] = 2.986;	peso[1] = 11.859;	peso[2] = 15.027; 	peso[3] = -4.199;	peso[4]= -10.969;
//		peso[0] = 2.953;	peso[1] = 11.849;	peso[2] = 15.022; 	peso[3] = -4.260;	peso[4]= -10.969;
//		peso[0] = 3.009;	peso[1] = 11.865;	peso[2] = 15.031; 	peso[3] = -4.157;	peso[4]= -10.970;
//		peso[0] = 2.982;	peso[1] = 11.858;	peso[2] = 15.026; 	peso[3] = -4.207;	peso[4]= -10.969;	
//		peso[0] = 2.992;	peso[1] = 11.860;	peso[2] = 15.028; 	peso[3] = -4.189;	peso[4]= -10.969;
		
		/* Treinamento IV */
//		peso[0] = 0.797;	peso[1] = 0.780;	peso[2] = 0.063; 	peso[3] = -0.049;	peso[4]= 0.744;
//		peso[0] = 0.437;	peso[1] = 0.678;	peso[2] = 0.025; 	peso[3] = 0.089;	peso[4]= 0.111;
//		peso[0] = 0.711;	peso[1] = 0.090;	peso[2] = 0.888; 	peso[3] = 0.020;	peso[4]= 0.517;
//		peso[0] = 0.538;	peso[1] = 0.583;	peso[2] = 0.255; 	peso[3] = 0.253;	peso[4]= 0.077;
//		peso[0] = 0.995;	peso[1] = 0.810;	peso[2] = 0.776; 	peso[3] = 0.211;	peso[4]= 0.381;				
						
						
		
		adaline.setPesosTreinado(peso);
		adaline.Operacao();
	}
	
	public static void TreinamentoPercB() throws BiffException, IOException{
		int numeroDeEntradas = 2;
		Integer numeroDeAmostras;// = 4;
		double[] saidaDesejada;// = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.001;
		double[][] amostrasDeTreinamento;// = new double[numeroDeAmostras][numeroDeEntradas];
		//double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Treinamento_Adaline_PPB.xls", 1, 1);
		amostrasDeTreinamento = excel.getPlanilhaTreinamento();
		numeroDeAmostras = excel.getLinhas() - 1;
		saidaDesejada = excel.getD();
		
		Perceptron1 perc = new Perceptron1(numeroDeEntradas, saidaDesejada, taxaAprendizagem, amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		perc.treinamento(100000000);
		
		perc.getRelatorio();
	
	}
	
	public static void TreinamentoAdaB() throws BiffException, IOException{
		int numeroDeEntradas = 2;
		Integer numeroDeAmostras;// = 4;
		double[] saidaDesejada;// = new double [numeroDeAmostras];
		double taxaAprendizagem = 0.001;
		double[][] amostrasDeTreinamento;// = new double[numeroDeAmostras][numeroDeEntradas];
		double precisaoRequerida = Math.pow(10, -6);
		Sinal funcaoDeAtivacao = new Sinal(0.0);
		ManipulaExcel excel = new ManipulaExcel("C:/Users/Gleison/Desktop/UFPI/Redes Neurais/Lista_Exercícios_06/Treinamento_Adaline_PPB.xls", 1, 1);
		amostrasDeTreinamento = excel.getPlanilhaTreinamento();
		numeroDeAmostras = excel.getLinhas() - 1;
		saidaDesejada = excel.getD();
		
		Adaline ada = new Adaline(numeroDeEntradas, saidaDesejada, taxaAprendizagem, precisaoRequerida,amostrasDeTreinamento, numeroDeAmostras, funcaoDeAtivacao);
	
		ada.treinamento(10000);
		
		ada.getRelatorio();
	
	}
	
	
	
}
