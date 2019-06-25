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
 * para inclusão de instâncias da classe ItemAgenda
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
	 * Insere uma instância da classe ItemAgenda
	 * @param _objeto objeto a ser incluído da coleção
	 */
	public void insere(ItemAgenda _objeto) {
		this.getAgenda().add(_objeto);
	}
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da coleção
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
	 * Listas todas as instâncias da classe ItemAgenda
	 * 
	 * @param inicio objeto da classe Data
	 * @param Fim objeto da classe Data
	 * 
	 * @throws Exception Caso a data esteja inválida ou o horário
	 */
	public void listaItensAgendadosNoIntervalo(Data inicio, Data Fim) throws Exception{
		Periodo periodo = new Periodo(inicio,Fim);
		for (int i = 0; i < this.getAgenda().size(); i++){
			if(this.getAgenda().get(i).getPeriodo().isDentroIntevalo(periodo))
				this.getAgenda().get(i).toString();
		}
	}
	/**
	 * Listas todas as instâncias da classe ItemAgenda
	 * 
	 * @param diaIni Dia do inicio do período
	 * @param mesIni Mês do inicio do período
	 * @param anoIni Ano do inicio do período
	 * @param diaFim Dia do fim do período
	 * @param mesFim Mês do fim do período
	 * @param anoFim Ano do fim do período
	 * 
	 * @throws Exception Caso a data esteja inválida ou o horário
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
		// o método estático sort da classe Collections necessita
		// 2 argumentos: a coleção que será ordenada,
		// e a forma como ela será ordenada.
		// Existe uma versão sobrecarregada para 1 argumento, neste caso,
		// é usado o método compareTo da classe base
		
		
		Collections.sort(this.getAgenda(), new ComparaPorNome());
		
		//Imprime somente os eventos presentes na coleção
		for (int i = 0; i < this.getAgenda().size(); i++) {
			//verifica se um elemento presente na coleção é Evento
			if(this.getAgenda().get(i) instanceof Evento)
				System.out.println(this.getAgenda().get(i));
		}
	}
	
	/**
	 * Ordena as Metas prioridade
	 */
	public void ordenaPorPrioridade() {
		// o método estático sort da classe Collections necessita
		// 2 argumentos: a coleção que será ordenada,
		// e a forma como ela será ordenada.
		// Existe uma versão sobrecarregada para 1 argumento, neste caso,
		// é usado o método compareTo da classe base
		
		// Teoricamente isso deveria funcionar prefeitamente mas não funciona 
		
		/*
		Collections.sort(this.getAgenda(), new ComparaPorPrioridade());

		//Imprime somente os eventos presentes na coleção
		for (int i = 0; i < this.getAgenda().size(); i++) {
			//verifica se um elemento presente na coleção é Evento
			if(this.getAgenda().get(i) instanceof Meta)
				System.out.println(this.getAgenda().get(i));
		}
		*/
		// então criei uma lista auxiliar para realizar os relatório  
		
		List<Meta> agendaMeta = new LinkedList<Meta>();
		
		//Imprime somente os eventos presentes na coleção
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if(this.getAgenda().get(i) instanceof Meta)
				agendaMeta.add((Meta) this.getAgenda().get(i));
		}	
		Collections.sort(agendaMeta, new ComparaPorPrioridade());
		//Imprime somente os eventos presentes na coleção
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
		// o método estático sort da classe Collections necessita
		// 2 argumentos: a coleção que será ordenada,
		// e a forma como ela será ordenada.
		// Existe uma versão sobrecarregada para 1 argumento, neste caso,
		// é usado o método compareTo da classe base
		
	
		// Teoricamente isso deveria funcionar prefeitamente mas não funciona 
	
		 
		//Collections.sort(this.getAgenda(), new ComparaPorAntecedencia());
		/*
		//Imprime somente os eventos presentes na coleção
		for (int i = 0; i < this.getAgenda().size(); i++) {
			if(this.getAgenda().get(i) instanceof Lembrete)
				System.out.println(this.getAgenda().get(i));
		}
		*/
		
		// então criei uma lista auxiliar para realizar os relatório  
		
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
	 * Realiza gravação de um objeto no disco
	 * @param _nomeArquivo nome do arquivo que será criado na gravação
	 * @param _objeto instância que será gravada no arquivo
	 * @exception IOException problemas na criação do arquivo ou gravação
	 */
	static public void grava(String _nomeArquivo, Object _objeto) throws IOException {
		ObjectOutputStream buffer = new ObjectOutputStream(new FileOutputStream(_nomeArquivo));
		buffer.writeObject(_objeto);
		buffer.close();
	}
	
	/**
	 * Realiza leitura de um objeto no arquivo
	 * @param _nomeArquivo nome do arquivo a ser lido
	 * @return retorna uma instância da classe Object lida do arquivo
	 * @exception IOException problemas na leitura do arquivo
	 * @exception ClassNotFoundException problemas na conversão do objeto lido
	 */
	static public Object le(String _nomeArquivo) throws IOException, ClassNotFoundException  {
		ObjectInputStream buffer = new ObjectInputStream(new FileInputStream(_nomeArquivo));
		Object _objeto = buffer.readObject(); 
		buffer.close();
		return _objeto;
	}

	
}
