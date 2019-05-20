package exer18;

public class Retangulo extends Quadrado{
	
	private double largura;
	
	public Retangulo(double _coordenada1, double _coordenada2, double _espessura, boolean _solido,double _comprimento, double _largura) {
		super(_coordenada1,_coordenada2,_espessura,_solido,_comprimento);
		this.setLargura(_largura);
	}
	
	public Retangulo() {
		super();
		this.setLargura(0);
	}

	@Override
	public double area() {
		return super.getComprimento() * this.largura;
	}

	@Override
	public double perimetro() {
		return 2 * super.getComprimento() + 2 * this.largura;
	}
	
	@Override
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		dados.append(super.toString());
		dados.append(" - ");
		dados.append(this.getLargura());
		return dados.toString();
		
	}
	
	@Override
	public boolean equals(Object objeto){
		Retangulo aux = (Retangulo)objeto;

		if( super.equals(aux) && this.getLargura()==aux.getLargura())
			return true;
		else
			return false;
	}
	
	
	public double getLargura() {
		return this.largura;
	}

	public void setLargura(double _largura) {
		this.largura = _largura;
	}
	
	
}
