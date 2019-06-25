import java.util.Comparator;

public class Lembrete extends ItemAgenda{

	private double qtdeMinutosParaAlerta;
	/**
	 * Insere uma inst�ncia da classe Lembrete
	 * @param _titulo Uma String que representa o t�tulo do evento
	 * @param _descricao Uma String que representa a descri��o do evento
	 * @param _periodo Um inst�ncia da classe Periodo
	 * @param _qtdeMinutos Minutos para o alerta
	 * @throws Exception Caso alguma informa��o esteja incorreta
	 */
	public Lembrete(String _titulo, String _descricao, Periodo _periodo, int _qtdeMinutos) throws Exception {
		super(_titulo, _descricao, _periodo);
		this.setQtdeMinutosParaAlerta(_qtdeMinutos);

	}
	 /**
	 * Insere uma inst�ncia da classe Lembrete
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
	 * @param _qtdeMinutos
	 * 
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
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
	 * @throws Exception Exception Caso alguma informa��o esteja incorreta
	 */
	public void setQtdeMinutosParaAlerta(double _qtdeMinutosParaAlerta) throws Exception {
		if(_qtdeMinutosParaAlerta>=0 && _qtdeMinutosParaAlerta<60)
			this.qtdeMinutosParaAlerta = _qtdeMinutosParaAlerta;
		else
			throw new Exception("nota invalida");
	}
	
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da classe
	 * T�tulo \n Descri��o \n Per�odo \n Prioridade
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
 * Fornece um m�todo para ser usado na ordena��o de inst�ncias da classe
 * Lembrete, ordenando os elementos por anteced�ncia 
 * <p>
 * Esta ordena��o � realizada pelo m�todo est�tico sort da classe Collections
 * @author Cleisson Di Lauro
 * @version 1.0;
 */
class ComparaPorAntecedencia implements Comparator<ItemAgenda> {
	public int compare(ItemAgenda lembrete01, ItemAgenda lembrete1) {
		//instanceof - verifica se um determinado elemento � de uma determinada subclasse
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