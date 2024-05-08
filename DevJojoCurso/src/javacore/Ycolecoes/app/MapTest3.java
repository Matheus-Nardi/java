package javacore.Ycolecoes.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacore.Ycolecoes.models.Consumidor;
import javacore.Ycolecoes.models.Jogador;
import javacore.Ycolecoes.models.Manga;

public class MapTest3 {
	public static void main(String[] args) {

		Consumidor consumidor1 = new Consumidor("Matheus Nardi");
		Consumidor consumidor2 = new Consumidor("Cleiton Rasta");

		Manga manga1 = new Manga("Bersek", 9.55, 0);
		Manga manga2 = new Manga("Attak on Titan", 10.99, 20);
		Manga manga3 = new Manga("Demon Slayer", 11.25, 15);
		Manga manga4 = new Manga("Blue lock", 7.45, 0);

		List<Manga> mangaConsumidor1 = List.of(manga1, manga2, manga3);
		List<Manga> mangaConsumidor2 = new ArrayList<Manga>(Arrays.asList(manga3, manga4));

		mangaConsumidor2.add(manga1);

		Map<Consumidor, List<Manga>> map = new HashMap<Consumidor, List<Manga>>();
		map.put(consumidor1, mangaConsumidor1);
		map.put(consumidor2, mangaConsumidor2);

		for (Map.Entry<Consumidor, List<Manga>> mangas : map.entrySet()) {
			System.out.println(mangas.getKey());
			for (Manga manga : mangas.getValue()) {
				System.out.println(manga.getNome());
			}
		}
	}
}
