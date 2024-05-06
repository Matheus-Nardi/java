package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javacore.Ycolecoes.models.Manga;

public class IteratorTest01 {

	public static void main(String[] args) {
		List<Manga> mangas = new ArrayList<>();
		mangas.add(new Manga("Bersek", 9.55, 0));
		mangas.add(new Manga("Attak on Titan", 10.99, 20));
		mangas.add(new Manga("Demon Slayer", 11.25, 15));
		mangas.add(new Manga("Blue lock", 7.45, 0));
		
		Iterator<Manga> mangasIterator = mangas.iterator();
		while(mangasIterator.hasNext()){
			if(mangasIterator.next().getQuantidade() == 0)
				mangasIterator.remove();
		}
		
		
		mangas.removeIf(manga -> manga.getQuantidade() == 0);
		System.out.println(mangas);

	}

}
