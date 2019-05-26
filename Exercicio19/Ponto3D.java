package exer19;

public class Ponto3D extends Ponto{
	
	private double z;
	
	public Ponto3D(double _x,double _y, double _z) throws Exception {
		super(_x,_y);
		this.setZ(_z);
	}
	public Ponto3D() throws Exception {
		super(0,0);
		this.setZ(0);
	}
	
	public Ponto3D clonar() throws Exception {
     	return new Ponto3D(this.getX(), this.getY(),this.getZ());
	}
	
	public Ponto3D criaSwap() throws Exception {
     	return new Ponto3D(this.getY(), this.getX(),this.getZ());
	}
	
	public boolean temEixoComum(Ponto3D _ponto){
		if(super.temEixoComum((Ponto)_ponto) && this.getZ()==_ponto.getZ()) 
			return true;
		else
			return false;
	}
	
	static public double distancia(double x1, double y1,double z1, double x2, double y2,double z2){
     	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));
	}
	
	public double distancia(Ponto3D _ponto){
     	return Ponto3D.distancia(this.getX(),this.getY(),this.getZ(),_ponto.getX(),_ponto.getY(),_ponto.getZ());
	}
	
	public double distancia(double _x, double _y,double _z){
     	return Ponto3D.distancia(this.getX(),this.getY(),this.getZ(),_x,_y,_z);
	}
	
	public double distanciaDaOrigem(){
     	return Ponto3D.distancia(this.getX(),this.getY(),this.getZ(),0,0,0);
	}
	
	public int compareTo(Ponto3D _ponto){
     	if (this.distanciaDaOrigem() > _ponto.distanciaDaOrigem())
            	return 1;
     	else if(this.distanciaDaOrigem() < _ponto.distanciaDaOrigem())
            	return -1;
     	else
            	return 0;
	}
	
	public boolean equals(Object obj) {
     	if (this == obj)
            	return true;
     	if (obj == null)
            	return false;
     	if (getClass() != obj.getClass())
            	return false;
     	final Ponto3D other = (Ponto3D) obj;
     	if(super.equals(obj) && Double.doubleToLongBits(this.getZ()) != Double.doubleToLongBits(other.z))
     		return false;

     	return true;
	}
	
	public String toString(){
		
		StringBuilder coord = new StringBuilder();
     	coord.append("(");
     	coord.append(this.getX());
     	coord.append(",");
     	coord.append(+this.getY());
    	coord.append(",");
     	coord.append(+this.getZ());
     	coord.append(")");
     	return coord.toString();
	}
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) throws Exception {
		if(Ponto.isLimite(z)) 
			this.z = z;
		else
        	throw new Exception ("valor de Z fora dos limites");
	}
}
