package exer18;

public class Ponto {

	private Coordenada coordenada1,coordenada2;
	
	public Ponto(double _coordenada1, double _coordenada2) {
		this.setCoordenada1(new Coordenada(_coordenada1));
		this.setCoordenada2(new Coordenada(_coordenada2));
		
	}
	
	public Ponto() {
		this.setCoordenada1(new Coordenada(0));
		this.setCoordenada2(new Coordenada(0));
		
	}

	public Coordenada getCoordenada1() {
		return coordenada1;
	}

	public void setCoordenada1(Coordenada coordenada1) {
		this.coordenada1 = coordenada1;
	}

	public Coordenada getCoordenada2() {
		return coordenada2;
	}

	public void setCoordenada2(Coordenada coordenada2) {
		this.coordenada2 = coordenada2;
	}
	
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append("(");
		dados.append(this.getCoordenada1().toString());
		dados.append(",");
		dados.append(this.getCoordenada2().toString());
		dados.append(")");
		return dados.toString();
	}
	
	
	public boolean equals(Object objeto){
		Ponto aux = (Ponto)objeto;

		if( this.getCoordenada1()== aux.getCoordenada1() && this.getCoordenada2()== aux.getCoordenada2())
			return true;
		else
			return false;
	}

	
}
