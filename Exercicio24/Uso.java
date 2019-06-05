package exer24;

import java.io.BufferedWriter;

public class Uso {
	public static void main(String[] args) throws Exception {
		
		ConjuntoSorteio numeros = new ConjuntoSorteio(new Data(28,12,2007),8);
		Arquivo.grava("arquivo_de_saida", numeros.toString());

		System.out.println(numeros);
	}
		
}
