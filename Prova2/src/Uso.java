import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Uso {
	
	public static void main(String[] args) throws Exception{

	
		int i=-1,j=-1,prioridade,qtdeMinutos,opc;
		String titulo="", descricao="",dataInicio,dataFim,horarioInicio,horarioFim,local,_nomeArquivo = null;
		Periodo periodo = null; 
		Agenda agenda = new Agenda();
		Scanner lerTeclado = new Scanner(System.in);
	
		System.out.println(" 1 - Carregar itens de uma agenda existente");
		System.out.println(" 2 - Criar uma nova agenda");
		opc = lerTeclado.nextInt();
		
		if(opc == 1) {
			System.out.print("Informe o nome do arquivo:");
			String lixo=lerTeclado.nextLine();	
			_nomeArquivo=lerTeclado.nextLine();			
			agenda =  (Agenda) Agenda.le(_nomeArquivo);
					
		}
		
		do{
			System.out.println("*\t--  Agenda  --\t   *");
			System.out.println("  1 - Criar Evento");
			System.out.println("  2 - Criar Lembrete");
			System.out.println("  3 - Criar Meta");
			System.out.println("  4 - Carregar uma agenda existente");
			System.out.println("  5 - Vizualizar");
			System.out.println("  6 - Salvar e Sair");
			 
			i = lerTeclado.nextInt();
			try {
				if(i!=5 && i!=6) {
					 String lixo=lerTeclado.nextLine();
					 System.out.print("Informe o Título: ");
					 titulo=lerTeclado.nextLine();
					 System.out.print("Informe a descrição: ");
					 descricao=lerTeclado.nextLine();
					 
					 System.out.print("Informe a data de início no formato (dia/Mês/Ano:) ");
					 dataInicio=lerTeclado.nextLine();
					 System.out.print("Informe o horário de início no formato (hora:Minutos:Segundos): ");
					 horarioInicio=lerTeclado.nextLine();
					 
					 System.out.print("Informe a data de fim no formato (dia/Mês/Ano): ");
					 dataFim=lerTeclado.nextLine();
					 System.out.print("Informe o horário de início no formato (hora:Minutos:Segundos): ");
					 horarioFim=lerTeclado.nextLine();
					 periodo = new Periodo(new Data(dataInicio), new Data(dataFim), new Horario(horarioInicio), new Horario(horarioFim));
				}
			
				switch(i) {
					case 1:
						System.out.print("Informe o local: ");
						local=lerTeclado.nextLine();
						agenda.insere(new Evento(titulo, descricao, periodo, local));
						break;
					case 2:
						System.out.print("Alerta em quantos minutos: ");
						qtdeMinutos=lerTeclado.nextInt();
						agenda.insere(new Lembrete(titulo, descricao, periodo,qtdeMinutos));
						break;
					case 3:
						System.out.print("Qual a prioridade:\n 0 - URGENTE\n 1 - ALTA\n 2 - NORMAL\n 3 - BAIXA\n 4 - MINIMA\n Prioridade:");
						prioridade = lerTeclado.nextInt();
						agenda.insere(new Meta(titulo, descricao, periodo, prioridade));
						break;
					case 5:
						// todos os itens agendados =  toString OK--
						//todos os itens agendados em um intervalo de datas  OK --
						// todas as metas em ordem de prioridade --
						// todos os lembretes em ordem de minutos de antecedência, --
						//todos os eventos em ordem alfabética de local OK --
						do {
							System.out.println("*\t--  Vizualizar  --\t   *");
							System.out.println("  1 - Eventos por ordem alfabética");
							System.out.println("  2 - Lembretes por ordem de antecedência");
							System.out.println("  3 - Meta em ordem de prioridade");
							System.out.println("  4 - Vizualizar toda agenda");
							System.out.println("  5 - Vizualizar toda agenda em um intervalo de datas");
							System.out.println("  6 - Voltar o menu anterior");
							j = lerTeclado.nextInt();
							
							switch(j) {
								case 1:
									agenda.ordenaPorLocal();
									break;
								case 2:
									agenda.ordenaLembretesPorAntecedencia();
									break;
								case 3:
									agenda.ordenaPorPrioridade();
									break;
								case 4:
									System.out.print(agenda);
									break;
								case 5:
									String lixo=lerTeclado.nextLine();
									 System.out.print("Informe a data de início no formato (dia/Mês/Ano:) ");
									 dataInicio=lerTeclado.nextLine();
									 System.out.print("Informe a data de fim no formato (dia/Mês/Ano): ");
									 dataFim=lerTeclado.nextLine();
									 agenda.listaItensAgendadosNoIntervalo(new Data(dataInicio),new Data(dataFim));
									 break;
							}
						}while(j!=6);			
						break;
				}
			}catch (Exception e) {
				System.out.println("\n\nErro ao inserir as informações\n\n");
			}
			

		}while(i!=6);
		//caso a agenda já exista
		if(opc==1) {
			Agenda.grava(_nomeArquivo, agenda);
		}
		//Criando um novo arquivo
		else {
			System.out.print("Informe o nome do arquivo ");
			String lixo=lerTeclado.nextLine();
			_nomeArquivo=lerTeclado.nextLine();
			Agenda.grava(_nomeArquivo, agenda);
		}
	}	
	
}