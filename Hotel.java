/**
 * 
 */
package Desafio1.v4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

/**
 * @author Ederson
 *
 */
public class Hotel{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		boolean menu = true;
		int opcao = 0;
		
		Cliente cliente = new Cliente();
		Quarto quarto = new Quarto();

		while(menu) {
			System.out.println("\n============== Menu Principal ==============");
			System.out.println("1 - Cadastrar, editar ou excluir Clientes");
			System.out.println("2 - Cadastrar, editar ou excluir Quartos");
			System.out.println("3 - Verificar quartos disponiveis");
			System.out.println("4 - Realizar check-in");
			System.out.println("5 - Realizar check-out");
			System.out.println("6 - Relatorio geral");
			System.out.println("0 - Sair do sistema");

			System.out.print("Selecione a opção acima:");
			Scanner teclado = new Scanner(System.in);
			
			opcao = teclado.nextInt();
			
			if(opcao == 1) { // 1 - Cadastrar, editar ou excluir Clientes
				
				Scanner menuCliente = new Scanner(System.in);
				int opcaoCliente;
				System.out.println("\n*******************************");
				System.out.println("*********** CLIENTE ***********");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Excluir");
				System.out.print("Selecione opção: ");
				opcaoCliente = menuCliente.nextInt();
				
				if(opcaoCliente == 1) {// Cadastrar Cliente
					cliente.cadastraCliente();
				}
				if(opcaoCliente == 2) { // Editar Cliente
					cliente.editarCliente();
				}
				if(opcaoCliente == 3) { // Excluir Cliente
					cliente.removerCliente();
				}
				
			}else if (opcao == 2) { // 1 - Cadastrar, editar ou excluir Quarto
				
				Scanner menuQuarto = new Scanner(System.in);
				int opcaoQuarto;
				System.out.println("\n*******************************");
				System.out.println("*********** QUARTO ************");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Excluir");
				System.out.print("Selecione opção: ");
				opcaoQuarto = menuQuarto.nextInt();
				
				if(opcaoQuarto == 1) {
					quarto.cadastarQuarto();
				}
				if(opcaoQuarto == 2) {
					quarto.editarQuarto();
				}
				if(opcaoQuarto == 3) {
					quarto.excluirQuarto();
				}
				
			} else if (opcao == 3) { // Verificar quartos disponiveis
				quarto.listarQuartosDisponibilidade();
			} else if (opcao == 4) { // Check-in
				cliente.fazerCheckIn();
			} else if (opcao == 5) { // Check-out
				cliente.fazerCheckOut();
			} else if (opcao == 6) { // Relatorio geral (listar tudo)
				cliente.listarCliente();
				quarto.listarQuartos();
			} 
			else {
				System.out.println("\nSistema Finalizado!!! \n");
				menu = false;
			}
		}
	}
}
