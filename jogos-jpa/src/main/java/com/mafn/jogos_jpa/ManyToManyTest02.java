package com.mafn.jogos_jpa;

import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.service.JogoService;

public class ManyToManyTest02 {
	public static void main(String[] args) {
		JogoService service = new JogoService();
		Jogo jogoA  = Jogo.builder().nome("Jogo Test 123").build();
		
		Genero generoA = Genero.builder().nome("Esporte").build();
		Genero generoB = Genero.builder().nome("BattleRoyale").build();
		
		
		jogoA.adiconarGenero(generoA);
		jogoA.adiconarGenero(generoB);
		
		service.inserir(jogoA);
		
		service.fechar();
	}
}
