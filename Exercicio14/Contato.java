package exer14;

public class Contato {
	
	private String nome;
	private Email email;
	
	//Construtores sobrecarregados
	public Contato(String _nome, String _email)throws Exception{
		this.setEmail(new Email(_email));
		this.setNome(_nome);
	}
	public Contato()throws Exception{
		this.setEmail(new Email());
		this.setNome("Sem nome");
	}
	
	@Override //Ocorre a sobreposição do médoto da classe padrão do java
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getNome());
		dados.append("\n");
		dados.append(this.getEmail());
		return dados.toString();
	}
	
	public boolean equals(Object objeto){
		Contato aux = (Contato)objeto;
		
		if (this.email.equals(aux.getEmail()) && this.getNome().equals(aux.getNome()) )
			return true;
		else
			return false;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Email getEmail() {
		return this.email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	
}
