/**
 * 
 */
package Desafio1.v4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ederson
 *
 */
public class Quarto extends Check{
	
	ArrayList<String>  quartoNomes = new ArrayList<>();
	ArrayList<String>  quartoPosicao = new ArrayList<>();
	//ArrayList<Boolean> quartoFumante = new ArrayList<>();
	ArrayList<Float> quartoValorDiaria = new ArrayList<>();
	ArrayList<Integer> quartoPessoaPorQuarto = new ArrayList<>();
	
	Scanner teclado = new Scanner(System.in);
	
	public void cadastarQuarto() {
		
		String nome, posicao;
		String fumante;
		float valorDiaria;
		int pessoaPorQuarto;
		boolean fumanteBoo;
		
		System.out.println("Nome: ");
		nome = teclado.next();
		System.out.println("Posição: ");
		posicao = teclado.next();
		System.out.println("Valor Diaria: ");
		valorDiaria = teclado.nextInt();
		System.out.println("Pessoa por quarto: ");
		pessoaPorQuarto = teclado.nextInt();
		System.out.println("Fumante: ");
		fumante = teclado.next();
		fumanteBoo = converteTrueFalse(fumante);
		
		quartoNomes.add(nome);
		quartoPosicao.add(posicao);
		quartoValorDiaria.add((float) valorDiaria);
		quartoPessoaPorQuarto.add(pessoaPorQuarto);
		quartoFumante.add(fumanteBoo);
		super.quartoDisponivel.add(true); // Quarto livre
		/*		
		quartoNomes.add("AAA");
		quartoPosicao.add("Sul");
		//quartoFumante.add(false);
		quartoValorDiaria.add((float) 100);
		quartoPessoaPorQuarto.add(4);
		super.quartoFumante.add(false); //Quarto para Não fumante
		super.quartoOcupado.add(true); // Quarto livre
		
		quartoNomes.add("BBB");
		quartoPosicao.add("Norte");
		//quartoFumante.add(true);
		quartoValorDiaria.add((float) 200);
		quartoPessoaPorQuarto.add(4);
		super.quartoFumante.add(true); //Quarto para fumante
		super.quartoOcupado.add(true); //Quarto livre
		
		quartoNomes.add("FFF");
		quartoPosicao.add("Leste");
		//quartoFumante.add(false);
		quartoValorDiaria.add((float) 300);
		quartoPessoaPorQuarto.add(1);
		super.quartoFumante.add(true); //Quarto para fumante
		super.quartoOcupado.add(true); //Quarto livre
		*/
	}
	
	public void listarQuartos() {
		
		System.out.println("\n--------- Quartos cadastrado -----------");
		for(int i = 0; i < quartoNomes.size(); i++) {
			if(quartoNomes.get(i) != null) {
			System.out.println("Nome: " + quartoNomes.get(i));
			System.out.println("Posição: " + quartoPosicao.get(i));
			System.out.println("Fumante: " + converteSimNao(quartoFumante.get(i)));
			System.out.println("Valor Diaria: " + quartoValorDiaria.get(i));
			System.out.println("Quantidade de pessoa(s): " + quartoPessoaPorQuarto.get(i));
			System.out.println("----------------------------------------");
			}
		}
		for(int i = 0; i < super.quartoFumante.size(); i++) {
			if(super.quartoFumante.get(i) != null)
			System.out.println("Quarto " + i + " - " + quartoNomes.get(i) + " | fumante: " + converteSimNao(quartoFumante.get(i)) + " | disponível: " + converteSimNao(quartoDisponivel.get(i)));
		}
		System.out.println("----------------------------------------");
	}
	
	public void listarQuartosDisponibilidade() {
		System.out.println("\n-------- Quarto(s) disponivel ----------");
		
		if(quartoFumante.size() == 0 ) {
			System.out.println("\n...............................");
			System.out.println("NÃO HÁ QUARTO CADASTRADO!");
			System.out.println("...............................");
		}
		
		for(int i = 0; i < super.quartoFumante.size(); i++) {
			if(super.quartoFumante.get(i) != null)
			System.out.println("Quarto " + quartoNomes.get(i) + " fumante: " + converteSimNao(quartoFumante.get(i)) + " | disponível: " + converteSimNao(quartoDisponivel.get(i)));
		}
		System.out.println("----------------------------------------");
	}
	
	public void excluirQuarto() {
		
		int posicaoRemover;
		
		System.out.println("\n*******************************");
		System.out.println("******** EXCLUIR QUARTO *******");
		for(int i = 0; i < quartoNomes.size(); i++) {
			if(quartoNomes.get(i) != null)
			System.out.println(i + " - " + quartoNomes.get(i));
		}
		System.out.print("Selecione Nº do Quarto: ");
		posicaoRemover = teclado.nextInt();
		
		quartoNomes.set(posicaoRemover, null);
		quartoPosicao.set(posicaoRemover, null);
		//quartoFumante.set(posicaoRemover, null);
		quartoValorDiaria.set(posicaoRemover, null);
		quartoPessoaPorQuarto.set(posicaoRemover, null);
		super.quartoFumante.set(posicaoRemover, null);
		super.quartoDisponivel.set(posicaoRemover, null);
		
		if(quartoNomes.get(posicaoRemover) == null) {
			System.out.println("\n...............................");
			System.out.println("Quarto excluido com sucesso!");
			System.out.println("...............................");
		}else {
			System.out.println("\n...............................");
			System.out.println("Erro ao excluir Quarto!");
			System.out.println("...............................");
		}
	}
	
	public void editarQuarto() {
		
		int posicaoEditar;
		String nome, posicao, nomeEditado, posicaoEditado, fumanteEditado;
		boolean fumante, fumanteEditadoBoo;
		float valorDiaria, valorDiariaEditado;
		int pessoaPorQuarto, pessoaPorQuartoEditado;

		System.out.println("\n*******************************");
		System.out.println("******** EDITAR CLIENTE *******");
		for(int i = 0; i < quartoNomes.size(); i++) {
			System.out.println(i + " - " + quartoNomes.get(i));
		}
		System.out.print("Selecione Nº do Cliente: ");
		posicaoEditar = teclado.nextInt();
		
		nome = quartoNomes.get(posicaoEditar);
		posicao = quartoPosicao.get(posicaoEditar);
		fumante = quartoFumante.get(posicaoEditar);
		valorDiaria = quartoValorDiaria.get(posicaoEditar);
		pessoaPorQuarto = quartoPessoaPorQuarto.get(posicaoEditar);
		
		System.out.println("Editar nome " + nome + " para: ");
		nomeEditado = teclado.next();
		System.out.println("Editar posição  " + posicao + " para: ");
		posicaoEditado = teclado.next();
		System.out.println("Editar valor da diaria  " + valorDiaria + " para: ");
		valorDiariaEditado = teclado.nextFloat();
		System.out.println("Editar nº de pessoa p/ quarto " + pessoaPorQuarto + " para: ");
		pessoaPorQuartoEditado = teclado.nextInt();
		System.out.println("Editar fumante " + fumante + " para: ");
		fumanteEditado = teclado.next();
		fumanteEditadoBoo = converteTrueFalse(fumanteEditado);
		
		/* 		
		nomeEditado = "XXX";
		posicaoEditado = "Norte";
		fumanteEditado = true;
		valorDiariaEditado = 200;
		pessoaPorQuartoEditado = 1;
		*/		
		quartoNomes.set(posicaoEditar, nomeEditado);
		quartoPosicao.set(posicaoEditar, posicaoEditado);
		quartoFumante.set(posicaoEditar, fumanteEditadoBoo);
		quartoValorDiaria.set(posicaoEditar, (float) valorDiariaEditado);
		quartoPessoaPorQuarto.set(posicaoEditar, pessoaPorQuarto);
	}

}
