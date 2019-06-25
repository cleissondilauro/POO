import java.io.Serializable;
import java.util.Comparator;

public class Evento extends ItemAgenda{

	private String local;
	/**
	 * Insere uma inst�ncia da classe Evento
	 * @param _titulo Uma String que representa o t�tulo do evento
	 * @param _descricao Uma String que representa a descri��o do evento
	 * @param _periodo Um inst�ncia da classe Periodo
	 * @param _local Uma String que representa o local do evento
	 */
	public Evento(String _titulo, String _descricao, Periodo _periodo,String _local) {
		super(_titulo, _descricao, _periodo);
		this.setLocal(_local);
	}
	 /**
	 * Insere uma inst�ncia da classe Evento
	 * @param _titulo Uma String que representa o t�tulo do evento
	 * @param _descricao Uma String que representa a descri��o do evento
	 *  
	 * @param diaIni Dia do inicio do per�odo
	 * @param mesIni M�s do inicio do per�odo
	 * @param anoIni Ano do inicio do per�odo
	 * 
	 * @param _horaIni Hor�rio de in�cio 
	 * @param _minutosIni Minutos do in�cio
	 * @param _segundosIni Minutos do in�cio
	 * 
	 * @param diaFim Dia do fim do per�odo
	 * @param mesFim M�s do fim do per�odo
	 * @param anoFim Ano do fim do per�odo
	 * 
	 * @param _horaFim Hor�rio de fim 
	 * @param _minutosFim Minutos do fim
	 * @param _segundosFim Minutos do fim
	 * 
	 * @param _local Uma String que representa o local do evento
	 * 
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
	 */
	public Evento(String _titulo, String _descricao, int diaIni, int mesIni, int anoIni, int diaFim, int mesFim,
			int anoFim, int _horaIni, int _minutosIni, int _segundosIni, int _horaFim, int _minutosFim,
			int _segundosFim, String _local) throws Exception {
		super(_titulo, _descricao, diaIni, mesIni, anoIni, diaFim, mesFim, anoFim, _horaIni, _minutosIni, _segundosIni,
				_horaFim, _minutosFim, _segundosFim);
		this.setLocal(_local);
	}
	
	/**
	  * @return local
	  */
	public String getLocal() {
		return local;
	}
	/**
	 * @param _local 
	 */
	public void setLocal(String _local) {
		this.local = _local;
	}
	
	/**
	 * Compara dois locais de eventos
	 * @param _evento Um objeto do tipo Evento
	 * @return Retorna 1 para maior <p>  0 para Igual <P>  <p> para menor -1
	 */
	public int compareTo(Evento _evento) {
		return this.getLocal().compareToIgnoreCase(_evento.getLocal());
	}
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da classe
	 * T�tulo \n Descri��o \n Per�odo \n Prioridade
	 * @return retorna um String com todos os dados da classe
	 */
	public String toString() {
		StringBuilder meta = new StringBuilder();
		meta.append(super.toString());
		meta.append("\n");
		meta.append(this.getLocal());
		return meta.toString();
	}
	
	
}
/**
 * Fornece um m�todo para ser usado na ordena��o de inst�ncias da classe
 * Evento, ordenando os o local por ordem alfab�tica.
 * <p>
 * Esta ordena��o � realizada pelo m�todo est�tico sort da classe Collections
 * @author Cleisson Di Lauro
 * @version 1.0;
 */

class ComparaPorNome implements Comparator<ItemAgenda> {
  	public int compare(ItemAgenda evento, ItemAgenda evento1) {
  		//instanceof - verifica se um determinado elemento � de uma determinada subclasse
  		if(evento instanceof Evento && evento1 instanceof Evento) {
  			Evento eventoA= (Evento)evento;
  	  		Evento eventoB= (Evento)evento1;
  	  		return eventoA.getLocal().compareToIgnoreCase(eventoB.getLocal());
  		}else return -90;
  	}
}

