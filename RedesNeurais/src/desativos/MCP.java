package desativos;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import arquivos.GerarArquivo;

import neuronios.NeuronioArtificial;


public class MCP {
	public static void main(String[] args) {
//		NeuronioArtificial mcp;// = new NeuronioArtificial(x, w, limiarDeAtivacao)
//		ArrayList<Double> x ;//= new ArrayList<Double>();
//		ArrayList<Double> w ;//= new ArrayList<Double>();
//		double u = 0;
//		double limiarDeAtivacao = 0;		
//		w = new ArrayList<Double>();
//		x = new ArrayList<Double>();
//		mcp = new NeuronioArtificial(x, w, limiarDeAtivacao);
//		
//		x.add((double) 0.74); w.add((double) 0.8);
//		x.add((double) 0.53); w.add((double) 0.5);
//		//x.add((double) 0.05); w.add((double) 0.8);
//		limiarDeAtivacao = 0.1;
//		mcp.somatorio();
//		
//		System.out.println("Somatorio: "+mcp.getCombinadorLinear());
//		
//		u = mcp.getCombinadorLinear() - limiarDeAtivacao;
//		
//		System.out.println("u = "+u);
//		
//		mcp.getFuncaoAtivacao().hiperbolica(u, 1);
//		
//		System.out.println("y = "+mcp.getY());
//		
//		GerarArquivo g = new GerarArquivo();
		graficos("F.csv");
		
	}
	
	public static void graficos(String nome){
		
		NeuronioArtificial mcp;// = new NeuronioArtificial(x, w, limiarDeAtivacao)
		ArrayList<Double> x ;//= new ArrayList<Double>();
		ArrayList<Double> w ;//= new ArrayList<Double>();
		ArrayList<Double> x1 = new ArrayList<Double>();
		ArrayList<Double> x2 = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		GerarArquivo g = new GerarArquivo();
		double u;
		double limiarDeAtivacao = 0.0;	
		
		for(double i = 0.0; i < 1.0; i += 0.05){
			x1.add(i);
			if (i<=0.05)
			x2.add((double) 0);
			for (double j = 0.0; j < 1.0; j += 0.05){
				u = 0;
				w = new ArrayList<Double>();
				x = new ArrayList<Double>();
				
				
				x.add((double) i); w.add((double) 0.9);
				//x.add((double) j); w.add((double) 0.7);
							
				
				
				mcp = new NeuronioArtificial(x, w, limiarDeAtivacao);
				
				mcp.somatorio();
				
				//System.out.println("Somatorio: "+mcp.getCombinadorLinear());
				
				u = mcp.getCombinadorLinear() - limiarDeAtivacao;
				
				//System.out.println("u = "+u);
				
				mcp.getFuncaoAtivacao().hiperbolica(u, 1);
				
				y.add(mcp.getY());
				//System.out.println("y = "+y);
				
				
			}
						
		}
//		for(double i = 0.0; i < 1.0; i += 0.05){
//				x1.add(i);
//				u = 0;
//				w = new ArrayList<Double>();
//				x = new ArrayList<Double>();
//				
//				
//				x.add((double) i); w.add((double) 0.9);
//				x.add((double) j); w.add((double) 0.1);
//							
//				
//				
//				mcp = new NeuronioArtificial(x, w, limiarDeAtivacao);
//				
//				mcp.somatorio();
//				
//				//System.out.println("Somatorio: "+mcp.getCombinadorLinear());
//				
//				u = mcp.getCombinadorLinear() - limiarDeAtivacao;
//				
//				//System.out.println("u = "+u);
//				
//				mcp.getFuncaoAtivacao().logistica(u, 1);
//				
//				y.add(mcp.getY());
//				//System.out.println("y = "+y);
//				
//				
//			}
		
//		Random gerador = new Random();
//		 double numero;
//        
//		for (int i = 0; i < 2; i++) {
//			x1.add((double) i);
//			x2.add((double) i);
//			for (int j = 0; j < 2; j++) {
//				numero = gerador.nextDouble() % 2.0;
//				y.add(numero);
//			}
//		}
//		for (int i = 0; i < x1.size(); i++) {
//			System.out.println(x1.get(i));
//		}
//		for (int i = 0; i < y.size(); i++) {
//			System.out.println(y.get(i));
//		}
	g.gerarCsv2(nome, x1, x2, y);
	}

}
