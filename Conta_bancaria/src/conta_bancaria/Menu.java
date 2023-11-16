package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		
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
			System.out.println("Entre com a opção desejada:                                                 ");
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
