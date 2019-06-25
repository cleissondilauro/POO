import java.io.Serializable;
import java.util.Comparator;

public class Evento extends ItemAgenda{

	private String local;
	/**
	 * Insere uma instância da classe Evento
	 * @param _titulo Uma String que representa o título do evento
	 * @param _descricao Uma String que representa a descrição do evento
	 * @param _periodo Um instância da classe Periodo
	 * @param _local Uma String que representa o local do evento
	 */
	public Evento(String _titulo, String _descricao, Periodo _periodo,String _local) {
		super(_titulo, _descricao, _periodo);
		this.setLocal(_local);
	}
	 /**
	 * Insere uma instância da classe Evento
	 * @param _titulo Uma String que representa o título do evento
	 * @param _descricao Uma String que representa a descrição do evento
	 *  
	 * @param diaIni Dia do inicio do período
	 * @param mesIni Mês do inicio do período
	 * @param anoIni Ano do inicio do período
	 * 
	 * @param _horaIni Horário de início 
	 * @param _minutosIni Minutos do início
	 * @param _segundosIni Minutos do início
	 * 
	 * @param diaFim Dia do fim do período
	 * @param mesFim Mês do fim do período
	 * @param anoFim Ano do fim do período
	 * 
	 * @param _horaFim Horário de fim 
	 * @param _minutosFim Minutos do fim
	 * @param _segundosFim Minutos do fim
	 * 
	 * @param _local Uma String que representa o local do evento
	 * 
	 * @throws Exception Caso a data esteja inválida ou o horário
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
	 * Sobreposição do método toString para retornar todo o conteúdo da classe
	 * Título \n Descrição \n Período \n Prioridade
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
 * Fornece um método para ser usado na ordenação de instâncias da classe
 * Evento, ordenando os o local por ordem alfabética.
 * <p>
 * Esta ordenação é realizada pelo método estático sort da classe Collections
 * @author Cleisson Di Lauro
 * @version 1.0;
 */

class ComparaPorNome implements Comparator<ItemAgenda> {
  	public int compare(ItemAgenda evento, ItemAgenda evento1) {
  		//instanceof - verifica se um determinado elemento é de uma determinada subclasse
  		if(evento instanceof Evento && evento1 instanceof Evento) {
  			Evento eventoA= (Evento)evento;
  	  		Evento eventoB= (Evento)evento1;
  	  		return eventoA.getLocal().compareToIgnoreCase(eventoB.getLocal());
  		}else return -90;
  	}
}

