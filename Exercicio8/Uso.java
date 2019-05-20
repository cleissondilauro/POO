package xer8;

import java.util.Scanner;

public class Uso {

	public static void main(String args[]) {
		
		try {
			System.out.println("Informe o nome do correntista 1:");
			String nome= new Scanner(System.in).next();
			System.out.println("Informe o Saldo do correntista 1:");
			double saldo = new Scanner(System.in).nextDouble();
			Conta user1= new Conta(nome, saldo);
			
			System.out.println("Informe o nome do correntista 2:");
			String nome2= new Scanner(System.in).next();
			System.out.println("Informe o Saldo do correntista 2:");
			double saldo2 = new Scanner(System.in).nextDouble();
			Conta user2= new Conta(nome2, saldo2);
			
			System.out.println("Informe a taxa de juros");
			double taxaJ = new Scanner(System.in).nextDouble();
			Conta.setTaxaJuros(taxaJ);
			
			System.out.println("Deseja corrigir o saldo o correntista 1 ou 2");
			double attSaldoC = new Scanner(System.in).nextDouble();
			if(attSaldoC==1) {
				user1.corrigirSaldo();
			}else {
				user2.corrigirSaldo();
			}
			System.out.println(user1);
			System.out.println(user2);
		}catch(Exception e){
			System.out.println("erro");
		}
	}
}
