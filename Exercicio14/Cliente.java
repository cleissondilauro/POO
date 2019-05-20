package exer14;

public class Cliente {
	
	private Contato contato;
	private String celular, endereco;
	private double rendaFamiliar;
	static final public double DEFAULT_RENDA_FAMILIAR = 2000;
	static private double rendaAnalisada = Cliente.DEFAULT_RENDA_FAMILIAR;
	
	//Construtores sobrecarregados
	public Cliente(String _nome, String _email, String _celular, String _endereco, double _rendaFamiliar)throws Exception{
		this.setContato(new Contato(_nome,_email));
		this.setCelular(_celular);
		this.setEndereco(_endereco);
		this.setRendaFamiliar(_rendaFamiliar);
	}
	
	public Cliente()throws Exception{
		this.setContato(new Contato());
		this.setCelular("Sem número");
		this.setEndereco("Sem endereço");
		this.setRendaFamiliar(0);
	}
	
	//Médodo whichCategoria sobrecarregados, o primeiro para verificar qual a categoria 
	//de cliente já instaciado e o segundo para consultar qual será a categoria do
	//furuto cliente
	public String whichCategoria() {
		if(this.getRendaFamiliar() > 2000.00)
			return "Top";
		else
			return "Usual";
	}
	
	public static String whichCategoria(double _rendaFamiliar) {
		if(_rendaFamiliar > 2000.00)
			return "Top";
		else
			return "Usual";
	}
	
	@Override //Ocorre a sobreposição do médoto da classe padrão do java
	public String toString() {
		
		StringBuilder dados = new StringBuilder();
		dados.append(this.getContato());
		dados.append("\n");
		dados.append(this.getCelular());
		dados.append("\n");
		dados.append(this.getEndereco());
		dados.append("\n");
		dados.append(this.getRendaFamiliar());
		return dados.toString();
	}
	
	public boolean equals(Object objeto){
		Cliente aux = (Cliente)objeto;
		
		if (this.contato.equals(aux.getContato()) && 
				this.getCelular().equals(aux.getCelular()) && 
				this.getEndereco().equals(aux.getEndereco()) && this.getRendaFamiliar()==aux.getRendaFamiliar())
			return true;
		else
			return false;
	}
	
	public Contato getContato() {
		return this.contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public String getCelular() {
		return this.celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getRendaFamiliar() {
		return this.rendaFamiliar;
	}
	public void setRendaFamiliar(double rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}
	public static double getRendaAnalisada() {
		return Cliente.rendaAnalisada;
	}
	public static void setRendaAnalisada(double rendaAnalisada) {
		Cliente.rendaAnalisada = rendaAnalisada;
	}
	
}
