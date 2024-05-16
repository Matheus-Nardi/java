package javacore.ZZClambdas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javacore.ZZClambdas.model.Anime;
import javacore.ZZClambdas.service.AnimeComparator;
// Classe + metodo statico
public class MethodReferenceTeste01 {
	public static void main(String[] args) {
		List<Anime> animes = new ArrayList<Anime>(Arrays.asList(new Anime("Bersek", 43) , new Anime("Dragon Ball Z", 500) , new Anime("Blue lock", 30)));
		
	//	Collections.sort(animes, (a1,a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
		Collections.sort(animes, AnimeComparator::compareByTitle); //Criando o method reference(quando tem apenas 1 chamada de método)
		animes.sort(AnimeComparator::compareByEpisodes);
		
		System.out.println(animes);
		//Uma forma de permitir o method reference é criar o meu proprio compareTo
		//esse exemplo é um method reference para metodos static
		
	}
}
