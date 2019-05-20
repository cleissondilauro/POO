package exer18;

public class Quadrado extends FormaGeometrica{
	
	private double comprimento;
	
	public Quadrado(double _coordenada1, double _coordenada2, double _espessura, boolean _solido,double _comprimento) {
		super(_coordenada1,_coordenada2,_espessura,_solido);
		this.setComprimento(_comprimento);
	}
	
	public Quadrado() {
		super();
		this.setComprimento(0);
	}


	@Override
	public double area() {
		return this.comprimento * this.comprimento;
	}

	@Override
	public double perimetro() {
		return 4 * this.comprimento;
	}
	
	@Override
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		dados.append(super.toString());
		dados.append(" - ");
		dados.append(this.getComprimento());
		return dados.toString();
		
	}
	
	@Override
	public boolean equals(Object objeto){
		Quadrado aux = (Quadrado)objeto;

		if( super.equals(aux) && this.getComprimento()==aux.getComprimento())
			return true;
		else
			return false;
	}
	
	public double getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(double _comprimento) {
		this.comprimento = _comprimento;
	}
	
}
