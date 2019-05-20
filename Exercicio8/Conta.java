package xer8;


public class Conta {
 
	static final public double DEFAULT_JUROS = 0;
	private double saldo;
	private String nome;
	private static double taxaJuros=DEFAULT_JUROS;
	
	
	
	public Conta(String nome, double saldo) throws Exception{
		this.criaConta( nome,  saldo);
	}
	
	public void criaConta(String nome, double saldo) throws Exception {
		if(saldo>=0) {
			this.nome=nome;
			this.saldo=saldo;		
		}else
			throw new Exception("Saldo Negativo");
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo)throws Exception {
		if(saldo>=0) {
			this.saldo=saldo;		
		}else
			throw new Exception("Saldo Negativo");
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public  double getTaxaJuros() {
		return taxaJuros;
	}
	public static void setTaxaJuros(double taxaJuros) {
		Conta.taxaJuros = taxaJuros;
	}

	
	public String toString(){
		StringBuilder dadosConta = new StringBuilder();
		dadosConta.append("Nome:\t");
		dadosConta.append(this.getNome());
		dadosConta.append("\n");
		dadosConta.append("Saldo:\t");
		dadosConta.append(this.getSaldo());
		return dadosConta.toString();
	} 


	public boolean equals(Object objeto) {
		Conta aux = (Conta)objeto;

		if(this.getNome().equals(aux.getNome()) && this.getSaldo() == aux.getSaldo() )
			return true;
		else
			return false;
	}
	
	public int compareTo(Conta comparaConta) {
		return this.getNome().compareTo(comparaConta.getNome());
	
	}

	public void corrigirSaldo()throws Exception {
		this.setSaldo((this.getSaldo()* (this.getTaxaJuros()/100))+this.getSaldo());
	}


}
