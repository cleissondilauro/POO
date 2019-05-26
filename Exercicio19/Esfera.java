package exer19;

public class Esfera implements ObjetoTridimensional {
	
	private Ponto3D centro;
   	private double raio;
   	
   	public Esfera(double _x, double _y, double _z, double _r) throws Exception{
   		this.setCentro(new Ponto3D(_x,_y,_z));
   		this.setRaio(_r);
   	}
   	
	public Esfera() throws Exception{
   		this.setCentro(new Ponto3D());
   		this.setRaio(0);
   	}
   	
	@Override
	public Ponto3D centro() throws Exception {
		// TODO Auto-generated method stub
		return this.getCentro();
	}

	@Override
	public double calculaSuperficie() {
		//área de sua superfície é igual a 4πr²
		// TODO Auto-generated method stub 
		
		return 4*Math.PI*this.getRaio()*this.getRaio();
	}

	@Override
	public double calculaVolume() {
		//O volume de uma esfera é igual a (4/3)πr³
		// TODO Auto-generated method stub
		
		return (4/3)*Math.PI*this.getRaio()*this.getRaio()*this.getRaio();
	}

	public String toString() {	
		StringBuilder builder = new StringBuilder();
		builder.append(" - ");
		builder.append(this.getCentro());
		builder.append(" - ");
		builder.append(this.getRaio());
		builder.append(" - ");
		builder.append(this.calculaSuperficie());
		builder.append(" - ");
		builder.append(this.calculaVolume());
		return builder.toString();
	}
	
	public void amplia(double _escala) {
     	this.raio *= _escala;
	}
	
	public Ponto3D getCentro() {
		return this.centro;
	}

	public void setCentro(Ponto3D centro) {
		this.centro = centro;
	}

	public double getRaio() {
		return this.raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}



}
