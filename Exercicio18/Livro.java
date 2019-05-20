package exer17;

public class Livro {

	private String titulo, autor;
	private int numeroPaginas, anoEdicao;

	public Livro(String _titulo, String _autor, int _numeroPaginas, int _anoEdicao) {
		this.setTitulo(_titulo);
		this.setAutor(_autor);
		this.setNumeroPaginas(_numeroPaginas);
		this.setAnoEdicao(_anoEdicao);
	}

	public Livro() {
		this.setTitulo("");
		this.setAutor("");
		this.setNumeroPaginas(0);
		this.setAnoEdicao(0);
	}

	public String ToString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getTitulo());
		dados.append("\n");
		dados.append(this.getAutor());
		dados.append("\n");
		dados.append(this.getNumeroPaginas());
		dados.append("\n");
		dados.append(this.getAnoEdicao());
		return dados.toString();
	}

	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumeroPaginas() {
		return this.numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public int getAnoEdicao() {
		return this.anoEdicao;
	}
	public void setAnoEdicao(int anoEdicao) {
		this.anoEdicao = anoEdicao;
	}


}
