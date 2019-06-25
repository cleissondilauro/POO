import java.util.Comparator;

public class Lembrete extends ItemAgenda{

	private double qtdeMinutosParaAlerta;
	/**
	 * Insere uma instância da classe Lembrete
	 * @param _titulo Uma String que representa o título do evento
	 * @param _descricao Uma String que representa a descrição do evento
	 * @param _periodo Um instância da classe Periodo
	 * @param _qtdeMinutos Minutos para o alerta
	 * @throws Exception Caso alguma informação esteja incorreta
	 */
	public Lembrete(String _titulo, String _descricao, Periodo _periodo, int _qtdeMinutos) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.setQtdeMinutosParaAlerta(_qtdeMinutos);

	}
	 /**
	 * Insere uma instância da classe Lembrete
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
	 * @param _qtdeMinutos
	 * 
	 * @throws Exception Caso a data esteja inválida ou o horário
	 */
	public Lembrete(String _titulo, String _descricao, int diaIni, int mesIni, int anoIni, int diaFim, int mesFim,
			int anoFim, int _horaIni, int _minutosIni, int _segundosIni, int _horaFim, int _minutosFim,
			int _segundosFim, int _qtdeMinutos) throws Exception {
		super(_titulo, _descricao, diaIni, mesIni, anoIni, diaFim, mesFim, anoFim, _horaIni, _minutosIni, _segundosIni,
				_horaFim, _minutosFim, _segundosFim);
		this.setQtdeMinutosParaAlerta(_qtdeMinutos);
	}
	
	/**
	  * @return qtdeMinutosParaAlerta
	  */
	public double getQtdeMinutosParaAlerta() {
		return qtdeMinutosParaAlerta;
	}
	/**
	 * @param _qtdeMinutosParaAlerta 
	 * @throws Exception Exception Caso alguma informação esteja incorreta
	 */
	public void setQtdeMinutosParaAlerta(double _qtdeMinutosParaAlerta) throws Exception {
		if(_qtdeMinutosParaAlerta>=0 && _qtdeMinutosParaAlerta<60)
			this.qtdeMinutosParaAlerta = _qtdeMinutosParaAlerta;
		else
			throw new Exception("nota invalida");
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da classe
	 * Título \n Descrição \n Período \n Prioridade
	 * @return retorna um String com todos os dados da classe
	 */
	public String toString() {
		StringBuilder lembrete = new StringBuilder();
		lembrete.append(super.toString());
		lembrete.append("\n");
		lembrete.append(this.getQtdeMinutosParaAlerta());
		return lembrete.toString();
	}

}
/**
 * Fornece um método para ser usado na ordenação de instâncias da classe
 * Lembrete, ordenando os elementos por antecedência 
 * <p>
 * Esta ordenação é realizada pelo método estático sort da classe Collections
 * @author Cleisson Di Lauro
 * @version 1.0;
 */
class ComparaPorAntecedencia implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda lembrete01, ItemAgenda lembrete1) {
		//instanceof - verifica se um determinado elemento é de uma determinada subclasse
		if(lembrete01 instanceof Lembrete && lembrete1 instanceof Lembrete) {
			Lembrete lembreteA= (Lembrete)lembrete01;
			Lembrete lembreteB= (Lembrete)lembrete1;

			if (lembreteA.getQtdeMinutosParaAlerta() > lembreteB.getQtdeMinutosParaAlerta())
				return 1;
			else { 
				if (lembreteA.getQtdeMinutosParaAlerta() < lembreteB.getQtdeMinutosParaAlerta())
					return -1;
				else
					return 0;
			}
		}else return -90;	
	}
}