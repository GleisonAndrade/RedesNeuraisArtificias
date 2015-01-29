package funcoes;

public class DeGrau extends FuncaoAtivacao{

	public DeGrau(Double u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double ativar() {
		if (getU() < 0) return 0.0;
		return 1.0;
	}

	@Override
	public Double derivada() {
		// TODO Auto-generated method stub
		return null;
	}

}
