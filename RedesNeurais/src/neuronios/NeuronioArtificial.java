package neuronios;

import java.util.ArrayList;

import funcoes.FuncaoAtivacao;


public class NeuronioArtificial {
	private ArrayList<Double> x;
	private ArrayList<Double> w;
	private Double combinadorLinear;
	private Double limiarDeAtivacao;
	private Double u;
	FuncaoAtivacao funcaoDeAtivacao;
	//private double y;
	
	public NeuronioArtificial(ArrayList<Double> x, ArrayList<Double> w, Double limiarDeAtivacao, FuncaoAtivacao funcaoDeAtivacao){
		this.x = x;
		this.w = w;
		this.limiarDeAtivacao = limiarDeAtivacao;
		this.combinadorLinear = 0.0;
		this.u = 0.0;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
		//this.funcaoAtivacao.setY(0);
		//y = 0;
	}

	public ArrayList<Double> getX() {
		return x;
	}

	public void setX(ArrayList<Double> x) {
		this.x = x;
	}

	public ArrayList<Double> getW() {
		return w;
	}

	public void setW(ArrayList<Double> w) {
		this.w = w;
	}

	public Double getCombinadorLinear() {		
		return combinadorLinear;
	}
	
	public Double somatorio() {
		combinadorLinear = 0.0;
		for(int i = 0; i < x.size(); i++){
			combinadorLinear += w.get(i) * x.get(i);
			//System.out.println( w.get(i)+" * "+ x.get(i));
		}
		//System.out.println(combinadorLinear+" somatorio");
		u = combinadorLinear - limiarDeAtivacao;
		return u;
	}

	public void setCombinadorLinear(Double combinadorLinear) {
		this.combinadorLinear = combinadorLinear;
	}

	public Double getLimiarDeAtivacao() {
		return limiarDeAtivacao;
	}

	public void setLimiarDeAtivacao(Double limiarDeAtivacao) {
		this.limiarDeAtivacao = limiarDeAtivacao;
	}

	public Double getU() {
		return u;
	}

	public void setU(Double u) {
		this.u = u;
	}
// agora aqui faz todos os calculos e nos retorna a saida do neuronio
	public Double getY() {
		//System.out.println(x+"||"+w);
		funcaoDeAtivacao.setU(somatorio());
		return funcaoDeAtivacao.ativar();
	}

	public void setY(Double y) {
		funcaoDeAtivacao.setY(y);				
	}
		
}
