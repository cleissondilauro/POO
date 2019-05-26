package exer19;

public class CirculoEscalavel implements ObjetoGeometrico,Escalavel{

   	private Ponto centro;
   	private double raio;

   	public CirculoEscalavel(Ponto _centro,double _raio) {
         	this.centro = _centro; // Note o uso da palavra-chave this para marcar os campos
         	this.raio = _raio; 	// da classe que tem o mesmo nome dos argumentos
   	}
 
   	public double calculaÁrea() {
         	return Math.PI*raio*raio;
   	}

   	public double calculaPerímetro() {
         	return 2.0*Math.PI*this.raio;
   	}

   	public void amplia(double _escala) {
         	this.raio *= _escala;
   	}

   	public void espelha() throws Exception {
         	this.centro = new Ponto(this.centro.getX()*(-1),this.centro.getY());
   	}

   	public Ponto centro() {
         	return this.centro;
   	}
 
   	public String toString() {
         	// Retorna diretamente uma string criada com os valores dos campos. O método
         	// toString da classe Ponto2D é chamado implicitamente.
         	return centro + "-" + this.raio;
   	}

	@Override
	public ObjetoGeometrico clona() throws Exception {
		CirculoEscalavel clone;
		clone = new CirculoEscalavel(this.centro,this.raio);
		return clone;
	}


}
