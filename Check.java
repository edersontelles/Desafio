package Desafio1.v4;

import java.util.ArrayList;

public class Check {

	static ArrayList<Boolean> quartoFumante = new ArrayList<>();
	static ArrayList<Boolean> quartoOcupado = new ArrayList<>();
	
	public Integer checkIn(boolean clienteFumente) {
		
		Integer posicaoQuarto = null;

		if(quartoFumante.size() == 0 ) {
			System.out.println("\n...............................");
			System.out.println("NÃO HÁ QUARTO CADASTRADO!");
			System.out.println("...............................");
		}

			for(int i = 0; i < quartoFumante.size(); i++) {
				
				if(quartoFumante.get(i).equals(clienteFumente) && quartoOcupado.get(i).equals(true)) {
					posicaoQuarto = i;
					quartoOcupado.set(i, false); // "false" quarto ocupado
					break;
				}
			}
			if(posicaoQuarto == null) {
				System.out.println("\n...............................");
				System.out.println("Não há quarto disponivel!");
				System.out.println("...............................");
			}else {
				System.out.println("\n...............................");
				System.out.println("Check-in realizado com sucesso!");
				System.out.println("...............................");
			}
		return posicaoQuarto;
	}
	public void checkOut(boolean clienteFumente) {
		for(int i = 0; i < quartoFumante.size(); i++) {
			
			if(quartoFumante.get(i).equals(clienteFumente) && quartoOcupado.get(i).equals(false)) {

				quartoOcupado.set(i, true); // "true" quarto disponivel
				break;
			}
		}
	}
	
	public String converteSimNao(boolean valorBoleanoF) {
		String sN;
		
		if(valorBoleanoF == true) {
			sN = "Sim";
		}else {
			sN = "Não";
		}
		return sN; // retorna "sim" ou "não"
	}
	
	public Boolean converteTrueFalse(String valorString) {
		Boolean tF;
		
		if(valorString.equals("Sim") || valorString.equals("sim")) {
			tF = true;
		}else {
			tF = false;
		}
		return tF;
	}
}
