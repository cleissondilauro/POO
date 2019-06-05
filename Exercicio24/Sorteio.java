package exer24;

public class Sorteio {
 
	private Data data;
	private NumerosSorteados numeros;
	
	/**
	 * Insere uma instância da classe Sorteio
	 *
	 * @param _data objeto a ser incluído da coleção
	 */
	public Sorteio(Data _data) {
		this.setData(_data);
		this.setNumeros(new NumerosSorteados());
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public NumerosSorteados getNumeros() {
		return numeros;
	}

	public void setNumeros(NumerosSorteados numeros) {
		this.numeros = numeros;
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da coleção
	 * separando os elementos por espaços
	 * @return retorna ums String com todos os dados
	 */
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getData().toString());
		dados.append(" ");
		dados.append(this.getNumeros().toString());
		return dados.toString();
	}
	
	
}
