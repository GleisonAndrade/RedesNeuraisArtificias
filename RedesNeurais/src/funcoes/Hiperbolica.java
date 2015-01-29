package funcoes;

public class Hiperbolica extends FuncaoAtivacao{
	
	private Double B;

	public Hiperbolica(Double u, Double B) {
		super(u*-B);
		this.B = B;
	}

	@Override
	public Double derivada() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double ativar() {
		return (1-Math.exp(getU()))/(1+Math.exp(getU()));
	}


}
