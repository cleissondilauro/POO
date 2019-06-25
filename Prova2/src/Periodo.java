import java.io.Serializable;

/**
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */
public class Periodo implements Serializable{

	
	private Data dataInicio, dataFim;
	private Horario horarioInicio, horarioFim;
	
	/**
	 * Insere uma inst�ncia da classe Per�odo
	 * @param _dataInicio Data do in�cio de um per�odo
	 * @param _dataFim Data do fim de um per�odo
	 * @param _horarioInicio Hor�rio do in�cio do per�odo
	 * @param _horario Fim Hor�rio do fim do per�odo
	 */
	public Periodo(Data _dataInicio,Data _dataFim,Horario _horarioInicio,Horario _horarioFim) {
		this.setPeriodo(_dataInicio, _dataFim, _horarioInicio, _horarioFim);
	}
	/**
	 * Insere uma inst�ncia da classe Per�odo, onde a data de in�cio � a mesma do fim
	 * @param _dataInicio Data do in�cio de um per�odo
	 * @param _horarioInicio Hor�rio do in�cio do per�odo
	 * @param _horario Fim Hor�rio do fim do per�odo
	 */
	public Periodo(Data _dataInicio,Horario _horarioInicio,Horario _horarioFim) {
		this.setPeriodo(_dataInicio, _dataInicio, _horarioInicio, _horarioFim);
	}
	/**
	 * Insere uma inst�ncia da classe Per�odo
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
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
	 */
	public Periodo(int diaIni, int mesIni, int anoIni,int diaFim, int mesFim, int anoFim,int _horaIni,int _minutosIni,int _segundosIni,int _horaFim,int _minutosFim,int _segundosFim) throws Exception {
		this.setDataInicio(new Data(diaIni,mesIni,anoIni));
		this.setDataFim(new Data(diaFim,mesFim,anoFim));
		this.setHorarioInicio(new Horario(_horaIni,_minutosIni,_segundosIni));
		this.setHorarioFim(new Horario(_horaFim,_minutosFim,_segundosFim));
	}
	/**
	 * Insere uma inst�ncia da classe Per�odo
	 * @param _dataInicio Data do in�cio de um per�odo
	 * @param _horarioInicio Hor�rio do in�cio do per�odo
	 * @throws Exception 
	 */
	public Periodo(Data _dataInicio,Data _dataFim) throws Exception {
		this.setPeriodo(_dataInicio, _dataFim, new Horario(0,0), new Horario(0,0));
	}
	/**
	 * @param _dataInicio Data do in�cio de um per�odo
	 * @param _dataFim Data do fim de um per�odo
	 * @param _horarioInicio Hor�rio do in�cio do per�odo
	 * @param _horario Fim Hor�rio do fim do per�odo
	 */
	public void setPeriodo(Data _dataInicio,Data _dataFim,Horario _horarioInicio,Horario _horarioFim) {
		this.dataInicio=_dataInicio;
		this.dataFim=_dataFim;
		this.horarioInicio=_horarioInicio;
		this.horarioFim=_horarioFim;
	}
	/**
	 * @return Um objeto da classe Data, que contem as informa��es: dia, mes,ano
	 */
	public Data getDataInicio() {
		return this.dataInicio;
	}
	/**
	 * @param _dataInicio Um objeto da classe Data, que contem as informa��es: dia, mes,ano 
	 */
	public void setDataInicio(Data _dataInicio) {
		this.dataInicio = _dataInicio;
	}
	/**
	 * @return Um objeto da classe Data, que contem as informa��es: dia, mes,ano
	 */
	public Data getDataFim() {
		return this.dataFim;
	}
	/**
	 * @param _dataFim Um objeto da classe Data, que contem as informa��es: dia, mes,ano 
	 */
	public void setDataFim(Data _dataFim) {
		this.dataFim = _dataFim;
	}
	/**
	 * @return Um objeto da classe Horario, que contem as informa��es: horas,minutos,segundos
	 */
	public Horario getHorarioInicio() {
		return this.horarioInicio;
	}
	/**
	 * @param _horarioInicio Um objeto da classe Horario, que contem as informa��es: horas,minutos,segundos
	 */
	public void setHorarioInicio(Horario _horarioInicio) {
		this.horarioInicio = _horarioInicio;
	}
	/**
	 * @return Um objeto da classe Horario, que contem as informa��es: horas,minutos,segundos
	 */
	public Horario getHorarioFim() {
		return this.horarioFim;
	}
	/**
	 * @param _horarioFim Um objeto da classe Horario, que contem as informa��es: horas,minutos,segundos
	 */
	public void setHorarioFim(Horario _horarioFim) {
		this.horarioFim = _horarioFim;
	}
	
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da classe
	 * Separando os elementos por Data - Hor�rio (X/X/X - X:X:X)
	 * @return retorna um String com todos os dados da classe
	 */
	public String toString() {
		StringBuilder periodo = new StringBuilder();
		periodo.append(this.getDataInicio());
		periodo.append(" - ");
		periodo.append(this.getHorarioInicio());
		periodo.append("\n");
		periodo.append(this.getDataFim());
		periodo.append(" - ");
		periodo.append(this.getHorarioFim());
		return periodo.toString();
	}
	/**
	 * Verifica se um periodo est� no invervalo de uma determinada data
	 * @param periodo Per�odo a ser verificado
	 * @return true para datas dentro do intervalo <p> false para datas fora do intervalo
	 */
	public boolean isDentroIntevalo(Periodo periodo) {
		
		int retornoCompareToInicio,retornoCompareToFim;
		retornoCompareToInicio = this.getDataInicio().compareTo(periodo.dataInicio);
		retornoCompareToFim = this.getDataFim().compareTo(periodo.dataFim);
		
		if( (retornoCompareToInicio ==0 || retornoCompareToInicio == 1) && (retornoCompareToFim == 0 || retornoCompareToFim == -1 ))
			return true;
	
		else return false;
	}
		

}
