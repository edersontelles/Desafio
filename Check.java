package Desafio1.v4;

import java.util.ArrayList;

public class Check {

	static ArrayList<Boolean> quartoFumante = new ArrayList<>();
	static ArrayList<Boolean> quartoDisponivel = new ArrayList<>();
	
	public Integer checkIn(boolean clienteFumente) {
		
		Integer posicaoQuarto = null;

		if(quartoFumante.size() == 0 ) {
			System.out.println("\n...............................");
			System.out.println("N�O H� QUARTO CADASTRADO!");
			System.out.println("...............................");
		}

			for(int i = 0; i < quartoFumante.size(); i++) {
				
				if(quartoFumante.get(i).equals(clienteFumente) && quartoDisponivel.get(i).equals(true)) {
					posicaoQuarto = i;
					quartoDisponivel.set(i, false); // "false" quarto ocupado
					break;
				}
			}
			if(posicaoQuarto == null) {
				System.out.println("\n...............................");
				System.out.println("N�o h� quarto disponivel!");
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
			
			if(quartoFumante.get(i).equals(clienteFumente) && quartoDisponivel.get(i).equals(false)) {

				quartoDisponivel.set(i, true); // "true" quarto disponivel
				break;
			}
		}
	}
	
	public String converteSimNao(boolean valorBoleanoF) {
		String sN;
		
		if(valorBoleanoF == true) {
			sN = "Sim";
		}else {
			sN = "N�o";
		}
		return sN; // retorna "sim" ou "n�o"
	}
	
	public Boolean converteTrueFalse(String valorString) {
		Boolean tF;
		
		if(valorString.equals("Sim") || valorString.equals("sim") || valorString.equals("s")) {
			tF = true;
		}else {
			tF = false;
		}
		return tF;
	}
}
