package exer18;

public class Circulo extends FormaGeometrica {

	private double raio;
	
	public Circulo(double _coordenada1, double _coordenada2, double _espessura, boolean _solido,double _raio) {
		super(_coordenada1,_coordenada2,_espessura,_solido);
		this.setRaio(_raio);
	}
	
	public Circulo() {
		super();
		this.setRaio(0);
	}
	
	@Override
	public double area() {
		return Math.PI * this.raio * this.raio;
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * this.raio;
	}

	@Override
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		dados.append(super.toString());
		dados.append(" - ");
		dados.append(this.getRaio());
		return dados.toString();
		
	}
	
	@Override
	public boolean equals(Object objeto){
		Circulo aux = (Circulo)objeto;

		if( super.equals(aux) && this.getRaio()==aux.getRaio())
			return true;
		else
			return false;
	}
	
	public double getRaio() {
		return this.raio;
	}

	public void setRaio(double _raio) {
		this.raio = _raio;
	}

}
