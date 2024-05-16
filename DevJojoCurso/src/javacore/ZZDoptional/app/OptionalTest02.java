package javacore.ZZDoptional.app;

import java.util.Optional;
import java.util.Scanner;

import javacore.ZZDoptional.model.Manga;
import javacore.ZZDoptional.repository.MangaRepository;

public class OptionalTest02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Optional<Manga> mangaByTitle = MangaRepository.mangaByTitle("Demon Slayer");
		mangaByTitle.ifPresent(m -> m.setTitle(scan.nextLine()));
		System.out.println(mangaByTitle);
		
		Manga mangaById = MangaRepository.mangaById(2).orElseThrow(() -> new  IllegalArgumentException("Id invalido"));
		System.out.println(mangaById);
		
		Manga newManga = MangaRepository.mangaByTitle("Pokemon")
			.orElseGet(() -> new Manga(4, "Pokemon", 200));
		
		System.out.println(newManga);
		
		scan.close();
		
	}
}
