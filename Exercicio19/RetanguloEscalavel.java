package exer19;

public class RetanguloEscalavel implements Escalavel, ObjetoGeometrico {

	private Ponto pontoSup, pontoInf;
	
   	
	public RetanguloEscalavel(double _x1, double _y1, double _x2, double _y2) throws Exception { 
		this.setPontoSup(new Ponto(_x1, _y1));
		this.setPontoInf(new Ponto(_x2, _y2));
	}
	public RetanguloEscalavel() throws Exception {
		this.setPontoSup(new Ponto());
		this.setPontoInf(new Ponto());
	}
	
	public double diferencaX() {
		return this.getPontoSup().getX()-this.getPontoInf().getX();
	}
	
	public double diferencaY() {
		return this.getPontoSup().getY()-this.getPontoInf().getY();
	}
	
	@Override
	public Ponto centro() throws Exception{
		Ponto centro = new Ponto(this.diferencaX(), this.diferencaY());
		return centro;
	}

	@Override
	public double calculaÁrea() {
		// TODO Auto-generated method stub
		return this.diferencaX()*this.diferencaY();
	}

	@Override
	public double calculaPerímetro() {
		// TODO Auto-generated method stub
		return 2*this.diferencaX()+2*this.diferencaY();
	}

	@Override
	public ObjetoGeometrico clona() throws Exception {
		RetanguloEscalavel clone;
		clone = new RetanguloEscalavel(this.getPontoSup().getX(),this.getPontoSup().getY(),this.getPontoInf().getX(),this.getPontoInf().getY());
		return clone;
	}

	@Override
	public void amplia(double escala) {
		try {
		  this.setPontoSup( new Ponto(2*this.getPontoSup().getX(), 2*this.getPontoSup().getY()));
		  this.setPontoSup( new Ponto(2*this.getPontoInf().getX(), 2*this.getPontoInf().getY()));
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void espelha() throws Exception {
		try {
		  this.setPontoSup( new Ponto((-1)*this.getPontoSup().getX(),this.getPontoSup().getY()));
		  this.setPontoSup( new Ponto((-1)*this.getPontoInf().getX(),this.getPontoInf().getY()));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Ponto getPontoSup() {
		return pontoSup;
	}

	public void setPontoSup(Ponto pontoSup) {
		this.pontoSup = pontoSup;
	}

	public Ponto getPontoInf() {
		return pontoInf;
	}

	public void setPontoInf(Ponto pontoInf) {
		this.pontoInf = pontoInf;
	}

}
