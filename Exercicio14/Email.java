package exer14;

public class Email {

	private String email;

	//Construtores sobrecarregados
	public Email(String _email) throws Exception {
		this.setEmail(_email);
	}

	public Email() throws Exception {
		this.setEmail("email@padrao.com");
	}

	@Override //Ocorre a sobreposição do médoto da classe padrão do java
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getEmail());
		return dados.toString();
	}
	
	public boolean equals(Object objeto){
		Email aux = (Email)objeto;
		
		if (this.getEmail().equals(aux.getEmail()))
			return true;
		else
			return false;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String _email) throws Exception {
		if (_email.contains("@"))
			this.email = _email;
		else
			throw new Exception("Endereço de e-mail incorreto.");
	}
}
