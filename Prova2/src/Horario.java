import java.io.Serializable;

/**
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */
public class Horario implements Serializable{
	
	private int horas,minutos,segundos;
	
	/**
	 * Insere uma instância da classe Horario
	 * @param _hora
	 * @param _minutos 
	 * @param _segundos
	 */
	public Horario(int _hora,int _minutos,int _segundos) throws Exception {
		this.setHorario(_hora, _minutos, _segundos);
	}
	/**
	 * Insere uma instância da classe Horario
	 * @param _hora
	 * @param _minutos 
	 */
	public Horario(int _hora,int _minutos) throws Exception {
		this.setHorario(_hora, _minutos, 0);
	}
	/**
	 * Insere uma instância da classe Horario
	 * @param recebe uma data em formato de string
	 */
	public Horario(String horario)throws Exception{

		int hora=Integer.parseInt(horario.substring(0,2));
		int min=Integer.parseInt(horario.substring(3,5));
		int seg=Integer.parseInt(horario.substring(6,8));
		this.setHorario(hora, min, seg);
	}
	/**
	 * Insere uma instância da classe Horario
	 */
	public Horario() throws Exception {
		this.setHorario(0,0,0);
	}
	
	/**
	 * Verifica se um horário é valido
	 * @param _hora
	 * @param _minutos 
	 * @param _segundos 
	 * @return true para horário válido <p> false para horário inválido 
	 */
	public static boolean isHorarioValido(int _hora,int _minutos, int _segundos) {
		if( (_hora >=0 && _hora <24) && (_minutos>=0 && _minutos<60) && (_segundos>=0 && _segundos<60))
				return true;
		else
			return false;
	}
	/**
	 * Atribui valores para os campo privados: horas, minutos, segundos
	 * @param _hora
	 * @param _minutos 
	 * @param _segundos 
	 * @throws Exception Caso a data seja inválida
	 */
	public void setHorario(int _hora,int _minutos, int _segundos) throws Exception {
		if(Horario.isHorarioValido(_hora, _minutos, _segundos)){
			this.horas=_hora;
			this.minutos=_minutos;
			this.segundos=_segundos;
		}else
			throw new Exception("nota invalida");
	}
	/**
	 * @return horas
	 */
	public int getHora() {
		return this.horas;
	}
	/**
	 * @param _hora 
	 */
	public void setHora(int _hora) {
		this.horas = _hora;
	}
	
	/**
	 * @return minutos
	 */
	public int getMinutos() {
		return this.minutos;
	}
	/**
	 * @param _minutos 
	 */
	public void setMinutos(int _minutos) {
		this.minutos = _minutos;
	}
	
	/**
	 * @return segundos
	 */
	public int getSegundos() {
		return this.segundos;
	}
	/**
	 * @param _segundos 
	 */
	public void setSegundos(int _segundos) {
		this.segundos = _segundos;
	}
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da classe
	 * Separando os elementos por dois pontos(X:X:X)
	 * @return retorna um String com todos os dados da classe
	 */
	public String toString() {
		StringBuilder horario = new StringBuilder();
		horario.append(this.getHora());
		horario.append(":");
		horario.append(this.getMinutos());
		horario.append(":");
		horario.append(this.getSegundos());
		return horario.toString();
	}
	
}
