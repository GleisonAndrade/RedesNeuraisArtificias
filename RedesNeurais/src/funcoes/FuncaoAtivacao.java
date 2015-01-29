package funcoes;

public abstract class FuncaoAtivacao {
	private Double y;
	private Double u;
	
	public FuncaoAtivacao(Double u){
		this.y = 0.0;
		this.u = u;
	}
	
	public abstract Double ativar();
	public abstract Double derivada();

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getU() {
		return u;
	}

	public void setU(Double u) {
		this.u = u;
	}
	
	

}
