package listas.Asortlist.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import listas.Asortlist.modelo.Livro;

public class TestSortList01 {

	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<Livro>();

		livros.add(new Livro("A bela e a fera", "Gepete Gahn", LocalDate.of(2020, 10, 20)));
		livros.add(new Livro("João e Maria", "Joe Dash", LocalDate.of(2015, 05, 07)));
		livros.add(new Livro("João e o pé de feijao", "Pedrosa Morais", LocalDate.of(1999, 12, 12)));
		livros.add(new Livro("Pinoquio", "Gepete Gahn", LocalDate.of(2015, 02, 17)));
		livros.add(new Livro("Pinoquio", "Reinaldo Pinto", LocalDate.of(2015, 02, 18)));

		System.out.println("Lista não ordenada");
		for (Livro livro : livros) {
			System.out.println(livro);
			System.out.println("-----------");
		}

		System.out.println("Lista ordenada por ano de lançamento");
		Collections.sort(livros);

		for (Livro livro : livros) {
			System.out.println(livro);
			System.out.println("-----------");
		}

	}

}
