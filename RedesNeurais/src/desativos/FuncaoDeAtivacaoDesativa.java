package desativos;

public class FuncaoDeAtivacaoDesativa {
	private double y;
	
	public FuncaoDeAtivacaoDesativa(){
		y = 0;
	}
	
	public void degrau(double u){
		if (u < 0) y = 0;
		else y = 1;
	}
	
	public void degrauBipolar(double u){
		if (u > 0) y = 1;
		else if (u < 0) y = -1;
		else y = 0;
	}
	
	public void rampaSimetrica(double u, double a){
		if (u > a) y = a;
		else if (u < a) y = -a;
		else y = u;
	}
	
	public void logistica(double u, double B){
		u = -B*u;
		y = 1/(1+Math.exp(u));
	}
	
	public void hiperbolica(double u, double B){
		u *= -B;
		y = (1-Math.exp(u))/(1+Math.exp(u));
	}
	
//	public void gaussiana(double u){
//		Math.exp((Math.pow(-(u-c), 2))/ Math.pow(2o, 2));
//	}
	
	public void linear(double u){
		y = u;
	}
	
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
