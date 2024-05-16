package javacore.ZZDoptional.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javacore.ZZDoptional.model.Manga;

public class MangaRepository {
	private static List<Manga> mangas = List.of(new Manga(1, "Boku no hero", 50), new Manga(2, "Blue Lock", 30),
			new Manga(3, "Demon Slayer", 65));
	
	public static Optional<Manga> mangaByTitle(String title){
		return mangaFilter(manga -> manga.getTitle().equalsIgnoreCase(title));
	}
	
	public static Optional<Manga> mangaById(Integer id){
		return mangaFilter(manga -> manga.getId().equals(id));
	}
	
	
	private static Optional<Manga> mangaFilter(Predicate<Manga> predicate) {
		Manga found = null;
		for (Manga manga : mangas) {
			if(predicate.test(manga))
				found = manga;
		}
		
		return Optional.ofNullable(found);
		
	}
	
	
}
