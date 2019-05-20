package exer17;

public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca{

	private boolean statusEmprestimo;
	private String localizacao, descricao;

	public LivroDeBiblioteca(String _titulo, String _autor, int _numeroPaginas, int _anoEdicao, boolean _statusEmprestimo, String _localizacao, String _descricao) {
		super(_titulo, _autor, _numeroPaginas, _anoEdicao);
		this.setStatusEmprestimo(_statusEmprestimo);
		this.setLocalizacao(_localizacao);
		this.setDescricao(_descricao);
	}

	@Override
	public boolean isEmprestado() {
		return this.isStatusEmprestimo();
	}

	@Override
	public void empresta() {
		this.setStatusEmprestimo(true);	
	}

	@Override
	public void devolve() {
		this.setStatusEmprestimo(false);
	}

	@Override
	public String localiza() {
		if(this.isEmprestado())
			return "emprestado";
		else
			return "Disponivel";
	}

	@Override
	public String apresentaDescricao() {
		return this.getDescricao();
	}

	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(super.toString());
		dados.append("\n");
		dados.append(this.getLocalizacao());
		dados.append("\n");
		dados.append(this.getDescricao());
		return dados.toString();
	}

	public boolean isStatusEmprestimo() {
		return this.statusEmprestimo;
	}

	public void setStatusEmprestimo(boolean statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
