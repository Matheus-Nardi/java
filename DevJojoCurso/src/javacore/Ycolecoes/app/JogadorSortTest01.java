package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javacore.Ycolecoes.models.Jogador;

public class JogadorSortTest01 {
	public static void main(String[] args) {
		List<Jogador> jogadores = new ArrayList<>();
		jogadores.add(new Jogador(1, "Pelé", 10));
		jogadores.add(new Jogador(5, "Cristiano Ronaldo", 7));
		jogadores.add(new Jogador(3, "Messi", 10));

		for (Jogador jogador : jogadores) {
			System.out.println(jogador);
		}

		Collections.sort(jogadores);

		System.out.println("-----------");
		for (Jogador jogador : jogadores) {
			System.out.println(jogador);
		}
	}

}
