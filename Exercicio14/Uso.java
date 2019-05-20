package exer14;

import java.util.Scanner;

public class Uso {
	
	public static void main(String[] args) {
		int i=0;
		String nome, email, celular, endereco;
		double renda;
		Cliente cliente[] = new Cliente[50];

		while( i <50) {
			try {
				System.out.println("Informe o nome: ");
				nome= new Scanner(System.in).next();
				System.out.println("Informe o e-mail: ");
				email = new Scanner(System.in).next();
				System.out.println("Informe o celular: ");
				celular = new Scanner(System.in).next();
				System.out.println("Informe o endereço: ");
				endereco = new Scanner(System.in).next();
				System.out.println("Informe a renda: ");
				renda = new Scanner(System.in).nextDouble();
				cliente[i] = new Cliente(nome,email,celular,endereco,renda);
			}catch(Exception e) {
				System.out.println("Erro!");
			}
			i++;
		}

		//chamada polimórfica do toString
		for(i=0; i<50; i++) {
			System.out.println( cliente[i].toString());
		}
		
	}
}
