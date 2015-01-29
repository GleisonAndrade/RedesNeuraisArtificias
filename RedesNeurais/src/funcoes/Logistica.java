package funcoes;

public class Logistica extends FuncaoAtivacao{
	private Double B;
	
	public Logistica(Double u, Double B) {
		super(u*-B);
		this.B = B;
	}

	@Override
	public Double ativar() {
		// TODO Auto-generated method stub
		return (1/(1+Math.exp(getU())));
	}

	@Override
	public Double derivada() {
		// TODO Auto-generated method stub
		return null;
	}

}
