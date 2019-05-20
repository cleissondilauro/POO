package exer18;

public class Uso {
	
	public static void main(String[] args) {
		
		FormaGeometrica obj1 = new Retangulo();
		FormaGeometrica obj2 = new Quadrado();
		((Retangulo)obj1).setComprimento(5);
		((Retangulo)obj1).setLargura(2);
		((Quadrado)obj2).setComprimento(2);
		System.out.println(obj1.toString() +" - Área "+obj1.area());
		System.out.println(obj2.toString() +" - Área "+obj2.area());
	}
}
