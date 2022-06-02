package Desafio1.v4;

import java.util.ArrayList;

public class Teste {
	
		static ArrayList<String> clientes = new ArrayList<>();	
		static ArrayList<String> hotel = new ArrayList<>();
		static ArrayList<String> quartos = new ArrayList<>();
		
	public static void main(String[] args) {
		
		cadastraCliente();
		cadastraQuarto();
		checkIn();
		checkIn();

		System.out.println("Clientes: " + clientes);
		System.out.println("Quartos : " + quartos);
		System.out.println("Check-in: " + hotel.get(5));
		
	}
	
	public static void cadastraCliente(){
		clientes.add("Adão");
		clientes.add("01/01/1001");
		clientes.add("adao@aaa.com.br");
		clientes.add("Fumante");
		
		clientes.add("Fulano");
		clientes.add("02/02/2002");
		clientes.add("fulano@aaa.com.br");
		clientes.add("Não Fumante");
	}
	
	public static void cadastraQuarto(){
		quartos.add("Quarto 1");
		quartos.add("Fumante");
		
		quartos.add("Quarto 2");
		quartos.add("Fumante");
	}
	
	public static void checkIn() {
		hotel.addAll(clientes);
		hotel.addAll(quartos);
	}
}
