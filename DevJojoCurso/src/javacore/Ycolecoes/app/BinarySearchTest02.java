package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javacore.Ycolecoes.models.Jogador;

public class BinarySearchTest02 {
	public static void main(String[] args) {
		List<Jogador> jogadores = new ArrayList<>();
		jogadores.add(new Jogador(1, "Pelé", 10));
		jogadores.add(new Jogador(5, "Cristiano Ronaldo", 7));
		jogadores.add(new Jogador(3, "Messi", 10));
		
		Collections.sort(jogadores);
		for (Jogador jogador : jogadores) {
			System.out.println(jogador);
		}
		
		Jogador jogadorToSearch = jogadores.get(1);
		System.out.println(Collections.binarySearch(jogadores, jogadorToSearch));
		

	}
}
