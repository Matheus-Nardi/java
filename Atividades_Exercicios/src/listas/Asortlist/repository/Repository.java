package listas.Asortlist.repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import listas.Asortlist.modelo.ClassificaoIndicativa;
import listas.Asortlist.modelo.Filme;

public class Repository {

	public static List<Filme> returnDefaultMovies(){
		return new ArrayList<Filme>(Arrays.asList(
	            new Filme("O Poderoso Chefão",
	                "Uma família mafiosa luta para estabelecer sua supremacia nos Estados Unidos depois da Segunda Guerra Mundial. Uma tentativa de assassinato deixa o chefão Vito Corleone incapacitado e força os filhos Michael e Sonny a assumir os negócios.",
	                Duration.ofMinutes(175L),
	                LocalDate.of(1972, 7, 7),
	                ClassificaoIndicativa.MAIOR_18),
	            new Filme("Interestelar",
	                "Um grupo de astronautas viaja através de um buraco de minhoca em busca de um novo lar para a humanidade, enfrentando desafios cósmicos e temporais ao longo do caminho.",
	                Duration.ofMinutes(169L),
	                LocalDate.of(2014, 11, 7),
	                ClassificaoIndicativa.MAIOR_12),
	            new Filme("A Origem",
	                "Um ladrão especializado em extrair informações do subconsciente de suas vítimas durante o sono é contratado para implantar uma ideia na mente de um CEO.",
	                Duration.ofMinutes(148L),
	                LocalDate.of(2010, 7, 16),
	                ClassificaoIndicativa.MAIOR_16)
	        ));
	}
}
