package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javacore.ZZClambdas.model.Anime;
import javacore.ZZClambdas.service.AnimeComparator;
//Objeto + metodo não estatico
public class MethodReferenceTeste02 {
	public static void main(String[] args) {
		AnimeComparator animeComparator = new AnimeComparator();
		
		List<Anime> animes = new ArrayList<Anime>(Arrays.asList(new Anime("Bersek", 43) , new Anime("Dragon Ball Z", 500) , new Anime("Blue lock", 30)));
		
		 //animes.sort(animeComparator::compareByEpisodesNonStatic);
		 
		 animes.sort((a1,a2) -> animeComparator.compareByEpisodesNonStatic(a1, a2));
		 
		 System.out.println(animes);
	}
}
