package funcoes;

public class Sinal extends FuncaoAtivacao{

	public Sinal(Double u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double ativar() {
		if (getU() >= 0) return 1.0;
		else return -1.0;
	}

	@Override
	public Double derivada() {
		// TODO Auto-generated method stub
		return null;
	}


}
