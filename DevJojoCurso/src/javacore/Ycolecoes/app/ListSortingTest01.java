package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortingTest01 {
	public static void main(String[] args) {
		List<String> jogadores = new ArrayList<>(6);
		jogadores.add("Pelé");
		jogadores.add("Ronaldinho Gaúcho");
		jogadores.add("Messi");
		jogadores.add("Cristiano Ronaldo");
		jogadores.add("Vinicius Junior");
		
		Collections.sort(jogadores);
		
		List<Double> pix = new ArrayList<>();
		pix.add(2349.99);
		pix.add(23D);
		pix.add(120.49);
		
		for (String jogador : jogadores) {
			System.out.println(jogador);
		}
		
		System.out.println("PIX original");
		System.out.println(pix);
		
		Collections.sort(pix);
		System.out.println("PIX em ordem ASC");
		System.out.println(pix);
	}
}
