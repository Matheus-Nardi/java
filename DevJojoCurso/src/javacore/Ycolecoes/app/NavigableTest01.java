package javacore.Ycolecoes.app;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import javacore.Ycolecoes.models.Manga;
import javacore.Ycolecoes.models.Smartphone;

class SmartphoneByMarca implements Comparator<Smartphone> {

	@Override
	public int compare(Smartphone o1, Smartphone o2) {
		return o1.getMarca().compareToIgnoreCase(o2.getMarca());
	}

}

class MangaByPreco implements Comparator<Manga> {

	@Override
	public int compare(Manga o1, Manga o2) {
		return o1.getPreço().compareTo(o2.getPreço());
	}
	
}



public class NavigableTest01 {
	public static void main(String[] args) {
		NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneByMarca()); // Realiza sort , logo temos que ter a
																				// implementação de comparable

		set.add(new Smartphone("123", "Nokia"));
		set.add(new Smartphone("900", "Motorla"));
		set.add(new Smartphone("342", "Sansung"));
		set.add(new Smartphone("859", "Apple"));

		for (Smartphone smartphone : set.descendingSet()) {
			System.out.println(smartphone);
		}
		
		System.out.println("----------------");
		NavigableSet<Manga> setMangas = new TreeSet<>(new MangaByPreco());
		setMangas.add(new Manga("Bersek", 9.55, 0));
		setMangas.add(new Manga("Attak on Titan", 10.99, 20));
		setMangas.add(new Manga("Demon Slayer", 11.25, 15));
		setMangas.add(new Manga("Blue lock", 7.45, 0));
		
		Manga dragonBall = new Manga("Dragon Ball Z", 8.45, 2);
		for (Manga manga : setMangas) {
			System.out.println(manga);
		}
		
		//lower <
		//floor <=
		//higher >
		//ceiling >=
		
		
		System.out.println("--------RETORNANDO UM MANGA COM PRECO MENOR QUE O DO DRAGON BALL---------");
		System.out.println(setMangas.lower(dragonBall));
		System.out.println("--------RETORNANDO UM MANGA COM PRECO MENOR OU IGUAL QUE O DO DRAGON BALL---------");
		System.out.println(setMangas.floor(dragonBall));
		System.out.println("--------RETORNANDO UM MANGA COM PRECO MAIOR QUE O DO DRAGON BALL---------");
		System.out.println(setMangas.higher(dragonBall));
		System.out.println("--------RETORNANDO UM MANGA COM PRECO MAIOR OU IGUAL QUE O DO DRAGON BALL---------");
		System.out.println(setMangas.ceiling(dragonBall));
		
		System.out.println("Atual tamanho: " + setMangas.size());
		System.out.println("Removendo o primeiro: " + setMangas.pollFirst());
		System.out.println("Removendo o ultimo: " + setMangas.pollLast());
		System.out.println("Tamanho final " + setMangas.size());
		
		
		
	}
}
