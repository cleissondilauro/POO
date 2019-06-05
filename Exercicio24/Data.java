package exer24;

public class Data {

	private int dia, mes,ano;

	/**
	 * Insere uma instância da classe Data
	 *
	 * @param recebe dois inteiros mes e o ano
	 */
	public Data(int mes, int ano)throws Exception{
		this.setData(01, mes, ano);
	}

	/**
	 * Insere uma instância da classe Data
	 *
	 * @param recebe três inteiros dia, mes e o ano 
	 */
	public Data(int dia, int mes, int ano)throws Exception{
		this.setData(dia, mes, ano);
	}
	
	/**
	 * Insere uma instância da classe Data
	 *
	 * @param recebe uma instacia da classe data
	 */
	public Data(Data _data)throws Exception{

		this.setData(_data.dia, _data.mes, _data.ano);
	}
	/**
	 * Insere uma instância da classe Data
	 *
	 * @param recebe uma data em formato de string
	 */
	public Data(String data)throws Exception{

		int dia=Integer.parseInt(data.substring(0,2));
		int mes=Integer.parseInt(data.substring(3,5));
		int ano=Integer.parseInt(data.substring(6,10));
		this.setData(dia, mes, ano);
	}
	/**
	 * Insere uma instância da classe Data
	 *
	 * @param dia inteiro
	 * @param mes string
	 * @param ano inteiro 
	 */
	public Data(int dia, String mes, int ano)throws Exception
	{
		int mesInt=0;
		switch(mes)
		{
		case "janeiro": mesInt=1; break;
		case "fevereiro": mesInt=2; break;
		case "março": mesInt=3; break;
		case "abril": mesInt=4; break;
		case "maio": mesInt=5; break;
		case "junho": mesInt=6; break;
		case "julho": mesInt=7; break;
		case "agosto": mesInt=8; break;
		case "setembro": mesInt=9; break;
		case "outubro": mesInt=10; break;
		case "novembro": mesInt=11; break;
		case "dezembro": mesInt=12; break;				
		}

		this.setData(dia, mesInt, ano);
	}
	/**
	 * Insere uma instância da classe Data
	 */
	public Data()throws Exception{
		this.setData(1, 1, 1900);
	}

	public void setData(int dia, int mes, int ano )throws Exception
	{
		//verificar se a data é valida
		if(Data.isDataValida(dia, mes, ano))
		{
			this.ano=ano;
			this.dia=dia;
			this.mes=mes;
		}else
			throw new Exception("nota invalida");

	}

	/**
	 * Verifica se um ano é bissexto
	 * @param ano inteiro
	 * @return true para ano bissexto
	 * @return false para um ano que não seja bissexto
	 */
	public static boolean isBissexto(int ano) {

		if(ano%4==0 && ano%100!=0 && ano%400 == 0) {

			return true;
		}
		else{
			return false;
		}
	}


	/**
	 * Verifica se uma data é valida
	 * @param três inteiros dia, mes e ano
	 * @return true para data Válida
	 * @return false para data Inválida   
	 */
	public static boolean isDataValida(int dia, int mes, int ano){

		if( (ano >= 1582 && mes <=12 && dia<=31)  ) 
		{
			if(Data.isBissexto(ano) && dia==29 && mes == 2) {
				return true;
			}
			else{
				if (mes == 2 && dia <=28) {
					return true;
				}
				else {
					if((mes == 4||mes ==6||mes==9||mes==11)&& dia<=30) {
						return true;
					}
					else {
						if((mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)&& dia<=31)
						{	
							return true;
						}
						else{
							return false;
						}
					}
				}

			}
		}
		else {
			return false;

		}
	}

	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}
	public int getAno() {
		return this.ano;
	}

	public String toStrings()
	{
		return this.getDia()+"/"+this.getMes()+"/"+this.getAno();
	}
	
	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da coleção
	 * separando os elementos por espaços
	 * @return retorna ums String com todos os dados
	 */
	public String toString(){
		StringBuilder data = new StringBuilder();
		data.append(this.getDia());
		data.append("/");
		data.append(this.getMes());
		data.append("/");	
		data.append(this.getAno());

		return data.toString();
	} 

	
	/**
	 * Sobreposição do método toString para retornar todo o conteúdo da coleção
	 * separando os elementos por espaços
	 * @return retorna um boolean true se objetos forem iguais e false para diferentes
	 */
	public boolean equals(Object objeto) {

		Data aux = (Data)objeto;
		if(this.getDia() == aux.getDia() && this.getMes() == aux.getMes() && this.getAno() == aux.getAno())
			return true;
		else
			return false;
	}

	
	/**
	 * Incrementa a data em um dia
	 */
	public void incrementa(){
		try {
			this.setData(this.getDia()+1,this.getMes(), this.getAno());
		}catch(Exception erro){
			try {
				this.setData(01,this.getMes()+1, this.getAno());
			}catch(Exception erro2){
				try {
					this.setData(01,01, this.getAno()+1);
				} catch (Exception e) {
					System.out.println("Data Invalida");
				}
			}
		}
	}

	/**
	 * Incrementa a data em uma certa quantidade de dias
	 * @param x quantide de dias incrementados
	 */
	public void incrementaX(double x) {
		for(double i=0; i<x; i++) {
			this.incrementa();
			this.toString();
		}
	}

	/**
	 * Incrementa a data em uma certa quantidade de dias
	 * @param data objeto a ser comparado
	 * @return 0 para objetos iguais; 
	 * 1 para objetos menores;
	 *  -1 para objetos maiores ;
	 */
	public int compareTo(Data data) {

		if(this.getAno()>=data.ano)
		{
			if(this.getMes()>=data.mes)
			{	
				if(this.getMes()>data.mes)
					return 1;
				else
				{
					if(this.getDia()>data.dia)
						return 1;
					else
						return 0;
				}	
			}else 
				return -1;
		}else
			return -1;
	}
	
	/**
	 * Verifica se uma data é validada e cria uma data
	 * @param três inteiros dia, mes e ano
	 * @return Objeto do tipo Data
	 */
	public static Data verificaECriaData(int dia, int mes, int ano){
		try {
			return new Data(dia, mes, ano);
		}
		catch(Exception e){
			return null;
		}

	}
}
