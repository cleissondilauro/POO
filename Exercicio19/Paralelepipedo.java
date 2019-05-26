package exer19;

public class Paralelepipedo implements ObjetoTridimensional {

	private Ponto3D ponto1, ponto2;
	
	public Paralelepipedo(double x1, double y1, double z1,double x2, double y2, double z2) throws Exception {
		this.setPonto1(new Ponto3D(x1,y2,z1));
		this.setPonto2(new Ponto3D(x2,y2,z2));
	}
	public Paralelepipedo(  ) throws Exception {
		this.setPonto1(new Ponto3D());
		this.setPonto2(new Ponto3D());
	}
	
	@Override
	public Ponto3D centro() throws Exception {
		Ponto3D centro = new Ponto3D();
		return centro;
	}
	
	public double DeferencaA() {
		return this.ponto1.getX()-this.ponto2.getX();
	}
	public double DeferencaB() {
		return this.ponto1.getY()-this.ponto2.getY();
	}
	public double DeferencaC() {
		return this.ponto1.getZ()-this.ponto2.getZ();
	}
	@Override
	public double calculaSuperficie() {
		// TODO Auto-generated method stub
		
		// área da superfície é dada por 2(ab+bc+ac).
		double ab= this.DeferencaA()*this.DeferencaB();
		double ac= this.DeferencaA()*this.DeferencaC();
		double bc= this.DeferencaB()*this.DeferencaC();
		return 2*(ab+ac+bc);
	}

	@Override
	public double calculaVolume() {
		// TODO Auto-generated method stub
		//O volume de um paralelepípedo é igual a a×b×c
		return this.DeferencaA()*this.DeferencaB()*this.DeferencaC();
	}

	public Ponto3D getPonto1() {
		return ponto1;
	}

	public void setPonto1(Ponto3D ponto1) {
		this.ponto1 = ponto1;
	}

	public Ponto3D getPonto2() {
		return ponto2;
	}

	public void setPonto2(Ponto3D ponto2) {
		this.ponto2 = ponto2;
	}
	
	public String toString() {	
		StringBuilder builder = new StringBuilder();
		builder.append(" - ");
		builder.append(this.getPonto1());
		builder.append(" - ");
		builder.append(this.getPonto2());
		builder.append(" - ");
		builder.append(this.calculaSuperficie());
		builder.append(" - ");
		builder.append(this.calculaVolume());
		return builder.toString();
	}

}
