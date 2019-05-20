package exer18;

public abstract class FormaGeometrica {
	
	private Ponto ponto;
	private double espessura;
	private boolean solido;
	
	public FormaGeometrica(double _coordenada1, double _coordenada2, double _espessura, boolean _solido) {
		this.setPonto(new Ponto(_coordenada1,_coordenada2));
		this.setEspessura(_espessura);
		this.setSolido(_solido);
	}
	
	public FormaGeometrica() {
		this.setPonto(new Ponto(0,0));
		this.setEspessura(0);
		this.setSolido(false);
	}
	
	abstract public double area();
	
	abstract public double perimetro();
	
	public Ponto getPonto() {
		return this.ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	
	public double getEspessura() {
		return this.espessura;
	}
	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}
	
	public boolean isSolido() {
		return this.solido;
	}
	public void setSolido(boolean solido) {
		this.solido = solido;
	}
	
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		dados.append(this.ponto.toString());
		dados.append(" - ");
		dados.append(this.getEspessura());
		dados.append(" - ");
		dados.append(this.isSolido());
		return dados.toString();
		
	}
	
	public boolean equals(Object objeto){
		FormaGeometrica aux = (FormaGeometrica)objeto;

		if( this.ponto.equals(aux.ponto) && this.getEspessura() == aux.getEspessura() && this.isSolido() && aux.isSolido())
			return true;
		else
			return false;
	}


}
