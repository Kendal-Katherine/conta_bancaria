package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
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

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);

		ContaPoupança cp1 = new ContaPoupança(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

		while (true) {

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
			System.out.println("                        9 - Consulta por Titular                            ");
			System.out.println("                        10 - Sair                                            ");
			System.out.println("                                                                            ");
			System.out.println("****************************************************************************");
			System.out.println("Entre com a opção desejada:                                                  ");
			System.out.println(
					"                                                                            " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;

			}
			if (opcao == 10) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Banco KKC - Dois Ks e um C para você vencer!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

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

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupança(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				Optional<Conta> conta = contas.buscarNaCollection(numero);

				if (conta.isPresent()) {

					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();

					System.out.println("Digite o nome do Titular: ");
					leia.skip("\\R");
					titular = leia.nextLine();

					tipo = conta.get().getTipo();

					System.out.println("Digite o Saldo da conta: ");
					saldo = leia.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupança(numero, agencia, tipo, titular, saldo, aniversario));
					}
					}
				}

				else {
					System.out.println("A conta número: " + numero + " não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				System.out.println("Digite o valor do Saque: ");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				System.out.println("Digite o valor do Depósito: ");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();

			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				System.out.println("Digite o número da conta de Origem: ");
				numero = leia.nextInt();

				System.out.println("Digite o número da conta de Destino: ");
				numeroDestino = leia.nextInt();

				if (numero != numeroDestino) {
					System.out.println("Digite o valor do Depósito: ");
					valor = leia.nextFloat();
					contas.transferir(numero, numeroDestino, valor);
				} else {
					System.out.println("Os números dasContas são iguais!");
				}
				keyPress();
				break;

			case 9:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por Titular\n\n");

				System.out.println("Digite o nome do Titular da conta: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				contas.procurarPorNome(titular);
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
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

	public static void keyPress() {
		try {

			System.out.println("\n\nPreesione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");

		}
	}
}
