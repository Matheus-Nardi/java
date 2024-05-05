package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javacore.Ycolecoes.models.Jogador;

//Comparator usado quando em determinado momento eu quero fugir da ordenação padrão
 class JogadorByIdComparator implements Comparator<Jogador>{

	@Override
	public int compare(Jogador jogador1, Jogador jogador2) {
		return jogador1.getId().compareTo(jogador2.getId());
	}
	
}
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

		System.out.println("----BY NAME----");
		for (Jogador jogador : jogadores) {
			System.out.println(jogador);
		}
		

		Collections.sort(jogadores  ,new JogadorByIdComparator());
		//jogadores.sort(new  JogadorByIdComparator());

		System.out.println("----BY ID----");
		for (Jogador jogador : jogadores) {
			System.out.println(jogador);
		}
	}

}
