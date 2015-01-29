package desativos;

import java.util.ArrayList;

import neuronios.NeuronioArtificial;


public class FeedforwardDesativa{

//	public Feedforward(ArrayList<Double> x, ArrayList<Double> w,
//			double limiarDeAtivacao) {
//		super(x, w, limiarDeAtivacao);
//		// TODO Auto-generated constructor stub
//	}
	
	public static void main(String[] args) {
		ArrayList<Double> wa = new ArrayList<Double>();
		ArrayList<Double> wb = new ArrayList<Double>();
		ArrayList<Double> wc = new ArrayList<Double>();
		ArrayList<Double> w1 = new ArrayList<Double>();
		
//		ArrayList<Double> xa = new ArrayList<Double>();
//		ArrayList<Double> xb = new ArrayList<Double>();
//		ArrayList<Double> xc = new ArrayList<Double>();
		ArrayList<Double> x = new ArrayList<Double>();
		
		ArrayList<Double> y = new ArrayList<Double>();
		
		
		
		Double ya=0.0, yb=0.0, yc=0.0, y1=0.0, ua=0.0, ub=0.0, uc=0.0, u1=0.0;
		
		x.add((double) 0.26);
		x.add((double) 0.39);
		
		// A
		NeuronioArtificial A = new NeuronioArtificial(x, wa, 0.1);
		wa.add((double) 0.6);
		wa.add((double) 0.7);		
		A.somatorio();		
		System.out.println("Somatorio A: "+A.getCombinadorLinear());		
		ua = A.getCombinadorLinear() - 0.1;		
		System.out.println("ua = "+ua);		
		A.getFuncaoAtivacao().linear(ua);
		ya = A.getY();
		y.add(ya);
		System.out.println("ya = "+ya);
		
		//B
		NeuronioArtificial B = new NeuronioArtificial(x, wb, 0.8);
		wb.add((double) 0.4);
		wb.add((double) 0.2);		
		B.somatorio();		
		System.out.println("Somatorio B: "+B.getCombinadorLinear());		
		ub = B.getCombinadorLinear() - 0.8;		
		System.out.println("ub = "+ub);		
		B.getFuncaoAtivacao().linear(ub);
		yb = B.getY();
		y.add(yb);
		System.out.println("yb = "+yb);
		
		//C
		NeuronioArtificial C = new NeuronioArtificial(x, wc, 0.5);
		wc.add((double) 0.1);
		wc.add((double) 0.3);		
		C.somatorio();		
		System.out.println("Somatorio C: "+C.getCombinadorLinear());		
		uc = C.getCombinadorLinear() - 0.5;		
		System.out.println("uc = "+uc);		
		C.getFuncaoAtivacao().linear(uc);
		yc = C.getY();
		y.add(yc);
		System.out.println("yc = "+yc);
		
		//S
		NeuronioArtificial S = new NeuronioArtificial(y, w1, 0.2);
		w1.add((double) 0.6);
		w1.add((double) 0.5);	
		w1.add((double) 0.4);
		S.somatorio();		
		System.out.println("Somatorio S: "+S.getCombinadorLinear());		
		u1 = S.getCombinadorLinear() - 0.2;		
		System.out.println("u1 = "+u1);		
		S.getFuncaoAtivacao().linear(u1);
		y1 = S.getY();
		//y.add(ya);
		System.out.println("y1 = "+y1);
	}
	

}
