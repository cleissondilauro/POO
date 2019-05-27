package exer19;

public class CilindroEscalavel implements ObjetoTridimensional,Escalavel {

	private Ponto3D centro;
	private double raio;
	private double altura;
	
	public CilindroEscalavel(Ponto3D centro, double raio, double altura){
		this.setCentro(centro);
		this.setRaio(raio);
		this.setAltura(altura);
	}
	
	public CilindroEscalavel() throws Exception {
		this.setCentro(new Ponto3D(0,0,0));
		this.setRaio(1);
		this.setAltura(1);
	}
	

	@Override
	public void amplia(double escala) {
		this.setAltura(escala * this.getAltura());
		this.setRaio(escala * this.getRaio());
		
	}

	@Override
	public void espelha() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ponto3D centro() throws Exception {
		return this.getCentro();
	}

	@Override
	public double calculaSuperficie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculaVolume() {
		// TODO Auto-generated method stub 
		return 0;
	}

	public Ponto3D getCentro() {
		return centro;
	}

	public void setCentro(Ponto3D centro) {
		this.centro = centro;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
