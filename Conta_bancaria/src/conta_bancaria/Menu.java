package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		
		/*Criar objetos da Classe Conta para testes*/
		
		Conta c1 = new Conta(1, 123, 1, "Victória Moraes", 100000.0f);
		c1.visualizar();
		System.out.println("Exibir o Saldo: " + c1.getSaldo());
		c1.setSaldo(2000000.00f);
		c1.visualizar();
		c1.sacar(21000000.00f);
		c1.visualizar();
		c1.depositar(5000.00f);
		c1.visualizar();
		
		Conta c2 = new Conta(2, 123, 1, "Vitor Nascimento", 3000000.00f);
		c2.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Felipe", 100000.00f, 2000.00f);
		cc1.visualizar();
		cc1.sacar(101000.00f);
		cc1.visualizar();
		cc1.depositar(1000.00f);
		cc1.visualizar();


		
		while(true) {
			
			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND_BRIGHT 
					         + "****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                            BRANCO KKC                                      ");
			System.out.println("                                                                            ");
			System.out.println("****************************************************************************");
			System.out.println("                                                                            ");
			System.out.println("                        1 - Criar conta                                     ");
			System.out.println("                        2 - Listar todas as contas                          ");
			System.out.println("                        3 - Buscar Conta por número                         ");
			System.out.println("                        4 - Atualizar dados da conta                        ");
			System.out.println("                        5 - Apagar conta                                    ");
			System.out.println("                        6 - Sacar                                           ");
			System.out.println("                        7 - Depositar                                       ");
			System.out.println("                        8 - Transferir valores entre contas                 ");
			System.out.println("                        9 - Sair                                            ");
			System.out.println("                                                                            ");
			System.out.println("****************************************************************************");
			System.out.println("Entre com a opção desejada:                                                  ");
			System.out.println("                                                                            " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Banco KKC - Dois Ks e um C para você vencer!");
				sobre();
				leia.close();
				System.exit(0);
			}
			
			switch(opcao) {
			
			case 1 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n\n");
			case 2 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas\n\n");
			case 3 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - por número\n\n");
			case 4 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
			case 5 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar conta\n\n");
			case 6 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
			case 7 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
			case 8 -> System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n\n");
			default -> System.out.println(Cores.TEXT_WHITE_BOLD + "Opção inválida!\n\n" + Cores.TEXT_RESET);
			
			
			
			
			
			
			
			}
			
			
			
		}
		

	}
	public static void sobre() {
	System.out.println("****************************************************************************");
	System.out.println("Projeto desenvolvido por: Kendal Katherine Correia                          ");
	System.out.println("Apoio Generation Brasil - generation@generation.org                         ");
	System.out.println("https://github.com/Kendal-Katherine/conta_bancaria                         ");
	System.out.println("****************************************************************************");
	}
}