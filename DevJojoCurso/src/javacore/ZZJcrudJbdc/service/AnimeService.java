package javacore.ZZJcrudJbdc.service;

import java.util.Optional;
import java.util.Scanner;

import javacore.ZZJcrudJbdc.app.CrudTest01;
import javacore.ZZJcrudJbdc.domain.Anime;
import javacore.ZZJcrudJbdc.repository.AnimeRepository;
import javacore.ZZJcrudJbdc.repository.ProducerRepository;

public class AnimeService {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void menu(int op) {
		switch (op) {
		case 0 -> System.exit(0);
		case 1 -> findByName();
		case 2 -> delete();
		case 3 -> save();
		case 4 -> update();
		}
	}

	private static void findByName() {
		System.out.println("Type the name or empty to all:");
		String name = SCANNER.nextLine();
		AnimeRepository.findByName(name).forEach(a -> System.out.printf("ID: [%d] |NAME: [%s] |EPISODES: [%d] |PRODUCER: [%s]%n", a.getId(),
				a.getName(), a.getEpisodes(), a.getProducer().getName()));

	}

	private static void delete() {
		System.out.println("Type the id of the anime you want to delete:");

		Integer id = Integer.parseInt(SCANNER.nextLine());
		System.out.println("Are you sure ? Y|N");
		boolean choise = SCANNER.nextLine().equalsIgnoreCase("Y") ? true : false;
		if (choise) {
			AnimeRepository.delete(id);
		} else
			return;

	}

	private static void save() {
		System.out.println("Type the name of anime:");
		String producerName = SCANNER.nextLine();
		System.out.println("Type the number of episodes:");
		Integer episodes = Integer.parseInt(SCANNER.nextLine());
		System.out.println("Type the id of  producer:");
		Integer producerId = Integer.parseInt(SCANNER.nextLine());
		Anime anime = Anime.builder().name(producerName)
				.episodes(episodes).
				producer(ProducerRepository.findById(producerId).get())
				.build();
		AnimeRepository.save(anime);
	}

	private static void update() {
		System.out.println("Type the id of the anime you want to update:");
		Integer id = Integer.parseInt(SCANNER.nextLine());
		Optional<Anime> animeOptional = AnimeRepository.findById(id);
		if (animeOptional.isEmpty())
			return;

		Anime animeFromDB = animeOptional.get();
		System.out.println(animeFromDB);
		System.out.println("Type the new name of anime:");
		String animeName = SCANNER.nextLine();
		System.out.println("Type the new number of  episodes:");
		Integer episodes = Integer.parseInt(SCANNER.nextLine());
		Anime animeToUpdate = Anime.builder().id(animeFromDB.getId()).name(animeName).episodes(episodes)
				.producer(animeFromDB.getProducer()).build();
		AnimeRepository.update(animeToUpdate);
	}
}
