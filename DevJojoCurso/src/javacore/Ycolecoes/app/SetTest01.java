package javacore.Ycolecoes.app;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javacore.Ycolecoes.models.Manga;

public class SetTest01 {
	public static void main(String[] args) {

		Set<Manga> mangas = new  HashSet<>();  // Diferencial : não aceita duplicates, não é indexado
		//Importante ter o override de hash e equals
		mangas.add(new Manga("Bersek", 9.55, 0));
		mangas.add(new Manga("Attak on Titan", 10.99, 20));
		mangas.add(new Manga("Demon Slayer", 11.25, 15));
		mangas.add(new Manga("Blue lock", 7.45, 0));
		mangas.add(new Manga("Blue lock", 7.45, 0));
		
		
		for (Manga manga : mangas) {
			System.out.println(manga);
		}
		
		
		//LinkedHashSet -> mantém ordem de inserção
		Set<Manga> mangasLinked = new LinkedHashSet<>();
		mangasLinked.add(new Manga("Bersek", 9.55, 0));
		mangasLinked.add(new Manga("Attak on Titan", 10.99, 20));
		mangasLinked.add(new Manga("Demon Slayer", 11.25, 15));
		mangasLinked.add(new Manga("Blue lock", 7.45, 0));
		mangasLinked.add(new Manga("Blue lock", 7.45, 0));
		System.out.println("-------------");
		for (Manga manga : mangasLinked) {
			System.out.println(manga);
		}
		
		
		
	}
}
