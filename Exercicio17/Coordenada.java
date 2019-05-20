package exer18;


public class Coordenada {

	private double coordenada;
	
	public Coordenada(double _coordenada) {
		this.setCoordenada(_coordenada);
	}
	
	public Coordenada() {
		this.setCoordenada(0);
	}

	public double getCoordenada() {
		return this.coordenada;
	}

	public void setCoordenada(double _coordenada) {
		this.coordenada = _coordenada;
	}	
	
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getCoordenada());
		return dados.toString();
	}
	
	public boolean equals(Object objeto){
		
		Coordenada aux = (Coordenada)objeto;

		if( this.getCoordenada()== aux.getCoordenada())
			return true;
		else
			return false;
	}
}
