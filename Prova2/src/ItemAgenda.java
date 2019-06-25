import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */

public abstract class ItemAgenda implements Comparable<ItemAgenda>, Serializable{
	
	 private String titulo, descricao;
	 private Periodo periodo;
	
	 /**
	 * Insere uma inst�ncia da classe ItemAgenda
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
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
	 */
	 public ItemAgenda(String _titulo,String _descricao,int diaIni, int mesIni, int anoIni,int diaFim, int mesFim, int anoFim,int _horaIni,int _minutosIni,int _segundosIni,int _horaFim,int _minutosFim,int _segundosFim) throws Exception {
		 this.setTitulo(_titulo);
		 this.setDescricao(_descricao);
		 this.setPeriodo(new Periodo(diaIni, mesIni, anoIni, diaFim, mesFim, anoFim, _horaIni, _minutosIni, _segundosIni, _horaFim, _minutosFim, _segundosFim));
	 }
		 
	/**
	 * Insere uma inst�ncia da classe ItemAgenda
	 * @param _titulo Uma String que representa o t�tulo do evento
	 * @param _descricao Uma String que representa a descri��o do evento
	 * @param _periodo Um inst�ncia da classe Periodo
	 */
	 public ItemAgenda(String _titulo,String _descricao, Periodo _periodo) {
		 this.setItemAgenda(_titulo, _descricao, _periodo);
	 }
	 /**
	  * @return titulo
	  */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param _titulo 
	 */
	public void setTitulo(String _titulo) {
		this.titulo = _titulo;
	}
	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}
	/**
	 * @param _descricao 
	 */
	public void setDescricao(String _descricao) {
		this.descricao = _descricao;
	}
	/**
	 * @return Um objeto da classe Periodo, que contem as informa��es: dataInicio, dataFim, horarioInicio, horarioFim
	 */
	public Periodo getPeriodo() {
		return this.periodo;
	}
	/**
	 * @param _periodo Um objeto da classe Periodo, que contem as informa��es: dataInicio, dataFim, horarioInicio, horarioFim
	 */
	public void setPeriodo(Periodo _periodo) {
		this.periodo = _periodo;
	}
	/**
	 * @param _titulo Uma String que representa o t�tulo do evento
	 * @param _descricao Uma String que representa a descri��o do evento
	 * @param _periodo Um inst�ncia da classe Periodo
	 */
	public void setItemAgenda(String _titulo,String _descricao, Periodo _periodo) {
		this.titulo=_titulo;
		this.descricao=_descricao;
		this.periodo=_periodo;
	}
	
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da classe
	 * T�tulo \n Descri��o \n Per�odo
	 * @return retorna um String com todos os dados da classe
	 */
	public String toString() {
		StringBuilder itemAgenda = new StringBuilder();
		itemAgenda.append("\n");
		itemAgenda.append(this.getTitulo());
		itemAgenda.append("\n");
		itemAgenda.append(this.getDescricao());
		itemAgenda.append("\n");
		itemAgenda.append(this.getPeriodo());
		return itemAgenda.toString();
	}
	
	/**
	 * Compara dois objetos do tipo ItemAgenda
	 * @param _o Um objeto do tipo ItemAgenda
	 * @return Retorna 1 para maior <p>  0 para Igual <P>  <p> para menor -1
	 */
	public int compareTo(ItemAgenda _o) {
		return this.getTitulo().compareTo(_o.getTitulo());
	}
	
}




