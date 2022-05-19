/**
 * 
 */
package Desafio1.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ederson
 *
 */
public class Cliente extends Check{
	
	Integer quarto;
	ArrayList<String>  clienteNomes = new ArrayList<>();
	ArrayList<String>  clienteDataNasc = new ArrayList<>();
	ArrayList<String>  clienteEmail = new ArrayList<>();
	ArrayList<Integer> clienteTelefone = new ArrayList<>();
	ArrayList<String>  clienteCidade = new ArrayList<>();
	ArrayList<String>  clienteUf = new ArrayList<>();
	ArrayList<Boolean> clienteFumante = new ArrayList<>();
	ArrayList<Integer> clienteNumQuarto = new ArrayList<>(); //guardar n� do quarto
	
	Scanner teclado = new Scanner(System.in);
	
	public void fazerCheckIn() {
		
		Integer posicaoCliente;
		
		System.out.println("\n*******************************");
		System.out.println("*********** Check-in **********");
		for(int i = 0; i < clienteNomes.size(); i++) {
			if(clienteNomes.get(i) != null)
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione N� do Cliente: ");
		posicaoCliente = teclado.nextInt();
		
		quarto = checkIn(clienteFumante.get(posicaoCliente));
		
		for(int i = 0; i < clienteNumQuarto.size(); i++) {
			if(posicaoCliente == i) {
				clienteNumQuarto.set(i, quarto);
				
			}
		}
	}
public void fazerCheckOut() {
		
		Integer posicaoCliente;
		
		System.out.println("\n*******************************");
		System.out.println("*********** Check-out **********");
		for(int i = 0; i < clienteNomes.size(); i++) {
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione N� do Cliente: ");
		posicaoCliente = teclado.nextInt();

		clienteNumQuarto.set(posicaoCliente, null);
		
		checkOut(clienteFumante.get(posicaoCliente));
	}
	
	public void cadastraCliente() {
		
		String nome, dataNasc, email, cidade, uF;
		Integer telefone;
		Boolean fumante;
		
		/*
		System.out.println("Nome: ");
		nome = teclado.next();
		System.out.println("Data de Nascimento: ");
		dataNasc = teclado.next();
		System.out.println("Email: ");
		email = teclado.next();
		System.out.println("Telefone: ");
		telefone = teclado.nextInt();
		System.out.println("Cidade: ");
		cidade= teclado.next();
		System.out.println("UF: ");
		uF = teclado.next();
		System.out.println("Fumante Sim ou N�o: ");
		fumante = teclado.nextBoolean();
		//quartoDisponivel.add(false);
		
		clienteNomes.add(nome);
		clienteDataNasc.add(dataNasc);
		clienteEmail.add(email);
		clienteTelefone.add(telefone);
		clienteCidade.add(cidade);
		clienteUf.add(uF);
		clienteFumante.add(fumante);
		clienteNumQuarto.add(null);
		*/
		clienteNomes.add("Fulano");
		clienteDataNasc.add("01/01/1001");
		clienteEmail.add("aaa@aaa.com");
		clienteTelefone.add(3333333);
		clienteCidade.add("Fulanop�lis");
		clienteUf.add("FF");
		clienteFumante.add(false);
		clienteNumQuarto.add(null);
		
		clienteNomes.add("Siclano");
		clienteDataNasc.add("02/02/2002");
		clienteEmail.add("ddd@ddd.com");
		clienteTelefone.add(4444444);
		clienteCidade.add("Siclanop�lis");
		clienteUf.add("SS");
		clienteFumante.add(true);
		clienteNumQuarto.add(null);
	}
	
	public void listarCliente() {

		System.out.println("\n--------- Clientes cadastrados ---------");
		for(int i = 0; i < clienteNomes.size(); i++) {
			if(clienteNomes.get(i) != null) {
			System.out.println("Nome: " + clienteNomes.get(i));
			System.out.println("Data Nascimento: " + clienteDataNasc.get(i));
			System.out.println("Email: " + clienteEmail.get(i));
			System.out.println("Telefone: " + clienteTelefone.get(i));
			System.out.println("Cidade: " + clienteCidade.get(i));
			System.out.println("UF: " + clienteUf.get(i));
			System.out.println("Fumante: " + converteSimNao(clienteFumante.get(i)));
			System.out.println("Quarto: " + clienteNumQuarto.get(i));
			System.out.println("----------------------------------------");
			}
		}
		
	}
	
	public void removerCliente() {
		
		int posicaoRemove;
		
		System.out.println("\n*******************************");
		System.out.println("******** EXCLUIR CLIENTE ******");
		for(int i = 0; i < clienteNomes.size(); i++) {
			if(clienteNomes.get(i) != null)
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione N� do Cliente: ");
		posicaoRemove = teclado.nextInt();

		clienteNomes.set(posicaoRemove, null);
		clienteDataNasc.set(posicaoRemove, null);
		clienteEmail.set(posicaoRemove, null);
		clienteTelefone.set(posicaoRemove, null);
		clienteCidade.set(posicaoRemove, null);
		clienteUf.set(posicaoRemove, null);
		clienteFumante.set(posicaoRemove, null);
		
		if(clienteNomes.get(posicaoRemove) == null) {
			System.out.println("\n...............................");
			System.out.println("Clente excluido com sucesso!");
			System.out.println("...............................");
		}else {
			System.out.println("\n...............................");
			System.out.println("Erro ao excluir Cliente!");
			System.out.println("...............................");
		}
	}
	
	public void editarCliente() {
	
		int posicaoEditar;
		String nome, dataNasc, email, cidade, uF, nomeEditado, dataNascEditado, emailEditado, cidadeEditado, ufEditado; 
		Integer telefone, telefoneEditado;
		Boolean fumante, fumanteEditado;
		
		System.out.println("\n*******************************");
		System.out.println("******** EDITAR CLIENTE *******");
		for(int i = 0; i < clienteNomes.size(); i++) {
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione N� do Cliente: ");
		posicaoEditar = teclado.nextInt();
		
		nome = clienteNomes.get(posicaoEditar);
		dataNasc = clienteDataNasc.get(posicaoEditar);
		email = clienteEmail.get(posicaoEditar);
		telefone = clienteTelefone.get(posicaoEditar);//Integer
		cidade = clienteCidade.get(posicaoEditar);
		uF = clienteUf.get(posicaoEditar);
		fumante = clienteFumante.get(posicaoEditar);//Boolean
		/*
		System.out.println("Editar " + nome + " para: ");
		nomeEditado = teclado.next();
		System.out.println("Editar " + dataNasc + " para: ");
		dataNascEditado = teclado.next();
		System.out.println("Editar " + email + " para: ");
		emailEditado = teclado.next();
		System.out.println("Editar " + telefone + " para: ");
		telefoneEditado = teclado.nextInt();
		System.out.println("Editar " + cidade + " para: ");
		cidadeEditado = teclado.next();
		System.out.println("Editar " + uF + " para: ");
		ufEditado = teclado.next();
		System.out.println("Editar " + fumante + " para: ");
		fumanteEditado = teclado.nextBoolean();
		*/
		nomeEditado = "BBB";
		dataNascEditado = "01/01/2000";
		emailEditado = "bbb@bbb.com";
		telefoneEditado = 99999999;
		cidadeEditado = "Bbbnopolis";
		ufEditado = "BB";
		fumanteEditado = true;
		
		clienteNomes.set(posicaoEditar, nomeEditado);
		clienteDataNasc.set(posicaoEditar, dataNascEditado);
		clienteEmail.set(posicaoEditar, emailEditado);
		clienteTelefone.set(posicaoEditar, telefoneEditado);
		clienteCidade.set(posicaoEditar, cidadeEditado);
		clienteUf.set(posicaoEditar, ufEditado);
		clienteFumante.set(posicaoEditar, fumanteEditado);
	}
	
	}