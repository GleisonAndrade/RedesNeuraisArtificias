package funcoes;

public class Linear extends FuncaoAtivacao{

	public Linear(Double u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double ativar() {
		return getU();
	}

	@Override
	public Double derivada() {
		// TODO Auto-generated method stub
		return null;
	}

}
