import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */
public class Meta extends ItemAgenda{
	
	private Prioridade prioridade;
	
	/**
	 * Insere uma instância da classe Meta
	 * @param _titulo Uma String que representa o título do evento
	 * @param _descricao Uma String que representa a descrição do evento
	 * @param _periodo Um instância da classe Periodo
	 * @param _prioridade Da classe enum Prioridade
	 */
	public Meta(String _titulo, String _descricao, Periodo _periodo, int _prioridade) {
		super(_titulo, _descricao, _periodo);
		this.setPrioridade(_prioridade);
	}
	
	 /**
	 * Insere uma instância da classe Meta
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
	 * @param _prioridade Da classe enum Prioridade
	 * 
	 * @throws Exception Caso a data esteja inválida ou o horário
	 */
	public Meta(String _titulo, String _descricao, int diaIni, int mesIni, int anoIni, int diaFim, int mesFim,
			int anoFim, int _horaIni, int _minutosIni, int _segundosIni, int _horaFim, int _minutosFim,
			int _segundosFim, int _prioridade ) throws Exception {
		
		super(_titulo, _descricao, diaIni, mesIni, anoIni, diaFim, mesFim, anoFim, _horaIni, _minutosIni, _segundosIni,
				_horaFim, _minutosFim, _segundosFim);
		this.setPrioridade(_prioridade);
	}
	
	 /**
	  * @return prioridade
	  */
	public Prioridade getPrioridade() {
		return this.prioridade;
	}
	/**
	 * @param _prioridade 
	 */
	public void setPrioridade(int _prioridade) {
		switch(_prioridade)
		{
		case 0: this.prioridade = Prioridade.URGENTE; break;
		case 1: this.prioridade = Prioridade.ALTA; break;
		case 2: this.prioridade = Prioridade.NORMAL; break;
		case 3: this.prioridade = Prioridade.BAIXA; break;
		default: this.prioridade = Prioridade.MINIMA; break;
		}
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
		meta.append(this.getPrioridade());
		return meta.toString();
	}
	
	/**
	 * Compara duas instacias da classe Data
	 * @param data objeto a ser comparado
	 * @return 0 para objetos iguais; <p> 1 para objetos menores;<p> -1 para objetos maiores.
	 */
	public int compareTo(Meta metaA) {
		return this.getPrioridade().compareTo(metaA.prioridade);
		// return  this.getPrioridade().equals(metaA);
	}
}

/**
 * Fornece um método para ser usado na ordenação de instâncias da classe
 * Meta, ordenando os elementos por prioridade 
 * <p>
 * Esta ordenação é realizada pelo método estático sort da classe Collections
 * @author Cleisson Di Lauro
 * @version 1.0;
 */
class ComparaPorPrioridade implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda meta, ItemAgenda meta1) {
		
		//instanceof verifica se um determinado elemento é de uma determinada subclasse
		if(meta instanceof Meta && meta1 instanceof Meta) {
			Meta metaA= (Meta)meta;
			Meta metaB= (Meta)meta1;
			//quanto menor o indice maior a prioridade. 0= urgente, 1 = alta, 2 = normal ...		
			if(metaA.getPrioridade().ordinal() > metaB.getPrioridade().ordinal()) {
				return 1;	
			}
			else {
				if(metaA.getPrioridade().ordinal() < metaB.getPrioridade().ordinal()) {
					return -1;
				}
				else return 0;
			}
		}else return -90;
	}
}
