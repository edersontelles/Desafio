/**
 * 
 */
package Desafio1.v4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ederson
 *
 */
public class Cliente extends Check{
	
	Integer quartoNum;
	String quartoNom;
	ArrayList<String>  clienteNomes = new ArrayList<>();
	ArrayList<String>  clienteDataNasc = new ArrayList<>();
	ArrayList<String>  clienteEmail = new ArrayList<>();
	ArrayList<Integer> clienteTelefone = new ArrayList<>();
	ArrayList<String>  clienteCidade = new ArrayList<>();
	ArrayList<String>  clienteUf = new ArrayList<>();
	ArrayList<Boolean> clienteFumante = new ArrayList<>();
	ArrayList<Integer> clienteNumQuarto = new ArrayList<>(); //guardar nº do quarto
	
	Scanner teclado = new Scanner(System.in);
	
	//Encadeamento de classes...
	InputStream is = System.in;
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	
	//BufferedReader bra = new BufferedReader(new InputStreamReader(System.in));
	
	public void fazerCheckIn() {
		
		Integer posicaoCliente;
		
		System.out.println("\n*******************************");
		System.out.println("*********** Check-in **********");
		for(int i = 0; i < clienteNomes.size(); i++) {
			if(clienteNomes.get(i) != null)
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione Nº do Cliente: ");
		posicaoCliente = teclado.nextInt();
		
		quartoNum = checkIn(clienteFumante.get(posicaoCliente));
		
		for(int i = 0; i < clienteNumQuarto.size(); i++) {
			if(posicaoCliente == i) {
				clienteNumQuarto.set(i, quartoNum); //
				
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
		System.out.print("Selecione Nº do Cliente: ");
		posicaoCliente = teclado.nextInt();

		clienteNumQuarto.set(posicaoCliente, null);
		
		checkOut(clienteFumante.get(posicaoCliente));
	}
	
	public void cadastraCliente() throws IOException {
		
		String nome, dataNasc, email, cidade, uF;
		Integer telefone;
		String fumante;
		Boolean fumanteBoo;
		
		System.out.println("Nome: ");
		//nome = teclado.next();
		nome = br.readLine();
		System.out.println("Data de Nascimento: ");
		dataNasc = teclado.next();
		System.out.println("Email: ");
		email = teclado.next();
		System.out.println("Telefone: ");
		telefone = Integer.parseInt(br.readLine());
		System.out.println("Cidade: ");
		//cidade = teclado.next();
		cidade = br.readLine();
		System.out.println("UF: ");
		uF = teclado.next();
		System.out.println("Fumante Sim ou Não: ");
		fumante = teclado.next();
		fumanteBoo = converteTrueFalse(fumante);
		
		if(clienteNomes.size() == 0) {
			
			clienteNomes.add(nome);
			clienteDataNasc.add(dataNasc);
			clienteEmail.add(email);
			clienteTelefone.add(telefone);
			clienteCidade.add(cidade);
			clienteUf.add(uF);
			clienteFumante.add(fumanteBoo);
			clienteNumQuarto.add(null);
		}else {
			int tamanhoListaNomes = clienteNomes.size();
			int indiceLista = 0;
			Boolean posicaoListaNull = false;

			for(int i = 0; i < tamanhoListaNomes; i++) {
				
				if(clienteNomes.get(i) == null) {
					posicaoListaNull = true;
					indiceLista = i;
				}
			}
			
			if(posicaoListaNull == true) {
				clienteNomes.set(indiceLista, nome);
				clienteDataNasc.set(indiceLista, dataNasc);
				clienteEmail.set(indiceLista, email);
				clienteTelefone.set(indiceLista, telefone);
				clienteCidade.set(indiceLista, cidade);
				clienteUf.set(indiceLista, uF);
				clienteFumante.set(indiceLista, fumanteBoo);
				clienteNumQuarto.set(indiceLista, null);
			}else {
				clienteNomes.add(nome);
				clienteDataNasc.add(dataNasc);
				clienteEmail.add(email);
				clienteTelefone.add(telefone);
				clienteCidade.add(cidade);
				clienteUf.add(uF);
				clienteFumante.add(fumanteBoo);
				clienteNumQuarto.add(null);
			}
		}
				
		/* 	
		clienteNomes.add("Fulano");
		clienteDataNasc.add("01/01/1001");
		clienteEmail.add("aaa@aaa.com");
		clienteTelefone.add(3333333);
		clienteCidade.add("Fulanopólis");
		clienteUf.add("FF");
		clienteFumante.add(false);
		clienteNumQuarto.add(null);
		super.clienteDisponivel.add(true); // Sem check-in ainda
		
		clienteNomes.add("Siclano");
		clienteDataNasc.add("02/02/2002");
		clienteEmail.add("ddd@ddd.com");
		clienteTelefone.add(4444444);
		clienteCidade.add("Siclanopólis");
		clienteUf.add("SS");
		clienteFumante.add(true);
		clienteNumQuarto.add(null);
		super.clienteDisponivel.add(true); // Sem check-in ainda
		*/
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
			if(clienteNumQuarto.get(i) == null) {
				System.out.println("Check-in não realizado!");
			}else {
				System.out.println("Quarto: " + clienteNumQuarto.get(i));
			}
			
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
		System.out.print("Selecione Nº do Cliente: ");
		posicaoRemove = teclado.nextInt();

		clienteNomes.set(posicaoRemove, null);
		clienteDataNasc.set(posicaoRemove, null);
		clienteEmail.set(posicaoRemove, null);
		clienteTelefone.set(posicaoRemove, null);
		clienteCidade.set(posicaoRemove, null);
		clienteUf.set(posicaoRemove, null);
		clienteFumante.set(posicaoRemove, null);
		quartoDisponivel.set(posicaoRemove, true); // "false" quarto Não ocupado
		
		if(clienteNomes.get(posicaoRemove) == null) {
			System.out.println("\n...............................");
			System.out.println("Clinte excluido com sucesso!");
			System.out.println("...............................");
		}else {
			System.out.println("\n...............................");
			System.out.println("Erro ao excluir Cliente!");
			System.out.println("...............................");
		}
	}
	
	public void editarCliente() throws IOException {
	
		int posicaoEditar;
		String nome, dataNasc, email, cidade, uF, nomeEditado, dataNascEditado, emailEditado, cidadeEditado, ufEditado; 
		Integer telefone, telefoneEditado;
		Boolean fumante, fumanteEditadoBoo;
		String fumanteEditado;
		
		System.out.println("\n*******************************");
		System.out.println("******** EDITAR CLIENTE *******");
		for(int i = 0; i < clienteNomes.size(); i++) {
			System.out.println(i + " - " + clienteNomes.get(i));
		}
		System.out.print("Selecione Nº do Cliente: ");
		posicaoEditar = teclado.nextInt();
		
		nome = clienteNomes.get(posicaoEditar);
		dataNasc = clienteDataNasc.get(posicaoEditar);
		email = clienteEmail.get(posicaoEditar);
		telefone = clienteTelefone.get(posicaoEditar);//Integer
		cidade = clienteCidade.get(posicaoEditar);
		uF = clienteUf.get(posicaoEditar);
		fumante = clienteFumante.get(posicaoEditar);//Boolean
		
		System.out.println("Editar nome " + nome + " para: ");
		nomeEditado = br.readLine();
		System.out.println("Editar D/N " + dataNasc + " para: ");
		dataNascEditado = teclado.next();
		System.out.println("Editar email " + email + " para: ");
		emailEditado = teclado.next();
		System.out.println("Editar telefone " + telefone + " para: ");
		telefoneEditado = teclado.nextInt();
		System.out.println("Editar cidade " + cidade + " para: ");
		cidadeEditado = br.readLine();
		System.out.println("Editar UF " + uF + " para: ");
		ufEditado = teclado.next();
		System.out.println("Editar fumante " + converteSimNao(fumante) + " para: ");
		fumanteEditado = teclado.next();
		fumanteEditadoBoo = converteTrueFalse(fumanteEditado);
		/*
		nomeEditado = "BBB";
		dataNascEditado = "01/01/2000";
		emailEditado = "bbb@bbb.com";
		telefoneEditado = 99999999;
		cidadeEditado = "Bbbnopolis";
		ufEditado = "BB";
		fumanteEditado = true;
		*/
		clienteNomes.set(posicaoEditar, nomeEditado);
		clienteDataNasc.set(posicaoEditar, dataNascEditado);
		clienteEmail.set(posicaoEditar, emailEditado);
		clienteTelefone.set(posicaoEditar, telefoneEditado);
		clienteCidade.set(posicaoEditar, cidadeEditado);
		clienteUf.set(posicaoEditar, ufEditado);
		clienteFumante.set(posicaoEditar, fumanteEditadoBoo);
	}
	
	}
