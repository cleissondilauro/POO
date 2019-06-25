import java.io.Serializable;

/**
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */
public class Periodo implements Serializable{

	
	private Data dataInicio, dataFim;
	private Horario horarioInicio, horarioFim;
	
	/**
	 * Insere uma instância da classe Período
	 * @param _dataInicio Data do início de um período
	 * @param _dataFim Data do fim de um período
	 * @param _horarioInicio Horário do início do período
	 * @param _horario Fim Horário do fim do período
	 */
	public Periodo(Data _dataInicio,Data _dataFim,Horario _horarioInicio,Horario _horarioFim) {
		this.setPeriodo(_dataInicio, _dataFim, _horarioInicio, _horarioFim);
	}
	/**
	 * Insere uma instância da classe Período, onde a data de início é a mesma do fim
	 * @param _dataInicio Data do início de um período
	 * @param _horarioInicio Horário do início do período
	 * @param _horario Fim Horário do fim do período
	 */
	public Periodo(Data _dataInicio,Horario _horarioInicio,Horario _horarioFim) {
		this.setPeriodo(_dataInicio, _dataInicio, _horarioInicio, _horarioFim);
	}
	/**
	 * Insere uma instância da classe Período
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
	 * @throws Exception Caso a data esteja inválida ou o horário
	 */
	public Periodo(int diaIni, int mesIni, int anoIni,int diaFim, int mesFim, int anoFim,int _horaIni,int _minutosIni,int _segundosIni,int _horaFim,int _minutosFim,int _segundosFim) throws Exception {
		this.setDataInicio(new Data(diaIni,mesIni,anoIni));
		this.setDataFim(new Data(diaFim,mesFim,anoFim));
		this.setHorarioInicio(new Horario(_horaIni,_minutosIni,_segundosIni));
		this.setHorarioFim(new Horario(_horaFim,_minutosFim,_segundosFim));
	}
	/**
	 * Insere uma instância da classe Período
	 * @param _dataInicio Data do início de um período
	 * @param _horarioInicio Horário do início do período
	 * @throws Exception 
	 */
	public Periodo(Data _dataInicio,Data _dataFim) throws Exception {
		this.setPeriodo(_dataInicio, _dataFim, new Horario(0,0), new Horario(0,0));
	}
	/**
	 * @param _dataInicio Data do início de um período
	 * @param _dataFim Data do fim de um período
	 * @param _horarioInicio Horário do início do período
	 * @param _horario Fim Horário do fim do período
	 */
	public void setPeriodo(Data _dataInicio,Data _dataFim,Horario _horarioInicio,Horario _horarioFim) {
		this.dataInicio=_dataInicio;
		this.dataFim=_dataFim;
		this.horarioInicio=_horarioInicio;
		this.horarioFim=_horarioFim;
	}
	/**
	 * @return Um objeto da classe Data, que contem as informações: dia, mes,ano
	 */
	public Data getDataInicio() {
		return this.dataInicio;
	}
	/**
	 * @param _dataInicio Um objeto da classe Data, que contem as informações: dia, mes,ano 
	 */
	public void setDataInicio(Data _dataInicio) {
		this.dataInicio = _dataInicio;
	}
	/**
	 * @return Um objeto da classe Data, que contem as informações: dia, mes,ano
	 */
	public Data getDataFim() {
		return this.dataFim;
	}
	/**
	 * @param _dataFim Um objeto da classe Data, que contem as informações: dia, mes,ano 
	 */
	public void setDataFim(Data _dataFim) {
		this.dataFim = _dataFim;
	}
	/**
	 * @return Um objeto da classe Horario, que contem as informações: horas,minutos,segundos
	 */
	public Horario getHorarioInicio() {
		return this.horarioInicio;
	}
	/**
	 * @param _horarioInicio Um objeto da classe Horario, que contem as informações: horas,minutos,segundos
	 */
	public void setHorarioInicio(Horario _horarioInicio) {
		this.horarioInicio = _horarioInicio;
	}
	/**
	 * @return Um objeto da classe Horario, que contem as informações: horas,minutos,segundos
	 */
	public Horario getHorarioFim() {
		return this.horarioFim;
	}
	/**
	 * @param _horarioFim Um objeto da classe Horario, que contem as informações: horas,minutos,segundos
	 */
	public void setHorarioFim(Horario _horarioFim) {
		this.horarioFim = _horarioFim;
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da classe
	 * Separando os elementos por Data - Horário (X/X/X - X:X:X)
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
	 * Verifica se um periodo está no invervalo de uma determinada data
	 * @param periodo Período a ser verificado
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
