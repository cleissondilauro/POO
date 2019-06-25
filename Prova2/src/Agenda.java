import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Encapsula a classe LinkedList facilitando o seu uso 
 * para inclus�o de inst�ncias da classe ItemAgenda
 *
 * @author Cleisson Di Lauro
 * @version 1.0 (Junho-2019)
 */

public class Agenda implements Serializable {
	
	private List<ItemAgenda> agenda;

	Agenda() {
		agenda = new LinkedList<ItemAgenda>();
	}
	
	/**
	 * Insere uma inst�ncia da classe ItemAgenda
	 * @param _objeto objeto a ser inclu�do da cole��o
	 */
	public void insere(ItemAgenda _objeto) {
		this.getAgenda().add(_objeto);
	}
	/**
	 * Sobreposi��o do m�todo toString para retornar todo o conte�do da cole��o
	 * @return retorna uma String com todos os dados
	 */
	public String toString() {
		StringBuilder agenda = new StringBuilder();
		for (int i = 0; i < this.getAgenda().size(); i++) {
			agenda.append("\n");
			agenda.append(this.agenda.get(i));
		}
		return agenda.toString();
	}
	
	/**
	 * @return agenda
	 */
	public List<ItemAgenda> getAgenda() {
		return this.agenda;
	}
	/**
	 * @param _agenda 
	 */
	public void setAgenda(List<ItemAgenda> _agenda) {
		this.agenda = _agenda;
	}
	
	/**
	 * Listas todas as inst�ncias da classe ItemAgenda
	 * 
	 * @param inicio objeto da classe Data
	 * @param Fim objeto da classe Data
	 * 
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
	 */
	public void listaItensAgendadosNoIntervalo(Data inicio, Data Fim) throws Exception{
		Periodo periodo = new Periodo(inicio,Fim);
		for (int i = 0; i < this.getAgenda().size(); i++){
			if(this.getAgenda().get(i).getPeriodo().isDentroIntevalo(periodo))
				this.getAgenda().get(i).toString();
		}
	}
	/**
	 * Listas todas as inst�ncias da classe ItemAgenda
	 * 
	 * @param diaIni Dia do inicio do per�odo
	 * @param mesIni M�s do inicio do per�odo
	 * @param anoIni Ano do inicio do per�odo
	 * @param diaFim Dia do fim do per�odo
	 * @param mesFim M�s do fim do per�odo
	 * @param anoFim Ano do fim do per�odo
	 * 
	 * @throws Exception Caso a data esteja inv�lida ou o hor�rio
	 */
	public void listaItensAgendadosNoIntervalo(int diaIni, int mesIni, int anoIni,int diaFim, int mesFim, int anoFim) throws Exception{
		Periodo periodo = new Periodo(new Data(diaIni,mesIni,anoIni),new Data(diaFim,mesFim,anoFim));
		for (int i = 0; i < this.getAgenda().size(); i++){
			if(this.getAgenda().get(i).getPeriodo().isDentroIntevalo(periodo) )
				System.out.println(this.getAgenda().get(i));
		}
	
	}
	
	/**
	 * Ordena os eventos em ordem alfabetica pelo nome do local
	 */
	public void ordenaPorLocal() {
		// o m�todo est�tico sort da classe Collections necessita
		// 2 argumentos: a cole��o que ser� ordenada,
		// e a forma como ela ser� ordenada.
		// Existe uma vers�o sobrecarregada para 1 argumento, neste caso,
		// � usado o m�todo compareTo da classe base
		
		
		Collections.sort(this.getAgenda(), new ComparaPorNome());
		
		//Imprime somente os eventos presentes na cole��o
		for (int i = 0; i < this.getAgenda().size(); i++) {
			//verifica se um elemento presente na cole��o � Evento
			if(this.getAgenda().get(i) instanceof Evento)
				System.out.println(this.getAgenda().get(i));
		}
	}
	
	/**
	 * Ordena as Metas prioridade
	 */
	public void ordenaPorPrioridade() {
		// o m�todo est�tico sort da classe Collections necessita
		// 2 argumentos: a cole��o que ser� ordenada,
		// e a forma como ela ser� ordenada.
		// Existe uma vers�o sobrecarregada para 1 argumento, neste caso,
		// � usado o m�todo compareTo da classe base
		
		// Teoricamente isso deveria funcionar prefeitamente mas n�o funciona 
		
		/*
		Collections.sort(this.getAgenda(), new ComparaPorPrioridade());

		//Imprime somente os eventos presentes na cole��o
		for (int i = 0; i < this.getAgenda().size(); i++) {
			//verifica se um elemento presente na cole��o � Evento
			if(this.getAgenda().get(i) instanceof Meta)
				System.out.println(this.getAgenda().get(i));
		}
		*/
		// ent�o criei uma lista auxiliar para realizar os relat�rio  
		
		List<Meta> agendaMeta = new LinkedList<Meta>();
		
		//Imprime somente os eventos presentes na cole��o
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if(this.getAgenda().get(i) instanceof Meta)
				agendaMeta.add((Meta) this.getAgenda().get(i));
		}	
		Collections.sort(agendaMeta, new ComparaPorPrioridade());
		//Imprime somente os eventos presentes na cole��o
		for (int i = 0; i < agendaMeta.size(); i++) {
			if(agendaMeta.get(i) instanceof Meta)
				System.out.println(agendaMeta.get(i));
		}
		agendaMeta.removeAll(agendaMeta);
	}
	
	/**
	 * Ordena os lembretes por antes de antedencia
	 */
	public void ordenaLembretesPorAntecedencia() {
		// o m�todo est�tico sort da classe Collections necessita
		// 2 argumentos: a cole��o que ser� ordenada,
		// e a forma como ela ser� ordenada.
		// Existe uma vers�o sobrecarregada para 1 argumento, neste caso,
		// � usado o m�todo compareTo da classe base
		
	
		// Teoricamente isso deveria funcionar prefeitamente mas n�o funciona 
	
		 
		//Collections.sort(this.getAgenda(), new ComparaPorAntecedencia());
		/*
		//Imprime somente os eventos presentes na cole��o
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if(this.getAgenda().get(i) instanceof Lembrete)
				System.out.println(this.getAgenda().get(i));
		}
		*/
		
		// ent�o criei uma lista auxiliar para realizar os relat�rio  
		
		List<Lembrete> agendalembre = new LinkedList<Lembrete>();
		
		//adiciona os elementos do tipo Lembrete a lista auxiliar 
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if(this.getAgenda().get(i) instanceof Lembrete)
				agendalembre.add((Lembrete) this.getAgenda().get(i));
		}	
		//ordena 
		Collections.sort(agendalembre, new ComparaPorAntecedencia());
		//Imprime os lembretes ordenados
		for (int i = 0; i < agendalembre.size(); i++) {
			if(agendalembre.get(i) instanceof Lembrete) {
				System.out.println(agendalembre.get(i));
			}
		}
		agendalembre.removeAll(agendalembre);

	}
	
	/**
	 * Realiza grava��o de um objeto no disco
	 * @param _nomeArquivo nome do arquivo que ser� criado na grava��o
	 * @param _objeto inst�ncia que ser� gravada no arquivo
	 * @exception IOException problemas na cria��o do arquivo ou grava��o
	 */
	static public void grava(String _nomeArquivo, Object _objeto) throws IOException {
		ObjectOutputStream buffer = new ObjectOutputStream(new FileOutputStream(_nomeArquivo));
		buffer.writeObject(_objeto);
		buffer.close();
	}
	
	/**
	 * Realiza leitura de um objeto no arquivo
	 * @param _nomeArquivo nome do arquivo a ser lido
	 * @return retorna uma inst�ncia da classe Object lida do arquivo
	 * @exception IOException problemas na leitura do arquivo
	 * @exception ClassNotFoundException problemas na convers�o do objeto lido
	 */
	static public Object le(String _nomeArquivo) throws IOException, ClassNotFoundException  {
		ObjectInputStream buffer = new ObjectInputStream(new FileInputStream(_nomeArquivo));
		Object _objeto = buffer.readObject(); 
		buffer.close();
		return _objeto;
	}

	
}
