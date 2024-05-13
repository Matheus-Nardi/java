package javacore.ZZAclassesinternas.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javacore.Zgenerics.WildCard.model.Carro;

public class AnonymousClassesTest02 {
	public static void main(String[] args) {
		List<Carro> carros = new ArrayList<Carro>(
				List.of(new Carro("Ferrai"), new Carro("Mustang"), new Carro("Audi")));
		carros.sort(new Comparator<Carro>() {
			@Override
			public int compare(Carro o1, Carro o2) {
				return o1.getNome().compareToIgnoreCase(o2.getNome());
			}
		});
		// Ao inves de criar uma classe que implementa o Comparator , posso utilizar a
		// classe anonima
		System.out.println(carros);
		
	}

}
