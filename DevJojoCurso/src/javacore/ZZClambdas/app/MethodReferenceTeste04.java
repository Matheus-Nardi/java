package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javacore.ZZClambdas.model.Anime;
import javacore.ZZClambdas.service.AnimeComparator;

//Referencia a construtor
public class MethodReferenceTeste04 {
	public static void main(String[] args) {
		Supplier<AnimeComparator> newAnimeComparators = AnimeComparator::new;
		AnimeComparator animeComparator = newAnimeComparators.get();

		List<Anime> animes = new ArrayList<Anime>(
				Arrays.asList(new Anime("Bersek", 43), new Anime("Dragon Ball Z", 500), new Anime("Blue lock", 30)));
		
		System.out.println(animes);
		
		BiFunction<String, Integer, Anime> animeBiFunction = (title,ep) -> new Anime(title, ep);
		BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
		
		animeBiFunction2.apply("Naturo", 550);
		//Supplier<Anime> animeSupplier = AnimeComparator::new;
	}
}
