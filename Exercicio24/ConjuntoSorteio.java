package exer24;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoSorteio implements Serializable {

	List<Sorteio> conjSorteio = new LinkedList<Sorteio>();
	/**
	 * Construtor
	 * @param _data instancia da classe Data
	 * @param qtdSorteios quantidade de numeros sorteados
	 */
	public ConjuntoSorteio(Data _data, int qtdSorteios) throws Exception {		
		for(int i=0; i<qtdSorteios; i++) {
			Data teste = new Data(_data);
			if(i!=0) {
				_data.incrementa();
			}
			if(i!=0) {
				teste.incrementa();
			}
			conjSorteio.add(new Sorteio(teste));
		}
	}
	
	public List<Sorteio> getConjSorteio() {
		return conjSorteio;
	}

	public void setConjSorteio(List<Sorteio> conjSorteio) {
		this.conjSorteio = conjSorteio;
	}
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da cole��o
	 * separando os elementos por espa�os
	 * @return retorna ums String com todos os dados
	 */
	public String toString() {
		StringBuilder dados = new StringBuilder();
		dados.append(this.getConjSorteio().toString());
		return dados.toString();
	}
	
}
