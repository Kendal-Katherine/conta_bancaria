package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupança;
import conta_bancaria.util.Cores;

public class Menu {
	
	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {


		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		ContaPoupança cp1 = new ContaPoupança(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
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
			
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
			
				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();
				
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();
				
				System.out.println("Digite o tipo da Conta (1 - CC ou 2 - CP): ");
				tipo = leia.nextInt();
				
				System.out.println("Digite o Saldo da conta: ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
                break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
					contas.listarTodas();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			
			
			
			
			
			
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
